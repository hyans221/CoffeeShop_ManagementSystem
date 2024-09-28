package service;


import pojo.DangNhap;

public class DangNhapService {
    public static DangNhap login = null;

    public static void clear() {
        DangNhapService.login = null;
    }

    public static boolean isLogin() {
        return DangNhapService.login != null;
    }

    public static boolean isAdmin() {
        return DangNhapService.isLogin() && (login.getQuyen().equalsIgnoreCase("Admin"));
    }
    
    public static boolean isUser() {
        return DangNhapService.isLogin() && (login.getQuyen().equalsIgnoreCase("User"));
    }
}
