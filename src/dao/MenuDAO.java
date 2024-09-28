package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import pojo.Menu;
import util.DBConnection;
import javax.swing.ImageIcon;

public class MenuDAO {

    private Connection conn;

    public MenuDAO() {
        try {
            conn = DBConnection.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insertMenu(Menu menu) {
        String query = "INSERT INTO Menu (MaMon, TenMon, DonGia, HinhAnh) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, menu.getMaMon());
            pstmt.setString(2, menu.getTenMon());
            pstmt.setInt(3, menu.getDonGia());
//            pstmt.setString(4, menu.getHinhAnh().getDescription());
            pstmt.setString(4, menu.getHinhAnh());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Menu> getAllMenu() {
        List<Menu> list = new ArrayList<>();
        if (conn != null) {
            String query = "SELECT * FROM Menu";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setMaMon(rs.getString("MaMon"));
                    menu.setTenMon(rs.getString("TenMon"));
                    menu.setDonGia(rs.getInt("DonGia"));
                    String imageName = rs.getString("HinhAnh"); // Lấy tên tệp hình ảnh
                    menu.setHinhAnh(imageName); // Lưu tên tệp hình ảnh

                    list.add(menu);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public boolean deleteMenu(String maMon) {
        String query = "DELETE FROM Menu WHERE MaMon = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, maMon);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateMenu(Menu menu) {
        String query = "UPDATE Menu SET TenMon = ?, DonGia = ?, HinhAnh = ? WHERE MaMon = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, menu.getTenMon());
            pstmt.setInt(2, menu.getDonGia());
//            pstmt.setString(3, menu.getHinhAnh().getDescription());
            pstmt.setString(3, menu.getHinhAnh());
            pstmt.setString(4, menu.getMaMon());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Menu> searchMenu(String keyword) {
        List<Menu> list = new ArrayList<>();
        if (conn != null) {
            String query = "SELECT * FROM Menu WHERE TenMon LIKE ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, "%" + keyword + "%");
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Menu menu = new Menu();
                    menu.setMaMon(rs.getString("MaMon"));
                    menu.setTenMon(rs.getString("TenMon"));
                    menu.setDonGia(rs.getInt("DonGia"));
                    String imageName = rs.getString("HinhAnh");
                    menu.setHinhAnh(imageName);

//                    menu.setHinhAnh(rs.getString("HinhAnh"));
//                    String imagePath = rs.getString("HinhAnh");
//                    ImageIcon imageIcon = new ImageIcon(imagePath); 
//                    menu.setHinhAnh(imageIcon);
                    list.add(menu);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    //    public List<Menu> getAllMenu() {
//        List<Menu> list = new ArrayList<>();
//        if (conn != null) {
//            String query = "SELECT * FROM Menu";
//            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
//                while (rs.next()) {
//                    Menu menu = new Menu();
//                    menu.setMaMon(rs.getString("MaMon"));
//                    menu.setTenMon(rs.getString("TenMon"));
//                    menu.setDonGia(rs.getInt("DonGia"));
//                    String imagePath = rs.getString("HinhAnh");
//                    ImageIcon imageIcon;
//                    java.net.URL imgUrl = getClass().getResource("/img/" + imagePath);
//                    if (imgUrl != null) {
//                        imageIcon = new ImageIcon(imgUrl);
//                    } else {
//                        System.err.println("Không tìm thấy hình ảnh: " + imagePath + ", sử dụng hình mặc định.");
//                        imgUrl = getClass().getResource("/img/default.jpg");
//                        if (imgUrl != null) {
//                            imageIcon = new ImageIcon(imgUrl);
//                        } else {
//                            System.err.println("Không tìm thấy hình ảnh mặc định: default.jpg");
//                            imageIcon = null;
//                        }
//                    }
//                    menu.setHinhAnh(imageIcon);
//
//                    list.add(menu);
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return list;
//    }
}
