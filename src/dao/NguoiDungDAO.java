package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import pojo.DangNhap;

public class NguoiDungDAO {

    private Connection conn;

    public NguoiDungDAO() {
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                System.out.println("Database connection established.");
            } else {
                System.out.println("Failed to establish database connection.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<DangNhap> getAllTKNguoiDung() {
        List<DangNhap> list = new ArrayList<>();
        if (conn != null) {
            String query = "SELECT * FROM DangNhap";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    DangNhap dn = new DangNhap();
                    dn.setMaTK(rs.getString("MaTK"));
                    dn.setMaNV(rs.getString("MaNV"));
                    dn.setTenDangNhap(rs.getString("TenDangNhap"));
                    dn.setMatKhau(rs.getString("MatKhau"));
                    dn.setQuyen(rs.getString("Quyen"));
                    list.add(dn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public boolean insertTKNguoiDung(DangNhap dn) {
        String query = "INSERT INTO DangNhap (MaTK, MaNV, TenDangNhap, MatKhau, Quyen) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, dn.getMaTK());
            pstmt.setString(2, dn.getMaNV());
            pstmt.setString(3, dn.getTenDangNhap());
            pstmt.setString(4, dn.getMatKhau());
            pstmt.setString(5, dn.getQuyen());
            System.out.println("Executing query: " + pstmt);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateTKNguoiDung(DangNhap dn) {
        String query = "UPDATE DangNhap SET MaNV = ?, TenDangNhap = ?, MatKhau = ?, Quyen = ? WHERE MaTK = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, dn.getMaNV());
            pstmt.setString(2, dn.getTenDangNhap());
            pstmt.setString(3, dn.getMatKhau());
            pstmt.setString(4, dn.getQuyen());
            pstmt.setString(5, dn.getMaTK());
            System.out.println("Executing query: " + pstmt);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTKNguoiDung(String maTK) {
        String query = "DELETE FROM DangNhap WHERE MaTK = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maTK);
            System.out.println("Executing query: " + pstmt);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<DangNhap> searchTKNguoiDungByName(String tenDN) {
        List<DangNhap> list = new ArrayList<>();
        String query = "SELECT * FROM DangNhap WHERE TenDangNhap LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "%" + tenDN + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    DangNhap dn = new DangNhap();
                    dn.setMaTK(rs.getString("MaTK"));
                    dn.setMaNV(rs.getString("MaNV"));
                    dn.setTenDangNhap(rs.getString("TenDangNhap"));
                    dn.setMatKhau(rs.getString("MatKhau"));
                    dn.setQuyen(rs.getString("Quyen"));
                    list.add(dn);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<String> getAllMaNV() {
        List<String> list = new ArrayList<>();
        String query = "SELECT MaNV FROM NhanVien";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                list.add(rs.getString("MaNV"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
