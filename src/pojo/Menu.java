package pojo;

import javax.swing.ImageIcon;

/**
 *
 * @author Thy
 */
public class Menu {
    private String maMon;
    private String tenMon;
    private int donGia;
    private String hinhAnh;

    // Constructors, Getters, and Setters
    public Menu() {}

    public Menu(String maMon, String tenMon, int donGia, String hinhAnh) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.donGia = donGia;
        this.hinhAnh = hinhAnh;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
