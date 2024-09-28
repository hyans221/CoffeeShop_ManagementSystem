package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.DangNhap;
import pojo.NhanVien;
import util.DBConnection;

public class DangNhapDAO { 
     private Connection conn;
    public DangNhap login(String tenDangNhap, String matKhau) {
        DangNhap dangNhap = null;
        String query = "SELECT * FROM DangNhap WHERE TenDangNhap = ? AND MatKhau = ?";
        
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, tenDangNhap);
            stmt.setString(2, matKhau);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                dangNhap = new DangNhap();
                dangNhap.setMaTK(rs.getString("MaTK"));
                dangNhap.setMaNV(rs.getString("MaNV"));
                dangNhap.setTenDangNhap(rs.getString("TenDangNhap"));
                dangNhap.setMatKhau(rs.getString("MatKhau"));
                dangNhap.setQuyen(rs.getString("Quyen"));
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Xử lý ngoại lệ ClassNotFoundException
            e.printStackTrace();
        }
        
        return dangNhap;
    }

    public String loginAndGetEmployeeId(String username, String password) {
    String maNV = null;
    // Kiểm tra xem username và password có tồn tại trong cơ sở dữ liệu không
    String query = "SELECT MaNV FROM DangNhap WHERE TenDangNhap = ? AND MatKhau = ?";
    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                // Nếu có, lấy mã nhân viên từ kết quả truy vấn
                maNV = rs.getString("MaNV");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return maNV;
}

    public List<DangNhap> getAllTKNguoiDung() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
