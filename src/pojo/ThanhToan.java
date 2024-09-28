package pojo;

import java.util.Date;

public class ThanhToan {
    private String maThanhToan;
    private String maDonHang;
    private String maNV;

    private int tongTien;

    // Constructor
public ThanhToan(String maThanhToan, String maDonHang, String maNV, Date date, int tongTien) {
    this.maThanhToan = maThanhToan;
    this.maDonHang = maDonHang;
    this.maNV = maNV;
    
    this.tongTien = tongTien;
}


    // Các phương thức getter và setter
    public String getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(String maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }


    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    // toString method
    @Override
    public String toString() {
        return "ThanhToan{" +
                "maThanhToan='" + maThanhToan + '\'' +
                ", maDonHang='" + maDonHang + '\'' +
                ", maNV='" + maNV + '\'' +
               
                ", tongTien=" + tongTien +
                '}';
    }
}
