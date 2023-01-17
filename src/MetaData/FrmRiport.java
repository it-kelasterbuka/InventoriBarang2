/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MetaData;

import Koneksi.koneksi;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Randi
 */
public class FrmRiport extends javax.swing.JFrame {

    /**
     * Creates new form FrmRiport
     */
    public FrmRiport() {
        initComponents();
    }
    
    private void dateEnabled(boolean x){
        txtd_dari.setEnabled(x);
        txtd_sampai.setEnabled(x);
        tKode.setEnabled(x);
    }
    
    private void kodeEnabled(boolean x){
        tKode.setEnabled(x);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbid_laporan = new javax.swing.JComboBox<>();
        txtd_dari = new com.toedter.calendar.JDateChooser();
        txtd_sampai = new com.toedter.calendar.JDateChooser();
        btncetak = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tKode = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel1.setText("Laporan");

        jLabel2.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel2.setText("Dari Tanggal");

        jLabel3.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel3.setText("Sampai Tanggal");

        cmbid_laporan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Persedian Barang", "Barang Masuk", "Barang Keluar", "Data Client", "Kode Barang Keluar" }));
        cmbid_laporan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbid_laporanItemStateChanged(evt);
            }
        });

        btncetak.setBackground(new java.awt.Color(0, 153, 255));
        btncetak.setText("Cetak");
        btncetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetakActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N
        jLabel4.setText("Kode Barang Keluar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btncetak, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbid_laporan, 0, 195, Short.MAX_VALUE)
                            .addComponent(txtd_dari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtd_sampai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tKode))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbid_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtd_dari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtd_sampai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btncetak, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetakActionPerformed
        // TODO add your handling code here:
        String id_laporan = cmbid_laporan.getSelectedItem().toString();
        switch (id_laporan) {
            case "Pilih":
            JOptionPane.showMessageDialog(null, "Terdapat inputan yang kosong.");
            break;
            case "Persedian Barang":
            try {
                File file = new File("src/Laporan/report_barang.jrxml");
                JasperDesign jasperDesign = JRXmlLoader.load(file);
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, koneksi.getKoneksi());
                JasperViewer.viewReport(jasperPrint, false);
            }catch (JRException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
            this.hide();
            break;
            
            case "Data Client":
            try {
                File file = new File("src/Laporan/data_client.jrxml");
                JasperDesign jasperDesign = JRXmlLoader.load(file);
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, koneksi.getKoneksi());
                JasperViewer.viewReport(jasperPrint, false);
            }catch (JRException e) {
                JOptionPane.showMessageDialog(null, "Error " + e);
            }
            this.hide();
            break;
            
//            case "Data Supplier":
//            try {
//                File file = new File("src/Laporan/data_supplier.jrxml");
//                JasperDesign jasperDesign = JRXmlLoader.load(file);
//                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, koneksi.getKoneksi());
//                JasperViewer.viewReport(jasperPrint, false);
//            }catch (JRException e) {
//                JOptionPane.showMessageDialog(null, "Error " + e);
//            }
//            this.hide();
//            break;
            
            case "Kode Barang Keluar":
            try {
                    HashMap hash = new HashMap();
                    hash.put("d_kode", tKode.getText());

                    File file3 = new File("src/Laporan/kd_barang_keluar.jrxml");
                    JasperDesign jasperDesign = JRXmlLoader.load(file3);
                    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hash, koneksi.getKoneksi());
                    JasperViewer.viewReport(jasperPrint, false);
                }catch (JRException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
            }
            this.hide();
            break;
            
            default:
            SimpleDateFormat date;
            date = new SimpleDateFormat("yyyy-MM-dd");
            String d_dari = date.format(txtd_dari.getDate());
            String d_sampai = date.format(txtd_sampai.getDate());
            if(id_laporan.equals("Barang Masuk")){
                try {
                    HashMap hash = new HashMap();
                    hash.put("d_dari", d_dari);
                    hash.put("d_sampai", d_sampai);

                    File file1 = new File("src/Laporan/report_barang_masuk.jrxml");
                    JasperDesign jasperDesign = JRXmlLoader.load(file1);
                    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hash, koneksi.getKoneksi());
                    JasperViewer.viewReport(jasperPrint, false);
                }catch (JRException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                }
            }else if(id_laporan.equals("Barang Keluar")){
                try {
                    HashMap hash = new HashMap();
                    hash.put("d_dari", d_dari);
                    hash.put("d_sampai", d_sampai);

                    File file2 = new File("src/Laporan/report_barang_keluar.jrxml");
                    JasperDesign jasperDesign = JRXmlLoader.load(file2);
                    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, hash, koneksi.getKoneksi());
                    JasperViewer.viewReport(jasperPrint, false);
                }catch (JRException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                }
            }
            this.hide();
            break;
        }
    }//GEN-LAST:event_btncetakActionPerformed

    private void cmbid_laporanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbid_laporanItemStateChanged
        // TODO add your handling code here:
        String id_laporan = cmbid_laporan.getSelectedItem().toString();
        if(id_laporan.equals("Persedian Barang") || id_laporan.equals("Data Client") || id_laporan.equals("Pilih")){
            dateEnabled(false);
            kodeEnabled(false);
        }else if(id_laporan.equals("Kode Barang Keluar") || id_laporan.equals("Pilih")){
            kodeEnabled(true);
        }else{
            dateEnabled(true);
            kodeEnabled(false);
            txtd_dari.requestFocus();
        }
    }//GEN-LAST:event_cmbid_laporanItemStateChanged

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
            java.util.logging.Logger.getLogger(FrmRiport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRiport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRiport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRiport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRiport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncetak;
    private javax.swing.JComboBox<String> cmbid_laporan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tKode;
    private com.toedter.calendar.JDateChooser txtd_dari;
    private com.toedter.calendar.JDateChooser txtd_sampai;
    // End of variables declaration//GEN-END:variables
}
