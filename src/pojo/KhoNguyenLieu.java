
package pojo;


public class KhoNguyenLieu {
    private String maNL;
    private String tenNL;
    private String ngayNhap;
    private int soLuong;
    private String donViTinh;
    private float donGia;
    private String maNV;

    // Constructors, Getters, and Setters
    public KhoNguyenLieu() {}

    public KhoNguyenLieu(String maNL, String tenNL, String ngayNhap, int soLuong, String donViTinh, float donGia, String maNV) {
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.ngayNhap = ngayNhap;
        this.soLuong = soLuong;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
        this.maNV = maNV;
    }

    public String getMaNL() {
        return maNL;
    }

    public void setMaNL(String maNL) {
        this.maNL = maNL;
    }

    public String getTenNL() {
        return tenNL;
    }

    public void setTenNL(String tenNL) {
        this.tenNL = tenNL;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
}