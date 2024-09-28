package dao;

import dao.DBconnect;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComboBox;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import pojo.Order;
import pojo.ThanhToan;

/**
 *
 * @author ADMIN
 */
public class Order_DAO extends DBconnect {

    private static final Map<String, String> tableMapping = new HashMap<>();
    private static final Logger LOGGER = Logger.getLogger(Order_DAO.class.getName());
    private Object jPanel1;
    private Object orderDAO;
    private String selectedTableId;

    private static String getTableId(String displayName) {
        return tableMapping.get(displayName);
    }

    private void setSelectedTable(String tableDisplayName) {
        selectedTableId = getTableId(tableDisplayName);
        System.out.println("Số bàn được chọn: " + selectedTableId);
    }

    public List<Order> getOrdersWithTableNumber() {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = DBconnect.getConnection()) {
            String query = "SELECT m.TenMon, c.SoLuong, m.DonGia, b.Ban\n"
                    + "FROM ChiTietDonHang c\n"
                    + "INNER JOIN DonHang dh ON c.MaDH = dh.MaDH\n"
                    + "INNER JOIN Menu m ON c.MaMon = m.MaMon\n"
                    + "INNER JOIN Ban b ON dh.SoBan = b.SoBan\n"
                    + "WHERE dh.Status = 1;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String tenMon = resultSet.getString("TenMon");
                    int soLuong = resultSet.getInt("SoLuong");
                    int donGia = resultSet.getInt("DonGia");
                    String soBan = resultSet.getString("Ban");

                    orders.add(new Order(tenMon, soLuong, donGia, soBan));

                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Lỗi kết nối cơ sở dữ liệu: {0}", ex.getMessage());
        }
        return orders;
    }

    /**
     *
     * @return
     */
    public void loadMenuComboBox(JComboBox<String> cmBMenu) {
        System.out.println("Đang tải dữ liệu vào ComboBox...");
        try (Connection connection = DBconnect.getConnection()) {
            String query = "SELECT TenMon FROM Menu";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
                cmBMenu.removeAllItems(); // Xóa tất cả các mục hiện có trong ComboBox
                System.out.println("Đã xóa các mục hiện tại...");

                while (resultSet.next()) {
                    String tenMon = resultSet.getString("TenMon");
                    cmBMenu.addItem(tenMon);
                    System.out.println("Đã thêm mục: " + tenMon);
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Lỗi kết nối cơ sở dữ liệu: {0}", ex.getMessage());
        }
    }

    public void addOrder(String tenMon, int soLuong, int donGia, String soBan, String maNV) {
        Connection connection = null;
        PreparedStatement createOrderStmt = null;
        PreparedStatement addOrderDetailStmt = null;

        try {
            connection = DBconnect.getConnection();
            connection.setAutoCommit(false); // Bắt đầu giao dịch

            // Kiểm tra giá trị SoBan trong bảng Ban trước khi thêm đơn hàng
            System.out.println("Giá trị của biến soBan: " + soBan);
            if (!isTableValid(connection, soBan)) {
                throw new SQLException("Số bàn không hợp lệ.");
            }

            // Tạo câu lệnh SQL để thêm đơn hàng mới vào cơ sở dữ liệu
            String addOrderQuery = "INSERT INTO DonHang (MaDH, SoBan, MaNV, NgayDat, TongTien) VALUES (?, ?, ?, ?, ?)";
            createOrderStmt = connection.prepareStatement(addOrderQuery, Statement.RETURN_GENERATED_KEYS);
            String maDH = generateNextOrderID(); // Tạo mã đơn hàng mới

            createOrderStmt.setString(1, maDH); // Thêm mã đơn hàng vào câu lệnh SQL
            createOrderStmt.setString(2, soBan); // Thêm số bàn vào câu lệnh SQL
            createOrderStmt.setString(3, maNV); // Thêm mã nhân viên vào câu lệnh SQL
            createOrderStmt.setDate(4, new java.sql.Date(new Date().getTime())); // Thêm ngày đặt vào câu lệnh SQL
            createOrderStmt.setInt(5, soLuong * donGia); // Thêm tổng tiền vào câu lệnh SQL

            // Thực thi câu lệnh SQL để thêm đơn hàng mới
            int affectedRows = createOrderStmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Tạo đơn hàng thất bại, không có hàng hóa nào được thêm vào.");
            }

            // Thêm chi tiết đơn hàng vào cơ sở dữ liệu
            String addOrderDetailQuery = "INSERT INTO ChiTietDonHang (MaDH, MaMon, SoLuong, ThanhTien) VALUES (?, (SELECT MaMon FROM Menu WHERE TenMon = ?), ?, ?)";
            addOrderDetailStmt = connection.prepareStatement(addOrderDetailQuery);
            addOrderDetailStmt.setString(1, maDH); // Thêm mã đơn hàng vào câu lệnh SQL
            addOrderDetailStmt.setString(2, tenMon); // Thêm tên món vào câu lệnh SQL
            addOrderDetailStmt.setInt(3, soLuong); // Thêm số lượng vào câu lệnh SQL
            addOrderDetailStmt.setInt(4, soLuong * donGia); // Thêm thành tiền vào câu lệnh SQL

            // Thực thi câu lệnh SQL để thêm chi tiết đơn hàng
            int rowsInserted = addOrderDetailStmt.executeUpdate();
            if (rowsInserted == 0) {
                throw new SQLException("Tạo chi tiết đơn hàng thất bại, không có hàng hóa nào được thêm vào.");
            }

            connection.commit(); // Commit giao dịch
        } catch (SQLException ex) {
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback giao dịch nếu có lỗi
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Lỗi khi rollback giao dịch: {0}", e.getMessage());
                }
            }
            LOGGER.log(Level.SEVERE, "Lỗi khi thêm đơn hàng: {0}", ex.getMessage());
        }
    }

    public String generateNextOrderID() {
        String nextOrderID = "DH001";
        try (Connection connection = DBconnect.getConnection()) {
            String query = "SELECT MAX(MaDH) FROM DonHang";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    String maxOrderID = rs.getString(1);
                    if (maxOrderID != null) {
                        int sequenceNumber = Integer.parseInt(maxOrderID.substring(2));
                        sequenceNumber++;
                        nextOrderID = String.format("DH%03d", sequenceNumber);
                    }
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Lỗi khi tạo mã đơn hàng: {0}", ex.getMessage());
        }
        return nextOrderID;
    }

    public String getSoBanFromTableName(String tableName) {
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String soBan = null;

        try {
            connection = DBconnect.getConnection();
            String query = "SELECT SoBan FROM Ban WHERE Ban = ?";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, tableName);
            rs = stmt.executeQuery();

            if (rs.next()) {
                soBan = rs.getString("SoBan");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return soBan;
    }

    public int getPriceOfMenuItem(String tenMon) {
        int donGia = 0;
        try (Connection connection = DBconnect.getConnection()) {
            String query = "SELECT DonGia FROM Menu WHERE TenMon = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, tenMon);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        donGia = resultSet.getInt("DonGia");
                    }
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Lỗi khi truy vấn giá món: {0}", ex.getMessage());
        }
        return donGia;
    }

    private boolean isTableValid(Connection connection, String soBan) throws SQLException {
        String checkTableQuery = "SELECT COUNT(*) FROM Ban WHERE SoBan = ?";
        try (PreparedStatement checkTableStmt = connection.prepareStatement(checkTableQuery)) {
            checkTableStmt.setString(1, soBan);
            try (ResultSet rs = checkTableStmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    private String getCurrentOrderID(String tenMon, String soBan) {
        String orderID = null;
        try (Connection connection = DBconnect.getConnection(); PreparedStatement statement = connection.prepareStatement(
                "SELECT MaDH FROM DonHang dh JOIN ChiTietDonHang ct ON dh.MaDH = ct.MaDH WHERE ct.TenMon = ? AND dh.SoBan = ?")) {
            statement.setString(1, tenMon);
            statement.setString(2, soBan);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                orderID = resultSet.getString("MaDH");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Lỗi khi lấy mã đơn hàng: {0}", e.getMessage());
        }
        return orderID;
    }

    public void deleteOrder(String tenMon, int soLuong, int donGia) {
        Connection connection = null;
        PreparedStatement deleteOrderStmt = null;

        try {
            connection = DBconnect.getConnection();
            connection.setAutoCommit(false);

            String deleteChiTietDonHangQuery = "DELETE FROM ChiTietDonHang WHERE MaMon = (SELECT MaMon FROM Menu WHERE TenMon = ?) AND SoLuong = ? AND ThanhTien = ?";
            PreparedStatement deleteChiTietDonHangStmt = connection.prepareStatement(deleteChiTietDonHangQuery);
            deleteChiTietDonHangStmt.setString(1, tenMon);
            deleteChiTietDonHangStmt.setInt(2, soLuong);
            deleteChiTietDonHangStmt.setInt(3, soLuong * donGia);

            deleteChiTietDonHangStmt.executeUpdate();

            String deleteDonHangQuery = "DELETE FROM DonHang WHERE NOT EXISTS (SELECT 1 FROM ChiTietDonHang WHERE DonHang.MaDH = ChiTietDonHang.MaDH)";
            PreparedStatement deleteDonHangStmt = connection.prepareStatement(deleteDonHangQuery);

            deleteDonHangStmt.executeUpdate();

            connection.commit();
        } catch (SQLException ex) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Lỗi khi rollback giao dịch: {0}", e.getMessage());
                }
            }
            LOGGER.log(Level.SEVERE, "Lỗi khi xóa đơn hàng: {0}", ex.getMessage());
        } finally {

            if (deleteOrderStmt != null) {
                try {
                    deleteOrderStmt.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Lỗi khi đóng PreparedStatement: {0}", ex.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Lỗi khi đóng Connection: {0}", ex.getMessage());
                }
            }
        }
    }

    private boolean isOrderExists(String maDH) {
        boolean exists = false;
        Connection connection = null;
        PreparedStatement checkOrderStmt = null;
        ResultSet resultSet = null;

        try {
            connection = DBconnect.getConnection();

            String checkOrderQuery = "SELECT COUNT(*) FROM DonHang WHERE MaDH = ?";
            checkOrderStmt = connection.prepareStatement(checkOrderQuery);
            checkOrderStmt.setString(1, maDH);
            resultSet = checkOrderStmt.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);

                exists = count > 0;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Lỗi khi kiểm tra sự tồn tại của đơn hàng: {0}", ex.getMessage());
        } finally {

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Lỗi khi đóng ResultSet: {0}", e.getMessage());
                }
            }
            if (checkOrderStmt != null) {
                try {
                    checkOrderStmt.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Lỗi khi đóng PreparedStatement: {0}", e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "Lỗi khi đóng Connection: {0}", e.getMessage());
                }
            }
        }
        return exists;
    }

    public int getTotalAmountForTable(String soBan) {
        int totalAmount = 0;
        try (Connection connection = DBconnect.getConnection()) {
            String query = "SELECT SUM(c.SoLuong * m.DonGia) as Total FROM ChiTietDonHang c "
                    + "INNER JOIN DonHang dh ON c.MaDH = dh.MaDH "
                    + "INNER JOIN Menu m ON c.MaMon = m.MaMon "
                    + "WHERE dh.SoBan = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, soBan);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        totalAmount = resultSet.getInt("Total");
                    }
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Lỗi khi truy vấn tổng tiền: {0}", ex.getMessage());
        }
        return totalAmount;
    }

    public String getPaymentIdForTable(String selectedTableId) {
        String maThanhToan = ""; // Khởi tạo mã thanh toán

        try (Connection connection = DBconnect.getConnection()) {
            String query = "SELECT MaTT FROM ThanhToan WHERE MaDH IN (SELECT MaDH FROM Ban WHERE SoBan = ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, selectedTableId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        maThanhToan = resultSet.getString("MaTT");
                    }
                }
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Lỗi khi truy vấn mã thanh toán: {0}", ex.getMessage());
        }

        return maThanhToan;
    }

}
