package pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private String maDH;
    private String soBan;
    private String maNV;
    private Date ngayDat;
    private int tongTien;
    private List<ChiTietDonHang> chiTietDonHangList; // Danh sách chi tiết đơn hàng
    private String tenMon; // Thêm trường tenMon
    private int soLuong; // Thêm trường soLuong
    private int donGia; // Thêm trường donGia

    // Constructor
    public Order(String maDH, String soBan, String maNV, Date ngayDat, int tongTien) {
        this.maDH = maDH;
        this.soBan = soBan;
        this.maNV = maNV;
        this.ngayDat = ngayDat;
        this.tongTien = tongTien;
        this.tenMon = tenMon;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.chiTietDonHangList = new ArrayList<>();
    }

    public Order(String tenMon, int soLuong, int donGia, String soBan) {
        this.tenMon = tenMon;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.soBan = soBan;
        this.chiTietDonHangList = new ArrayList<>();
    }

    // Các phương thức getter và setter (đã giữ nguyên)
    // Thêm một chi tiết đơn hàng vào danh sách
    public void addChiTietDonHang(ChiTietDonHang chiTietDonHang) {
        this.chiTietDonHangList.add(chiTietDonHang);
    }

    // Thêm phương thức getTenMon
    public String getTenMon() {
        return tenMon;
    }

    // Thêm phương thức getSoLuong
    public int getSoLuong() {
        return soLuong;
    }

    // Thêm phương thức getDonGia
    public int getDonGia() {
        return donGia;
    }

    // Thêm phương thức getSoBan
    public String getSoBan() {
        return soBan;
    }

    public String getMaDH() {
        return maDH;
    }

    public void setMaDH(String maDH) {
        this.maDH = maDH;
    }

    // Getter và setter cho maNV
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    // Getter và setter cho ngayDat
    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    // Getter và setter cho tongTien
    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    // Getter và setter cho chiTietDonHangList
    public List<ChiTietDonHang> getChiTietDonHangList() {
        return chiTietDonHangList;
    }

    public void setChiTietDonHangList(List<ChiTietDonHang> chiTietDonHangList) {
        this.chiTietDonHangList = chiTietDonHangList;
    }


    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }



    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    // toString method đã được giữ nguyên
    @Override
    public String toString() {
        return "Order{"
                + "maDH='" + maDH + '\''
                + ", soBan='" + soBan + '\''
                + ", maNV='" + maNV + '\''
                + ", ngayDat=" + ngayDat
                + ", tongTien=" + tongTien
                + ", chiTietDonHangList=" + chiTietDonHangList
                + '}';
    }
}
