package gui;

import dao.KhoNguyenLieuDAO;
import dao.NhanVienDAO;
import pojo.KhoNguyenLieu;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class frmKhoNguyenLieu extends javax.swing.JInternalFrame {

    private KhoNguyenLieuDAO dao;
    private NhanVienDAO nhanVienDAO;

    public frmKhoNguyenLieu() {
        initComponents();
        dao = new KhoNguyenLieuDAO();
        nhanVienDAO = new NhanVienDAO();
        loadDonViTinhComboBox();
        loadTableData();
    }

    private void loadTableData() {
        loadMaNVComboBox();
        List<KhoNguyenLieu> list = dao.getAllNguyenLieu();
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        for (KhoNguyenLieu nl : list) {
            model.addRow(new Object[]{
                nl.getMaNL(),
                nl.getTenNL(),
                nl.getNgayNhap(),
                nl.getSoLuong(),
                nl.getDonViTinh(),
                nl.getDonGia(),
                nl.getMaNV()
            });
        }
    }

    private void loadMaNVComboBox() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        for (String maNV : nhanVienDAO.getAllMaNV()) {
            model.addElement(maNV);
        }
        cboMaNV.setModel(model);
    }

    private void loadDonViTinhComboBox() {
        cboDonVi.addItem("Hộp");
        cboDonVi.addItem("Thùng");
        cboDonVi.addItem("Cái");
        cboDonVi.addItem("Chiếc");
        cboDonVi.addItem("Két");
        cboDonVi.addItem("Lon");
        cboDonVi.addItem("Gói");
        cboDonVi.addItem("Kg");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnExportExcel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTenHH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMaHH = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        cboDonVi = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtChiPhi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        ngaySinh_DateChooser = new datechooser.beans.DateChooserCombo();
        jLabel17 = new javax.swing.JLabel();
        cboMaNV = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Quảng lý hàng hóa"));

        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nguyên liệu ", "Tên nguyên liệu ", "Ngày nhập", "Đơn giá", "Số lượng ", "Đơn vị", "Mã nhân viên"
            }
        ));
        tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb);

        txtSearch.setPreferredSize(new java.awt.Dimension(104, 27));

        jLabel8.setText("Tìm kiếm");

        btnSearch.setText("Tìm Kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnExportExcel.setText("Xuất ex");
        btnExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1119, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnSearch)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách", jPanel2);

        btnInsert.setText("Thêm");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa");
        btnUpdate.setPreferredSize(new java.awt.Dimension(84, 27));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.setPreferredSize(new java.awt.Dimension(84, 27));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        cboDonVi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hộp", "Thùng", "Cái", "Chiếc", "Két", "Lon", "Gói", "Kg" }));
        cboDonVi.setToolTipText("");

        txtChiPhi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtChiPhiKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Tên nguyên liệu");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Mã nguyên liệu");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setText("Ngày nhập");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel14.setText("Đơn vị tính");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel15.setText("Số lượng kiểm kê");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Đơn giá");

        ngaySinh_DateChooser.setCalendarBackground(new java.awt.Color(133, 140, 148));
        ngaySinh_DateChooser.setLocale(new java.util.Locale("vi", "VN", ""));
        ngaySinh_DateChooser.setNavigateFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11));
        ngaySinh_DateChooser.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_PERIOD);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setText("Mã nhân viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(327, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel12)
                            .addComponent(jLabel17))
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtChiPhi)
                            .addComponent(txtSL)
                            .addComponent(cboDonVi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenHH)
                            .addComponent(txtMaHH)
                            .addComponent(ngaySinh_DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboMaNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(203, 203, 203))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(txtMaHH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(txtTenHH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel13)
                            .addComponent(ngaySinh_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel14)
                            .addComponent(cboDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel16)
                            .addComponent(txtChiPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cboMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel11)
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(97, 97, 97))
        );

        jTabbedPane1.addTab("Cập nhật", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMouseClicked
        int selectedRow = tb.getSelectedRow();
        if (selectedRow >= 0) {
            txtMaHH.setText(tb.getValueAt(selectedRow, 0).toString());
            txtTenHH.setText(tb.getValueAt(selectedRow, 1).toString());
            txtSL.setText(tb.getValueAt(selectedRow, 3).toString());
            cboDonVi.setSelectedItem(tb.getValueAt(selectedRow, 4).toString());

            String ngayNhapStr = tb.getValueAt(selectedRow, 2).toString();
            try {
                java.util.Date ngayNhap = new SimpleDateFormat("yyyy-MM-dd").parse(ngayNhapStr);
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.setTime(ngayNhap);
                ngaySinh_DateChooser.setSelectedDate(cal);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            txtChiPhi.setText(tb.getValueAt(selectedRow, 5).toString());
            cboMaNV.setSelectedItem(tb.getValueAt(selectedRow, 6).toString());
        }
    }//GEN-LAST:event_tbMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyword = txtSearch.getText();
        List<KhoNguyenLieu> list = dao.searchNguyenLieu(keyword);
        DefaultTableModel model = (DefaultTableModel) tb.getModel();
        model.setRowCount(0);
        for (KhoNguyenLieu nl : list) {
            model.addRow(new Object[]{
                nl.getMaNL(),
                nl.getTenNL(),
                nl.getNgayNhap(),
                nl.getSoLuong(),
                nl.getDonViTinh(),
                nl.getDonGia(),
                nl.getMaNV()
            });
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelActionPerformed

    }//GEN-LAST:event_btnExportExcelActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        String maNL = txtMaHH.getText();
        String tenNL = txtTenHH.getText();
        java.util.Date ngayNhapUtil = ngaySinh_DateChooser.getSelectedDate().getTime(); // Get the date from the DateChooser
        String ngayNhap = new SimpleDateFormat("yyyy-MM-dd").format(ngayNhapUtil); // Format the date
        int soLuong = Integer.parseInt(txtSL.getText());
        String donViTinh = cboDonVi.getSelectedItem().toString();
        float donGia = Float.parseFloat(txtChiPhi.getText());
        String maNV = cboMaNV.getSelectedItem().toString();

        try {
            java.sql.Date sqlNgayNhap = java.sql.Date.valueOf(ngayNhap); // Convert the formatted date string to SQL date
            KhoNguyenLieu nl = new KhoNguyenLieu(maNL, tenNL, ngayNhap, soLuong, donViTinh, donGia, maNV);
            if (dao.insertNguyenLieu(nl)) {
                JOptionPane.showMessageDialog(this, "Thêm nguyên liệu thành công");
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(this, "Thêm nguyên liệu thất bại");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Ngày nhập không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String maNL = txtMaHH.getText();
        String tenNL = txtTenHH.getText();
        java.util.Date ngayNhapUtil = ngaySinh_DateChooser.getSelectedDate().getTime(); // Get the date from the DateChooser
        String ngayNhap = new SimpleDateFormat("yyyy-MM-dd").format(ngayNhapUtil); // Format the date
        int soLuong = Integer.parseInt(txtSL.getText());
        String donViTinh = cboDonVi.getSelectedItem().toString();
        float donGia = Float.parseFloat(txtChiPhi.getText());
        String maNV = cboMaNV.getSelectedItem().toString();

        try {
            java.sql.Date sqlNgayNhap = java.sql.Date.valueOf(ngayNhap); // Convert the formatted date string to SQL date
            KhoNguyenLieu nl = new KhoNguyenLieu(maNL, tenNL, ngayNhap, soLuong, donViTinh, donGia, maNV);
            if (dao.updateNguyenLieu(nl)) {
                JOptionPane.showMessageDialog(this, "Cập nhật nguyên liệu thành công");
                loadTableData();
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật nguyên liệu thất bại");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Ngày nhập không hợp lệ. Vui lòng nhập lại theo định dạng yyyy-MM-dd.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi: " + e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String maNL = txtMaHH.getText();
        if (dao.deleteNguyenLieu(maNL)) {
            JOptionPane.showMessageDialog(this, "Xóa nguyên liệu thành công");
            loadTableData();
        } else {
            JOptionPane.showMessageDialog(this, "Xóa nguyên liệu thất bại");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtChiPhiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChiPhiKeyReleased

    }//GEN-LAST:event_txtChiPhiKeyReleased

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmKhoNguyenLieu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboDonVi;
    private javax.swing.JComboBox<String> cboMaNV;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private datechooser.beans.DateChooserCombo ngaySinh_DateChooser;
    private javax.swing.JTable tb;
    private javax.swing.JTextField txtChiPhi;
    private javax.swing.JTextField txtMaHH;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenHH;
    // End of variables declaration//GEN-END:variables

}
