package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class ThanhToan_DAO {


 public void addPaymentToDatabase(String selectedTableId, int totalAmount, String maNV, String maDonHang) {
    try (Connection connection = DBconnect.getConnection()) {
        String maThanhToan = generateNextPaymentID();

        String query = "INSERT INTO ThanhToan (MaTT, MaDH, MaNV, NgayTT, TongTien) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, maThanhToan);
            preparedStatement.setString(2, maDonHang);
            preparedStatement.setString(3, maNV);
            preparedStatement.setTimestamp(4, new java.sql.Timestamp(new Date().getTime()));
            preparedStatement.setInt(5, totalAmount);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                
            

                JOptionPane.showMessageDialog(null, "Đã thanh toán thành công!.");
            } else {
                JOptionPane.showMessageDialog(null, "Lỗi: Không thể thêm dữ liệu vào CSDL.");
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Lỗi khi thêm thanh toán vào CSDL: " + ex.getMessage());
    }
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
      
    }

    return maThanhToan;
}


public String getOrderIdForTable(String selectedTableId) {
    String maDonHang = ""; 

    try (Connection connection = DBconnect.getConnection()) {
        String query = "SELECT MaDH FROM DonHang WHERE SoBan = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, selectedTableId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    maDonHang = resultSet.getString("MaDH");
                }
            }
        }
    } catch (SQLException ex) {
        // Xử lý ngoại lệ
    }

    return maDonHang;
}



public String generateNextPaymentID() {
    String nextPaymentID = "TT001"; 
    try (Connection connection = DBconnect.getConnection()) {
        String query = "SELECT MAX(MaTT) FROM ThanhToan"; // Lấy mã thanh toán lớn nhất
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String maxPaymentID = rs.getString(1); // Lấy mã thanh toán lớn nhất
                if (maxPaymentID != null) {
                    int sequenceNumber = Integer.parseInt(maxPaymentID.substring(2)); // Lấy phần số thứ tự của mã thanh toán
                    sequenceNumber++; // Tăng số thứ tự lên 1
                    nextPaymentID = String.format("TT%03d", sequenceNumber); // Tạo mã thanh toán mới
                }
            }
        }
    } catch (SQLException ex) {
      
    }
    return nextPaymentID;
}

 
}
