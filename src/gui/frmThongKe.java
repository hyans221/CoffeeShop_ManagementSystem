package gui;

import dao.ThongKeDAO;
import pojo.Ban;
import pojo.ChiTietDonHang;
import pojo.DonHang;
import pojo.Order;
import pojo.Menu;
import pojo.ThanhToan;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class frmThongKe extends javax.swing.JFrame {

    private ThongKeDAO thongKeDAO;
    private NumberFormat chuyentien = new DecimalFormat("#,###,###");

    public frmThongKe() {
        initComponents();
        thongKeDAO = new ThongKeDAO();
        loadData();
    }

    private void loadData() {
        fillTableDonHang();
        fillTableChiTietDonHang();
        loadInfo();
    }

    private void loadInfo() {
        ArrayList<Ban> arrTable = thongKeDAO.getBanList();
        if (arrTable.size() > 0) {
            int soban = arrTable.size();
            lbltongban.setText(String.valueOf(soban));
        }

        ArrayList<Menu> thucDonList = thongKeDAO.getThucDonList();
        if (thucDonList.size() > 0) {
            int soMon = thucDonList.size();
            lbltongmon.setText(String.valueOf(soMon));
        }
    }

    private void fillTableDonHang() {
        List<Order> orderList = thongKeDAO.getOrderList();
        DefaultTableModel model = (DefaultTableModel) tableDonHang.getModel();
        model.setRowCount(0);

        for (Order order : orderList) {
            model.addRow(new Object[]{
                order.getMaDH(),
                order.getSoBan(),
                order.getMaNV(),
                order.getNgayDat(),
                order.getTongTien()
            });
        }

        int tongSoHoaDon = thongKeDAO.getTongSoHoaDon();
        lblhd.setText(String.valueOf(tongSoHoaDon) + " hóa đơn");

        int tienThuVe = thongKeDAO.getTienThuVe(orderList);
        lbltienthu.setText(chuyentien.format(tienThuVe) + " VNĐ");
    }

    private void fillTableChiTietDonHang() {
        List<Order> orderList = thongKeDAO.getOrderList();
        DefaultTableModel model = (DefaultTableModel) tableChiTietDonHang.getModel();
        model.setRowCount(0);

        int tongSoMonDaBan = 0;
        int tienMon = 0;

        for (Order order : orderList) {
            for (ChiTietDonHang chiTiet : order.getChiTietDonHangList()) {
                model.addRow(new Object[]{
                    order.getMaDH(),
                    chiTiet.getMaMon(),
                    chiTiet.getSoLuong(),
                    chiTiet.getThanhTien()
                });

                tongSoMonDaBan += chiTiet.getSoLuong();
                tienMon += chiTiet.getThanhTien();
            }
        }

        lblmon.setText(String.valueOf(tongSoMonDaBan) + " món");
        lbltienmon.setText(chuyentien.format(tienMon) + " VNĐ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableChiTietDonHang = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDonHang = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblhd = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblmon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbltienthu = new javax.swing.JLabel();
        lbltienmon = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbltongban = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbltongmon = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblThongKeTheoDonhang = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        dateChooser1 = new datechooser.beans.DateChooserCombo();
        dateChooser2 = new datechooser.beans.DateChooserCombo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableChiTietDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã đơn hàng", "Mã món", "Số lượng", "Thành tiền"
            }
        ));
        jScrollPane1.setViewportView(tableChiTietDonHang);

        tableDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã đơn hàng", "Số bàn", "Mã nhân viên", "Ngày đặt", "Tổng tiền"
            }
        ));
        jScrollPane2.setViewportView(tableDonHang);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Tổng số đơn hàng thanh toán:");

        lblhd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblhd.setForeground(new java.awt.Color(82, 15, 172));
        lblhd.setText(".....");

        jLabel2.setText("Tổng số món đã bán:");

        lblmon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblmon.setForeground(new java.awt.Color(10, 85, 157));
        lblmon.setText(".....");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tổng tiền hoá :");

        lbltienthu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltienthu.setForeground(new java.awt.Color(162, 11, 11));
        lbltienthu.setText(".....");

        lbltienmon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltienmon.setForeground(new java.awt.Color(162, 11, 11));
        lbltienmon.setText("....");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tổng tiền số món đã bán:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Tổng số bàn hiện có: ");

        lbltongban.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltongban.setForeground(new java.awt.Color(17, 131, 40));
        lbltongban.setText("jLabel7");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Tổng số món:");

        lbltongmon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltongmon.setForeground(new java.awt.Color(17, 131, 40));
        lbltongmon.setText("jLabel7");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(172, 0, 5));
        jLabel11.setText("Thống kê theo món");

        lblThongKeTheoDonhang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblThongKeTheoDonhang.setForeground(new java.awt.Color(153, 0, 0));
        lblThongKeTheoDonhang.setText("Thống kê theo đơn hàng");

        jLabel13.setText("Từ ngày");

        jLabel14.setText("Đến ngày");

        jButton1.setText("Thống kê");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(23, 12, 132));

        dateChooser1.setCalendarBackground(new java.awt.Color(133, 140, 148));
        dateChooser1.setLocale(new java.util.Locale("vi", "VN", ""));
        dateChooser1.setNavigateFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11));
        dateChooser1.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_PERIOD);

        dateChooser2.setCalendarBackground(new java.awt.Color(133, 140, 148));
        dateChooser2.setLocale(new java.util.Locale("vi", "VN", ""));
        dateChooser2.setNavigateFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11));
        dateChooser2.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_PERIOD);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblThongKeTheoDonhang)
                        .addGap(219, 219, 219)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(133, 133, 133)
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lbltienthu, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblhd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(lblmon, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(30, 30, 30)
                                .addComponent(lbltienmon, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbltongban)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbltongmon)
                .addGap(238, 238, 238))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(lblThongKeTheoDonhang)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblhd)
                    .addComponent(jLabel2)
                    .addComponent(lblmon))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbltienmon)
                    .addComponent(jLabel3)
                    .addComponent(lbltienthu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(lbltongmon))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(lbltongban)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (dateChooser1.getText().isEmpty() || dateChooser2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Bạn cần chọn ngày để thống kê !");
            return;
        }
        fillByDate1();
        fillByDate2();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fillByDate1() {
        Date d1 = dateChooser1.getSelectedDate().getTime();
        Date d2 = dateChooser2.getSelectedDate().getTime();
        String s1 = new SimpleDateFormat("yyyy-MM-dd").format(d1);
        String s2 = new SimpleDateFormat("yyyy-MM-dd").format(d2);

        List<Order> orderList = thongKeDAO.getOrderListByDate(s1, s2);
        DefaultTableModel model = (DefaultTableModel) tableChiTietDonHang.getModel();
        model.setRowCount(0);

        int tongSoMonDaBan = 0;
        int tienMon = 0;

        for (Order order : orderList) {
            for (ChiTietDonHang chiTiet : order.getChiTietDonHangList()) {
                model.addRow(new Object[]{
                    order.getMaDH(),
                    chiTiet.getMaMon(),
                    chiTiet.getSoLuong(),
                    chiTiet.getThanhTien()
                });

                tongSoMonDaBan += chiTiet.getSoLuong();
                tienMon += chiTiet.getThanhTien();
            }
        }

        lblmon.setText(String.valueOf(tongSoMonDaBan) + " món");
        lbltienmon.setText(chuyentien.format(tienMon) + " VNĐ");
    }

    private void fillByDate2() {
        Date d1 = dateChooser1.getSelectedDate().getTime();
        Date d2 = dateChooser2.getSelectedDate().getTime();
        String s1 = new SimpleDateFormat("yyyy-MM-dd").format(d1);
        String s2 = new SimpleDateFormat("yyyy-MM-dd").format(d2);

        List<Order> orderList = thongKeDAO.getOrderListByDate(s1, s2);
        DefaultTableModel model = (DefaultTableModel) tableDonHang.getModel();
        model.setRowCount(0);

        int tongSoHoaDon = orderList.size();
        int tienThuVe = thongKeDAO.getTienThuVe(orderList);

        for (Order order : orderList) {
            model.addRow(new Object[]{
                order.getMaDH(),
                order.getSoBan(),
                order.getMaNV(),
                order.getNgayDat(),
                order.getTongTien()
            });
        }

        lblhd.setText(String.valueOf(tongSoHoaDon) + " hóa đơn");
        lbltienthu.setText(chuyentien.format(tienThuVe) + " VNĐ");
    }

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmThongKe().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooser1;
    private datechooser.beans.DateChooserCombo dateChooser2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblThongKeTheoDonhang;
    private javax.swing.JLabel lblhd;
    private javax.swing.JLabel lblmon;
    private javax.swing.JLabel lbltienmon;
    private javax.swing.JLabel lbltienthu;
    private javax.swing.JLabel lbltongban;
    private javax.swing.JLabel lbltongmon;
    private javax.swing.JTable tableChiTietDonHang;
    private javax.swing.JTable tableDonHang;
    // End of variables declaration//GEN-END:variables
}
