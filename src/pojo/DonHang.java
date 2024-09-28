package pojo;

/**
 *
 * @author Thy
 */
public class DonHang {
    private String maDH;
    private String soBan;
    private String maNV;
    private String ngayDat;
    private int tongTien;

    // Constructors, Getters, and Setters
    public DonHang() {}

    public DonHang(String maDH, String soBan, String maNV, String ngayDat, int tongTien) {
        this.maDH = maDH;
        this.soBan = soBan;
        this.maNV = maNV;
        this.ngayDat = ngayDat;
        this.tongTien = tongTien;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    public String getSoBan() {
        return soBan;
    }

    public void setSoBan(String soBan) {
        this.soBan = soBan;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
}