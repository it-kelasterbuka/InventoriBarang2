/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MetaData;

import Koneksi.koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Randi
 */
public class Barang_Keluar extends javax.swing.JFrame {

    /**
     * Creates new form Barang_Keluar
     */
    public Barang_Keluar() {
        initComponents();
        
        idKodeBk();
        cb_namaclient();
        cb_namabrng();
        cb_satuanbrg();
        cb_kat();
        table_barang_keluar();
    }
    
    private void idKodeBk(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_inventori", "root", "");
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM tb_barang_keluar ORDER by id_bk DESC");

            if(rs.next()){
                String idkbm = rs.getString("id_bk").substring(3);
                System.out.print(idkbm);
                String AN = "" + (Integer.parseInt(idkbm) +1);
                System.out.print(AN);
                String Nol = "";
                
                if (AN.length() == 1) {
                    Nol = "0000";
                } else if (AN.length() == 2) {
                    Nol = "000";
                } else if (AN.length() == 3) {
                    Nol = "00";
                } else if (AN.length() == 4) {
                    Nol = "0";
                } else if (AN.length() == 5) {
                    Nol = "";
                }
                idbk.setText("BK" + Nol + AN);
            }else{
                idbk.setText("BK00001");
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void cb_namaclient(){
        try {
            String sql = "Select * From tb_client";
            Connection con = (Connection) koneksi.getKoneksi();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                cb_namaclient.addItem(rs.getString("nama_client"));
            }
        } catch (Exception e) {
        }
    }
    
    public void cb_namabrng(){
        try {
            String sql = "Select * From tb_barang";
            Connection con = (Connection) koneksi.getKoneksi();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                cb_namabrg.addItem(rs.getString("nama_barang"));
            }
        } catch (Exception e) {
        }
    }
    
    public void cb_satuanbrg(){
        try {
            String sql = "Select * From tb_barang";
            Connection con = (Connection) koneksi.getKoneksi();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                cb_satuan.addItem(rs.getString("satuan"));
            }
        } catch (Exception e) {
        }
    }
    
    public void cb_kat(){
        try {
            String sql = "Select * From tb_kategori";
            Connection con = (Connection) koneksi.getKoneksi();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                cb_katbrg.addItem(rs.getString("kategori_barang"));
            }
        } catch (Exception e) {
        }
    }
    
    public void table_barang_keluar(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Kode Pengeluaran");
        tb.addColumn("Nama Client");
        tb.addColumn("Nama Barang");
        tb.addColumn("Satuan");
        tb.addColumn("Kategori");
        tb.addColumn("Jumlah");
        tb.addColumn("Tanggal");
        
        try{
            Statement st = (Statement) koneksi.getKoneksi().createStatement();
            ResultSet rs2 = st.executeQuery("SELECT * FROM tb_barang_keluar");
            
            while(rs2.next()){
                tb.addRow(new Object[]{
                    rs2.getString("id_bk"),
                    rs2.getString("nama_client"),
                    rs2.getString("nama_barang"),
                    rs2.getString("satuan"),
                    rs2.getString("kategori"),
                    rs2.getString("jumlah"),
                    rs2.getString("tanggal")
                });
                tblbk.setModel(tb);
            }
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Koneksi database gagal"+e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        idbk = new javax.swing.JTextField();
        cb_namaclient = new javax.swing.JComboBox<>();
        cb_namabrg = new javax.swing.JComboBox<>();
        cb_satuan = new javax.swing.JComboBox<>();
        cb_katbrg = new javax.swing.JComboBox<>();
        t_jumlah = new javax.swing.JTextField();
        tglpb = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbk = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Kode Pengeluaran");

        jLabel1.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        jLabel1.setText("PENGELUARAN BARANG");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Nama Client");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Nama Barang");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Satuan");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Kategori");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Jumlah");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Tanggal");

        idbk.setBorder(null);
        idbk.setEnabled(false);

        cb_namaclient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_namaclientActionPerformed(evt);
            }
        });

        t_jumlah.setBorder(null);

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 255));
        jButton2.setText("Edit");

        jButton3.setBackground(new java.awt.Color(0, 153, 255));
        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 153, 255));
        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jButton5.setBackground(new java.awt.Color(0, 153, 255));
        jButton5.setText("Cari");

        jTextField3.setBorder(null);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));

        tblbk.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblbk);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(230, 230, 230))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(34, 34, 34)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idbk)
                                    .addComponent(cb_namaclient, 0, 193, Short.MAX_VALUE)
                                    .addComponent(cb_namabrg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_satuan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator3))))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_katbrg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(t_jumlah)
                                    .addComponent(tglpb, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(jSeparator4)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(31, 31, 31)
                                .addComponent(jButton4))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(jSeparator5))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idbk, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_katbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_namaclient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_namabrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tglpb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(20, 20, 20)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void cb_namaclientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_namaclientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_namaclientActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(df.format(tglpb.getDate()));
        
        try{
        String sql =  "INSERT INTO tb_barang_keluar VALUES ('" + idbk.getText() +"','"
            +cb_namaclient.getSelectedItem()+"','"
            +cb_namabrg.getSelectedItem()+"','"
            +cb_satuan.getSelectedItem()+"','"
            +cb_katbrg.getSelectedItem()+"','"
            +t_jumlah.getText()+"','"
            +tanggal+"')";

            Connection con=(Connection) koneksi.getKoneksi();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Berhasil menyimpan");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Gagal menyimpan"+e.getMessage());
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model1 = (DefaultTableModel)tblbk.getModel();
        table_barang_keluar();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Barang_Keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barang_Keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barang_Keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barang_Keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barang_Keluar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_katbrg;
    private javax.swing.JComboBox<String> cb_namabrg;
    private javax.swing.JComboBox<String> cb_namaclient;
    private javax.swing.JComboBox<String> cb_satuan;
    private javax.swing.JTextField idbk;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField t_jumlah;
    private javax.swing.JTable tblbk;
    private com.toedter.calendar.JDateChooser tglpb;
    // End of variables declaration//GEN-END:variables
}
