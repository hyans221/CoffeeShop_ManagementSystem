
import util.DBConnection;
import gui.*;

public class main_QLyCaffe {

    public static void main(String[] args) {
        try {
            DBConnection.getConnection();
//            frmMain frmMain = new frmMain();
//            frmMain.setVisible(true);

// --------------------------------------------------

//            frmKhoNguyenLieu frmNL = new frmKhoNguyenLieu();
//            frmNL.setVisible(true);
//
//            frmDangNhap dangNhap = new frmDangNhap();
//            dangNhap.setVisible(true);
//
//            frmNguoiDung frmUser = new frmNguoiDung();
//            frmUser.setVisible(true);
//
//            frmThongKe thongKe = new frmThongKe();
//            thongKe.setVisible(true);
//
            frmDangNhap loginForm = new frmDangNhap();
            loginForm.setVisible(true);

//            frmNhanVien frmNV = new frmNhanVien();
//            frmNV.setVisible(true);

//            frmMenu menuFrm = new frmMenu();
//            menuFrm.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
