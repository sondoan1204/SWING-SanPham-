/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.LoaiSP;
import controller.SanPhamDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Loai;
import models.SanPham;

/**
 *
 * @author SONPC
 */
public class frmSanPham extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private DefaultComboBoxModel dcbm;
    private boolean cotthem = true;
    ArrayList<SanPham> listSP = null;
    ArrayList<Loai> listLoai = null;
    long trang = 1;

    public frmSanPham() throws SQLException {
        initComponents();
        dtm = new DefaultTableModel();
        dtm.addColumn("Mã Sp");
        dtm.addColumn("Tên SP");
        dtm.addColumn("Giá");
        dtm.addColumn("Mã loại");

        dcbm = new DefaultComboBoxModel();
        listLoai = new LoaiSP().getAll();
        for (Loai loai : listLoai) {
            //dcbm.addElement(loai.getMaloai());
            dcbm.addElement(loai.getTenloai());
        }
        cbbLoai.setModel(dcbm);
        loaddata();
        //loaddataTrang(trang*5-5);
        //txtTrang.setText("Trang "+trang);
        distext();
        setnut(cotthem);
    }

    private void xoatext() {
        txtgia.setText("");
        txtmasp.setText("");
        txttensp.setText("");
    }

    private void distext() {

        txtmasp.setEnabled(false);
        txttensp.setEnabled(false);
        txtgia.setEnabled(false);
        cbbLoai.setEnabled(false);
    }

    private void entext() {
        txtmasp.setEnabled(true);
        txttensp.setEnabled(true);
        txtgia.setEnabled(true);
        cbbLoai.setEnabled(true);
    }

    private void setnut(boolean a) {
        btnThem.setEnabled(a);
        btnXoa.setEnabled(a);
        btnSua.setEnabled(a);
        btnLuu.setEnabled(!a);
        btnKluu.setEnabled(!a);
        btnThoat.setEnabled(a);
    }

    private static Object[] toObjectsData(SanPham sp) {
        Object[] objectsData = {sp.getMasp(), sp.getTensp(), sp.getGia(), sp.getMaloai()};
        return objectsData;
    }

    private void loaddata() throws SQLException {
        listSP = new SanPhamDAO().getAll();
        for (SanPham sp : listSP) {
            dtm.addRow(toObjectsData(sp));
        }
        tblSanPham.setModel(dtm);
    }

    private void loaddataTrang(long sotrang) throws SQLException {
        listSP = new SanPhamDAO().getTrang(sotrang);
        for (SanPham sp : listSP) {
            dtm.addRow(toObjectsData(sp));
        }
        tblSanPham.setModel(dtm);
    }

    private void showAll() throws SQLException {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        ArrayList<SanPham> listsp = new SanPhamDAO().getAll();
        for (SanPham sp : listsp) {
            Vector v = new Vector();
            v.add(sp.getMasp());
            v.add(sp.getTensp());
            v.add(sp.getGia());
            v.add(sp.getMaloai());
            dtm.addRow(v);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        cbbLoai = new javax.swing.JComboBox<>();
        txtmasp = new javax.swing.JTextField();
        txttensp = new javax.swing.JTextField();
        txtgia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        btnTrai = new javax.swing.JButton();
        btnPhai = new javax.swing.JButton();
        txtTrang = new javax.swing.JLabel();
        btnKluu = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        cbbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("mã");

        jLabel2.setText("Tên");

        jLabel3.setText("Giá");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnTrai.setText("<<");
        btnTrai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraiActionPerformed(evt);
            }
        });

        btnPhai.setText(">>");
        btnPhai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhaiActionPerformed(evt);
            }
        });

        btnKluu.setText("K.Lưu");
        btnKluu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKluuActionPerformed(evt);
            }
        });

        jLabel4.setText("Loại SP:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnPhai, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnTrai, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtmasp, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(150, 150, 150)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnLuu)
                        .addGap(31, 31, 31)
                        .addComponent(btnKluu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThoat)
                        .addGap(102, 102, 102))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnLuu)
                    .addComponent(btnThoat)
                    .addComponent(btnKluu))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTrai)
                    .addComponent(txtTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPhai))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        String masp = txtmasp.getText();
        String tensp = txttensp.getText();
        String gia = txtgia.getText();
        String maloai = listLoai.get(cbbLoai.getSelectedIndex()).getMaloai();
        SanPham sp = new SanPham(masp, tensp, Long.valueOf(gia), maloai);

        if (cotthem == true) {
            try {
                long kt = new SanPhamDAO().chekid(masp);
                if (kt != 0) {
                    JOptionPane.showMessageDialog(this, "Mã bị trùng!", "Vui lòng kiểm tra lại", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                SanPham insert = new SanPhamDAO().addNew(sp);
                if (insert != null) {
                    //showAll();
                    while (dtm.getRowCount() > 0) {
                        dtm.removeRow(0);
                    }
                    loaddata();
                    xoatext();
                    distext();

                }

            } catch (SQLException ex) {
                Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                SanPham update = new SanPhamDAO().update(sp);
                if (update != null) {
                    showAll();
                    xoatext();
                    distext();

                }
            } catch (SQLException ex) {
                Logger.getLogger(frmLoaiSP.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        setnut(true);

    }//GEN-LAST:event_btnLuuActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        txtmasp.setText(tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 0).toString());
        txttensp.setText(tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 1).toString());
        txtgia.setText(tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 2).toString());
        try {
            String tenLoai = new LoaiSP().tenLoai(tblSanPham.getValueAt(tblSanPham.getSelectedRow(), 3).toString());
            cbbLoai.setSelectedItem(tenLoai);
        } catch (SQLException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }

    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        xoatext();
        entext();
        cotthem = true;
        setnut(false);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        String masp = txtmasp.getText();
        if (masp.length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn khoa cần xóa", "Thông báo", 1);
        } else {
            int b = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa dữ liệu này?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (b == JOptionPane.YES_OPTION) {
                try {
                    new SanPhamDAO().deleteSP(masp);
                } catch (SQLException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "Dữ liệu chưa thể xóa, có tồn tại lớp của khoa này.\nHãy xóa dữ liệu lớp của khoa này trước.", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
                while (dtm.getRowCount() > 0) {
                    dtm.removeRow(0);
                }
                try {
                    loaddata();
                } catch (SQLException ex) {
                    Logger.getLogger(frmLoaiSP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            xoatext();
            setnut(true);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        String masp = txtmasp.getText();
        if (masp.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chọn ssp cần sửa", "Thông báo", 1);
            return;
        }
        entext();
        txtmasp.setEnabled(false);
        cotthem = false;
        setnut(false);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnPhaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhaiActionPerformed
        trang++;
        try {
            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            loaddataTrang(trang * 5 - 5);
        } catch (SQLException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtTrang.setText("Trang " + trang);
    }//GEN-LAST:event_btnPhaiActionPerformed

    private void btnTraiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraiActionPerformed
        trang--;
        try {
            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }
            loaddataTrang(trang * 5 - 5);
        } catch (SQLException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtTrang.setText("Trang " + trang);
    }//GEN-LAST:event_btnTraiActionPerformed

    private void btnKluuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKluuActionPerformed
        xoatext();
        distext();
        setnut(true);
    }//GEN-LAST:event_btnKluuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmSanPham().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
                    System.err.println(ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKluu;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnPhai;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTrai;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JLabel txtTrang;
    private javax.swing.JTextField txtgia;
    private javax.swing.JTextField txtmasp;
    private javax.swing.JTextField txttensp;
    // End of variables declaration//GEN-END:variables
}
