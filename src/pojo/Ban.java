package pojo;

/**
 *
 * @author Thy
 */
public class Ban {
    private String soBan;
    private String tinhTrang;

    // Constructors, Getters, and Setters
    public Ban() {}

    public Ban(String soBan, String tinhTrang) {
        this.soBan = soBan;
        this.tinhTrang = tinhTrang;
    }

    public String getSoBan() {
        return soBan;
    }

    public void setSoBan(String soBan) {
        this.soBan = soBan;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
