package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import pojo.KhoNguyenLieu;
import util.DBConnection;

public class KhoNguyenLieuDAO {

    private Connection conn;

    public KhoNguyenLieuDAO() {
        try {
            conn = DBConnection.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<KhoNguyenLieu> getAllNguyenLieu() {
        List<KhoNguyenLieu> list = new ArrayList<>();
        String query = "SELECT * FROM KhoNguyenLieu";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                KhoNguyenLieu nl = new KhoNguyenLieu(
                        rs.getString("MaNL"),
                        rs.getString("TenNL"),
                        rs.getString("NgayNhap"),
                        rs.getInt("SoLuong"),
                        rs.getString("DonViTinh"),
                        rs.getFloat("DonGia"),
                        rs.getString("MaNV")
                );
                list.add(nl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insertNguyenLieu(KhoNguyenLieu nl) {
        String query = "INSERT INTO KhoNguyenLieu (MaNL, TenNL, NgayNhap, SoLuong, DonViTinh, DonGia, MaNV) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nl.getMaNL());
            pstmt.setString(2, nl.getTenNL());
            pstmt.setDate(3, Date.valueOf(nl.getNgayNhap()));
            pstmt.setInt(4, nl.getSoLuong());
            pstmt.setString(5, nl.getDonViTinh());
            pstmt.setFloat(6, nl.getDonGia());
            pstmt.setString(7, nl.getMaNV());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateNguyenLieu(KhoNguyenLieu nl) {
        String query = "UPDATE KhoNguyenLieu SET TenNL = ?, NgayNhap = ?, SoLuong = ?, DonViTinh = ?, DonGia = ?, MaNV = ? WHERE MaNL = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nl.getTenNL());
            pstmt.setDate(2, Date.valueOf(nl.getNgayNhap()));
            pstmt.setInt(3, nl.getSoLuong());
            pstmt.setString(4, nl.getDonViTinh());
            pstmt.setFloat(5, nl.getDonGia());
            pstmt.setString(6, nl.getMaNV());
            pstmt.setString(7, nl.getMaNL());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteNguyenLieu(String maNL) {
        String query = "DELETE FROM KhoNguyenLieu WHERE MaNL = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maNL);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<KhoNguyenLieu> searchNguyenLieu(String keyword) {
        List<KhoNguyenLieu> list = new ArrayList<>();
        String query = "SELECT * FROM KhoNguyenLieu WHERE TenNL LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                KhoNguyenLieu nl = new KhoNguyenLieu(
                        rs.getString("MaNL"),
                        rs.getString("TenNL"),
                        rs.getString("NgayNhap"),
                        rs.getInt("SoLuong"),
                        rs.getString("DonViTinh"),
                        rs.getFloat("DonGia"),
                        rs.getString("MaNV")
                );
                list.add(nl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
