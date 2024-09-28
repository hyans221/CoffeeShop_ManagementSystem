package pojo;

/**
 *
 * @author Thy
 */

public class NhanVien {
    private String maNV;
    private String tenNV;
    private String sdt;
    private String ngaySinh;
    private String loaiNV;

    public NhanVien() {}

    public NhanVien(String maNV, String tenNV, String sdt, String ngaySinh, String loaiNV) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.loaiNV = loaiNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getLoaiNV() {
        return loaiNV;
    }

    public void setLoaiNV(String loaiNV) {
        this.loaiNV = loaiNV;
    }
}