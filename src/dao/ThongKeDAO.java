package dao;

import pojo.Ban;
import pojo.ChiTietDonHang;
import pojo.DonHang;
import pojo.Order;
import pojo.Menu;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThongKeDAO {
  
//    private Connection conn;
//
//    public ThongKeDAO() {
//        try {
//            conn = DBConnection.getConnection();
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public List<Order> getOrderList() {
        List<Order> orderList = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM DonHang";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String maDH = rs.getString("MaDH");
                String soBan = rs.getString("SoBan");
                String maNV = rs.getString("MaNV");
                String ngayDatStr = rs.getString("NgayDat");
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date ngayDat = null;
                try {
                    ngayDat = dateFormat.parse(ngayDatStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int tongTien = rs.getInt("TongTien");

                Order order = new Order(maDH, soBan, maNV, ngayDat, tongTien);
                order.setChiTietDonHangList(getChiTietDonHangList(maDH));
                orderList.add(order);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public List<ChiTietDonHang> getChiTietDonHangList(String maDH) {
        List<ChiTietDonHang> chiTietDonHangList = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM ChiTietDonHang WHERE MaDH = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, maDH);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String maMon = rs.getString("MaMon");
                int soLuong = rs.getInt("SoLuong");
                int thanhTien = rs.getInt("ThanhTien");

                ChiTietDonHang chiTiet = new ChiTietDonHang(maDH, maMon, soLuong, thanhTien);
                chiTietDonHangList.add(chiTiet);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return chiTietDonHangList;
    }

    public int getTongSoHoaDon() {
        int tongSoHoaDon = 0;
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT COUNT(*) FROM DonHang";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                tongSoHoaDon = rs.getInt(1);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return tongSoHoaDon;
    }

    public int getTienThuVe(List<Order> orderList) {
        int tienThuVe = 0;
        for (Order order : orderList) {
            tienThuVe += order.getTongTien();
        }
        return tienThuVe;
    }

    public List<Order> getOrderListByDate(String startDate, String endDate) {
        List<Order> orderList = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM DonHang WHERE ngayDat BETWEEN ? AND ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, startDate);
            stmt.setString(2, endDate);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String maDH = rs.getString("MaDH");
                String soBan = rs.getString("SoBan");
                String maNV = rs.getString("MaNV");
                String ngayDatStr = rs.getString("NgayDat");
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
                Date ngayDat = null;
                try {
                    ngayDat = dateFormat.parse(ngayDatStr);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                int tongTien = rs.getInt("TongTien");

                Order order = new Order(maDH, soBan, maNV, ngayDat, tongTien);
                order.setChiTietDonHangList(getChiTietDonHangList(maDH));
                orderList.add(order);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public ArrayList<Ban> getBanList() {
        ArrayList<Ban> banList = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM Ban";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String soBan = rs.getString("SoBan");
                String tinhTrang = rs.getString("TinhTrang");

                Ban ban = new Ban(soBan, tinhTrang);
                banList.add(ban);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return banList;
    }

    public ArrayList<Menu> getThucDonList() {
        ArrayList<Menu> thucDonList = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM Menu";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String maMon = rs.getString("MaMon");
                String tenMon = rs.getString("TenMon");
                int donGia = rs.getInt("DonGia");
                String hinhAnh = rs.getString("HinhAnh");

                Menu menu = new Menu(maMon, tenMon, donGia, hinhAnh);
                thucDonList.add(menu);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return thucDonList;
    }
}
