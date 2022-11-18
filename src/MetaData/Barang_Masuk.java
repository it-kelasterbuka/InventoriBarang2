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
public class Barang_Masuk extends javax.swing.JFrame {

    /**
     * Creates new form Barang_Masuk
     */
    public Barang_Masuk() {
        initComponents();
        
        idKodeBm();
        cb_namasuppl();
        cb_namabrng();
        cb_kat();
        cb_satuanbrg();
        table_barang_masuk();
    }
    
    private void idKodeBm(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/db_inventori", "root", "");
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("SELECT * FROM tb_barang_masuk ORDER by id_bm DESC");

            if(rs.next()){
                String idkbm = rs.getString("id_bm").substring(3);
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
                idbm.setText("BM" + Nol + AN);
            }else{
                idbm.setText("BM00001");
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void cb_namasuppl(){
        try {
            String sql = "Select * From tb_supplier";
            Connection con = (Connection) koneksi.getKoneksi();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                cb_namasupp.addItem(rs.getString("nama_supplier"));
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
                cb_katbr.addItem(rs.getString("kategori_barang"));
            }
        } catch (Exception e) {
        }
    }
    
    public void table_barang_masuk(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Kode Pemasukan");
        tb.addColumn("Nama Supplier");
        tb.addColumn("Nama Barang");
        tb.addColumn("Satuan");
        tb.addColumn("Kategori");
        tb.addColumn("Jumlah");
        tb.addColumn("Tanggal");
        
        try{
            Statement st = (Statement) koneksi.getKoneksi().createStatement();
            ResultSet rs2 = st.executeQuery("SELECT * FROM tb_barang_masuk");
            
            while(rs2.next()){
                tb.addRow(new Object[]{
                    rs2.getString("id_bm"),
                    rs2.getString("nama_supplier"),
                    rs2.getString("nama_barang"),
                    rs2.getString("satuan"),
                    rs2.getString("kategori"),
                    rs2.getString("jumlah"),
                    rs2.getString("tanggal")
                });
                tblbm.setModel(tb);
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbm = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tgl_bm = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        t_jumlah = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        cb_namasupp = new javax.swing.JComboBox<>();
        idbm = new javax.swing.JTextField();
        cb_namabrg = new javax.swing.JComboBox<>();
        cb_satuan = new javax.swing.JComboBox<>();
        cb_katbr = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Microsoft Himalaya", 1, 24)); // NOI18N
        jLabel1.setText("PEMASUKAN BARANG");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Kode Pemasukan");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Nama Supplier");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Satuan");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Tanggal");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Kategori");

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

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

        jButton4.setBackground(new java.awt.Color(0, 153, 255));
        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));

        tblbm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblbm);

        jButton5.setBackground(new java.awt.Color(0, 153, 255));
        jButton5.setText("Cari");

        jTextField6.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Jumlah");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Nama Barang");

        t_jumlah.setBorder(null);

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));

        idbm.setBorder(null);
        idbm.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator2)
                                    .addComponent(idbm)
                                    .addComponent(cb_namasupp, 0, 205, Short.MAX_VALUE)
                                    .addComponent(cb_namabrg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(34, 34, 34)
                                        .addComponent(jButton2))
                                    .addComponent(cb_satuan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addGap(33, 33, 33)
                                        .addComponent(jButton4))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(41, 41, 41)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tgl_bm, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                            .addComponent(t_jumlah)
                                            .addComponent(jSeparator9)
                                            .addComponent(cb_katbr, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addComponent(jSeparator7)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(jSeparator10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 353, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idbm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_katbr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(t_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_namasupp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_namabrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4))
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton5))
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tgl_bm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(df.format(tgl_bm.getDate()));
        
        try{
        String sql =  "INSERT INTO tb_barang_masuk VALUES ('" + idbm.getText() +"','"
            +cb_namasupp.getSelectedItem()+"','"
            +cb_namabrg.getSelectedItem()+"','"
            +cb_satuan.getSelectedItem()+"','"
            +cb_katbr.getSelectedItem()+"','"
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
        DefaultTableModel model = (DefaultTableModel)tblbm.getModel();
        table_barang_masuk();
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
            java.util.logging.Logger.getLogger(Barang_Masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barang_Masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barang_Masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barang_Masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barang_Masuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_katbr;
    private javax.swing.JComboBox<String> cb_namabrg;
    private javax.swing.JComboBox<String> cb_namasupp;
    private javax.swing.JComboBox<String> cb_satuan;
    private javax.swing.JTextField idbm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField t_jumlah;
    private javax.swing.JTable tblbm;
    private com.toedter.calendar.JDateChooser tgl_bm;
    // End of variables declaration//GEN-END:variables
}
