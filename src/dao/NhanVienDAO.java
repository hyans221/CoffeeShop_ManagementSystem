package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import pojo.NhanVien;
import util.DBConnection;

public class NhanVienDAO {

    private Connection conn;

    public NhanVienDAO() {
        try {
            conn = DBConnection.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> list = new ArrayList<>();
        if (conn != null) {
            String query = "SELECT * FROM NhanVien";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    NhanVien nv = new NhanVien();
                    nv.setMaNV(rs.getString("MaNV"));
                    nv.setTenNV(rs.getString("TenNV"));
                    nv.setSdt(rs.getString("SDT"));
                    nv.setNgaySinh(rs.getString("NgaySinh"));
                    nv.setLoaiNV(rs.getString("LoaiNV"));
                    list.add(nv);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public List<String> getAllMaNV() {
        List<String> listMaNV = new ArrayList<>();
        String query = "SELECT MaNV FROM NhanVien";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                listMaNV.add(rs.getString("MaNV"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMaNV;
    }

    public boolean insertNhanVien(NhanVien nv) {
        String query = "INSERT INTO NhanVien (MaNV, TenNV, SDT, NgaySinh, LoaiNV) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nv.getMaNV());
            pstmt.setString(2, nv.getTenNV());
            pstmt.setString(3, nv.getSdt());
            pstmt.setString(4, nv.getNgaySinh());
            pstmt.setString(5, nv.getLoaiNV());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateNhanVien(NhanVien nv) {
        String query = "UPDATE NhanVien SET TenNV = ?, SDT = ?, NgaySinh = ?, LoaiNV = ? WHERE MaNV = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nv.getTenNV());
            pstmt.setString(2, nv.getSdt());
            pstmt.setString(3, nv.getNgaySinh());
            pstmt.setString(4, nv.getLoaiNV());
            pstmt.setString(5, nv.getMaNV());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteNhanVien(String maNV) {
        String query = "DELETE FROM NhanVien WHERE MaNV = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maNV);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<NhanVien> searchNhanVienByName(String tenNV) {
        List<NhanVien> list = new ArrayList<>();
        String query = "SELECT * FROM NhanVien WHERE TenNV LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "%" + tenNV + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    NhanVien nv = new NhanVien();
                    nv.setMaNV(rs.getString("MaNV"));
                    nv.setTenNV(rs.getString("TenNV"));
                    nv.setSdt(rs.getString("SDT"));
                    nv.setNgaySinh(rs.getString("NgaySinh"));
                    nv.setLoaiNV(rs.getString("LoaiNV"));
                    list.add(nv);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
