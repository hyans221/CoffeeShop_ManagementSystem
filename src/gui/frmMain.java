package gui;

import pojo.NhanVien;
import gui.frmKhoNguyenLieu;
import gui.frmNhanVien;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.WindowConstants;
import service.DangNhapService;

public class frmMain extends javax.swing.JFrame {

    public frmMain() {
        initComponents();
        this.setLocationRelativeTo(null);
        updateAdminVisibility();

    }

    private void updateAdminVisibility() {
        if (DangNhapService.isAdmin()) {
            btnQuanLy.setVisible(true);
        } else {
            btnQuanLy.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        btnQuanLy = new javax.swing.JMenu();
        menuItemQLFood = new javax.swing.JMenuItem();
        KhoNLMenuItem = new javax.swing.JMenuItem();
        QLNV_MenuItem = new javax.swing.JMenuItem();
        QlyTKMenuItem = new javax.swing.JMenuItem();
        InfoAccMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        LogoutMenuItem = new javax.swing.JMenuItem();
        DatBanMenu = new javax.swing.JMenu();
        btnOrder = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(56, 13));

        desktopPane.setPreferredSize(new java.awt.Dimension(1154, 623));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/layout.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        desktopPane.add(jLabel2);
        jLabel2.setBounds(0, 0, 1150, 630);

        btnQuanLy.setMnemonic('f');
        btnQuanLy.setText("Quản lý");

        menuItemQLFood.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemQLFood.setMnemonic('o');
        menuItemQLFood.setText("Menu");
        menuItemQLFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemQLFoodActionPerformed(evt);
            }
        });
        btnQuanLy.add(menuItemQLFood);

        KhoNLMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        KhoNLMenuItem.setMnemonic('s');
        KhoNLMenuItem.setText("Kho nguyên liệu");
        KhoNLMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KhoNLMenuItemActionPerformed(evt);
            }
        });
        btnQuanLy.add(KhoNLMenuItem);

        QLNV_MenuItem.setText("Nhân viên");
        QLNV_MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QLNV_MenuItemActionPerformed(evt);
            }
        });
        btnQuanLy.add(QLNV_MenuItem);

        QlyTKMenuItem.setText("Tài khoản");
        QlyTKMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QlyTKMenuItemActionPerformed(evt);
            }
        });
        btnQuanLy.add(QlyTKMenuItem);

        menuBar.add(btnQuanLy);

        InfoAccMenu.setMnemonic('e');
        InfoAccMenu.setText("Tài khoản");

        jMenuItem1.setText("Thông tin người dùng");
        InfoAccMenu.add(jMenuItem1);

        LogoutMenuItem.setMnemonic('y');
        LogoutMenuItem.setText("Đăng xuất");
        LogoutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutMenuItemActionPerformed(evt);
            }
        });
        InfoAccMenu.add(LogoutMenuItem);

        menuBar.add(InfoAccMenu);

        DatBanMenu.setText("Đặt bàn");

        btnOrder.setText("Đặt bàn");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });
        DatBanMenu.add(btnOrder);

        menuBar.add(DatBanMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemQLFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemQLFoodActionPerformed
        desktopPane.removeAll();
        frmMenu frm = new frmMenu();
        frm.pack();
//        frm.setMaximizable(true);
        frm.getContentPane().setPreferredSize(new Dimension(100, 100));
        frm.setVisible(true);
        this.desktopPane.add(frm);
    }//GEN-LAST:event_menuItemQLFoodActionPerformed

    private void KhoNLMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KhoNLMenuItemActionPerformed

        desktopPane.removeAll();
        frmKhoNguyenLieu frmNL = new frmKhoNguyenLieu();
        frmNL.pack();
//        frmNL.setMaximizable(true);
        frmNL.getContentPane().setPreferredSize(new Dimension(100, 100));
        frmNL.setVisible(true);
        this.desktopPane.add(frmNL);
    }//GEN-LAST:event_KhoNLMenuItemActionPerformed

    private void QLNV_MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QLNV_MenuItemActionPerformed
        desktopPane.removeAll();
        frmNhanVien frmNL = new frmNhanVien();
        frmNL.pack();
//        frmNL.setMaximizable(true);
        frmNL.getContentPane().setPreferredSize(new Dimension(100, 100));
        frmNL.setVisible(true);
        this.desktopPane.add(frmNL);
    }//GEN-LAST:event_QLNV_MenuItemActionPerformed

    private void QlyTKMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QlyTKMenuItemActionPerformed
        desktopPane.removeAll();
        frmNguoiDung frmND = new frmNguoiDung();
        frmND.pack();
//        frmND.setMaximizable(true);
        frmND.getContentPane().setPreferredSize(new Dimension(100, 100));
        frmND.setVisible(true);
        this.desktopPane.add(frmND);
    }//GEN-LAST:event_QlyTKMenuItemActionPerformed

    private void LogoutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutMenuItemActionPerformed
        this.dispose();
        frmDangNhap loginForm = new frmDangNhap();
        loginForm.setVisible(true);
    }//GEN-LAST:event_LogoutMenuItemActionPerformed

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        desktopPane.removeAll();
        frmOrder frm = new frmOrder();
        frm.pack();
        frm.setMaximizable(true);
        frm.getContentPane().setPreferredSize(new Dimension(100, 100));
        frm.setVisible(true);
        this.desktopPane.add(frm);
    }//GEN-LAST:event_btnOrderActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu DatBanMenu;
    private javax.swing.JMenu InfoAccMenu;
    private javax.swing.JMenuItem KhoNLMenuItem;
    private javax.swing.JMenuItem LogoutMenuItem;
    private javax.swing.JMenuItem QLNV_MenuItem;
    private javax.swing.JMenuItem QlyTKMenuItem;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem btnOrder;
    private javax.swing.JMenu btnQuanLy;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemQLFood;
    // End of variables declaration//GEN-END:variables

}
