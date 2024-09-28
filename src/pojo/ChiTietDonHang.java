package pojo;

/**
 *
 * @author Thy
 */
public class ChiTietDonHang {
    private String maDH;
    private String maMon;
    private int soLuong;
    private int thanhTien;

    // Constructors, Getters, and Setters
    public ChiTietDonHang() {}

    public ChiTietDonHang(String maDH, String maMon, int soLuong, int thanhTien) {
        this.maDH = maDH;
        this.maMon = maMon;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
}
