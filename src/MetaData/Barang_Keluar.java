/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MetaData;

import Koneksi.koneksi;
import static MetaData.Barang_Masuk.getTanggalFromTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Randi
 */
public class Barang_Keluar extends javax.swing.JFrame {
    
    private int bay, bel, jum, hj, jj, kem, unt, tot, totbel;

    /**
     * Creates new form Barang_Keluar
     */
    public Barang_Keluar() {
        initComponents();
        
        idKodeBk();
        table_barang_keluar();
    }
    
    void refresh(){
        idbk.setText("");
        t_kdClient.setText("");
        t_namaClient.setText("");
        t_kdBrg.setText("");
        t_namaBrg.setText("");
        t_satuan.setText("");
        t_hargapeng.setText("");
        t_ket.setText("");
        t_jumlah.setText("");
        tglpb.setDate(null);
        t_totalpenge.setText("");
        t_pembayaran.setText("");
        t_kembalian.setText("");
        t_keuntungan.setText("");
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
    
    void Cari(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Kode Pengeluaran");
        tb.addColumn("Kode Client");
        tb.addColumn("Nama Client");
        tb.addColumn("Kode Barang");
        tb.addColumn("Nama Barang");
        tb.addColumn("Satuan");
        tb.addColumn("Harga Satuan");
        tb.addColumn("Harga Pengeluaran");
        tb.addColumn("Keterangan");
        tb.addColumn("Jumlah Keluar");
        tb.addColumn("Tanggal Keluar");
        tb.addColumn("Total Pengeluaran");
        tb.addColumn("Pembayaran");
        tb.addColumn("Kembalian");
        tb.addColumn("Keuntungan");
        
        try{
            String sql = "SELECT * FROM  tb_barang_keluar  WHERE id_bk like '%" + t_cari.getText()+"%'";
            Connection con = (Connection) koneksi.getKoneksi();
            Statement st = con.createStatement();
            ResultSet rs2 = st.executeQuery(sql);
            
            while(rs2.next()){
                tb.addRow(new Object[]{
                    rs2.getString("id_bk"),
                    rs2.getString("id_client"),
                    rs2.getString("nama_client"),
                    rs2.getString("id_barang"),
                    rs2.getString("nama_barang"),
                    rs2.getString("satuan"),
                    rs2.getString("harga_satuan"),
                    rs2.getString("harga_pengeluaran"),
                    rs2.getString("keterangan"),
                    rs2.getString("jumlah_k"),
                    rs2.getString("tanggal_k"),
                    rs2.getString("total_pengeluaran"),
                    rs2.getString("pembayaran"),
                    rs2.getString("kembalian"),
                    rs2.getString("keuntungan")
                });
                tblbk.setModel(tb);
            }
            
        }catch(Exception e){
        
        }
    }
    
    public void table_barang_keluar(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Kode Pengeluaran");
        tb.addColumn("Kode Client");
        tb.addColumn("Nama Client");
        tb.addColumn("Kode Barang");
        tb.addColumn("Nama Barang");
        tb.addColumn("Satuan");
        tb.addColumn("Harga Satuan");
        tb.addColumn("Harga Pengeluaran");
        tb.addColumn("Keterangan");
        tb.addColumn("Jumlah Keluar");
        tb.addColumn("Tanggal Keluar");
        tb.addColumn("Total Pengeluaran");
        tb.addColumn("Pembayaran");
        tb.addColumn("Kembalian");
        tb.addColumn("Keuntungan");
        
        try{
            Statement st = (Statement) koneksi.getKoneksi().createStatement();
            ResultSet rs2 = st.executeQuery("SELECT * FROM tb_barang_keluar");
            
            while(rs2.next()){
                tb.addRow(new Object[]{
                    rs2.getString("id_bk"),
                    rs2.getString("id_client"),
                    rs2.getString("nama_client"),
                    rs2.getString("id_barang"),
                    rs2.getString("nama_barang"),
                    rs2.getString("satuan"),
                    rs2.getString("harga_satuan"),
                    rs2.getString("harga_pengeluaran"),
                    rs2.getString("keterangan"),
                    rs2.getString("jumlah_k"),
                    rs2.getString("tanggal_k"),
                    rs2.getString("total_pengeluaran"),
                    rs2.getString("pembayaran"),
                    rs2.getString("kembalian"),
                    rs2.getString("keuntungan")
                });
                tblbk.setModel(tb);
            }
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Koneksi database gagal"+e.getMessage());
        }
    }
    
    public static Date getTanggalFromTable(JTable table, int kolom){
        JTable tabel = table;
        String str_tggl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
        Date tanggal = null;
        try {
            tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(str_tggl);
        } catch (ParseException pex) {
            Logger.getLogger(Data_Supplier.class.getName()).log(Level.SEVERE, null, pex);
        }
        return tanggal;
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
        t_jumlah = new javax.swing.JTextField();
        tglpb = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton5 = new javax.swing.JButton();
        t_cari = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbk = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        t_hargasatuan = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        t_hargapeng = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        t_totalpenge = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        t_pembayaran = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        t_keuntungan = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        t_kembalian = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        t_ket = new javax.swing.JTextArea();
        t_kdClient = new javax.swing.JTextField();
        t_namaClient = new javax.swing.JTextField();
        t_kdBrg = new javax.swing.JTextField();
        t_namaBrg = new javax.swing.JTextField();
        t_satuan = new javax.swing.JTextField();

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
        jLabel12.setText("Keterangan");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Jumlah");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Tanggal");

        idbk.setBorder(null);
        idbk.setEnabled(false);

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
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        t_cari.setBorder(null);
        t_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_cariActionPerformed(evt);
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
        tblbk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbk);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Harga Satuan");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Harga Pengeluaran");

        jButton6.setBackground(new java.awt.Color(0, 153, 255));
        jButton6.setText("Hitung");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Total");

        t_totalpenge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_totalpengeActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("Pembayaran");

        jButton7.setBackground(new java.awt.Color(0, 153, 255));
        jButton7.setText("Bayar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("Kembalian");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setText("Keuntungan");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Kode Client");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Kode Barang");

        t_ket.setColumns(20);
        t_ket.setRows(5);
        jScrollPane2.setViewportView(t_ket);

        t_kdClient.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_kdClientFocusLost(evt);
            }
        });

        t_kdBrg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_kdBrgFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(230, 230, 230))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t_cari, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                    .addComponent(jSeparator5)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(51, 51, 51))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(idbk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(t_hargapeng, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                            .addComponent(t_hargasatuan)
                                            .addComponent(t_satuan)
                                            .addComponent(t_namaBrg)
                                            .addComponent(t_kdBrg))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(t_kdClient, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                            .addComponent(t_namaClient))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13))))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tglpb, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(t_keuntungan)
                                    .addComponent(jSeparator4)
                                    .addComponent(t_jumlah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(t_totalpenge, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(t_kembalian)
                                    .addComponent(t_pembayaran)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4)))
                        .addContainerGap(14, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idbk, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton7))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton2)
                                    .addComponent(jButton6)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t_kdClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_namaClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(t_kdBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17)
                            .addComponent(t_namaBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(t_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tglpb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(t_totalpenge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_hargasatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_hargapeng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(t_keuntungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(t_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "DELETE FROM tb_barang_keluar WHERE id_bk ='" + idbk.getText() + "'";
            Connection con = (Connection) koneksi.getKoneksi();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Success menghapus data");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal menghapus data");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void t_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_cariActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(df.format(tglpb.getDate()));
        
        try{
        String sql =  "INSERT INTO tb_barang_keluar VALUES ('" + idbk.getText() +"','"
            +t_kdClient.getText()+"','"
            +t_namaClient.getText()+"','"
            +t_kdBrg.getText()+"','"
            +t_namaBrg.getText()+"','"
            +t_satuan.getText()+"','" 
            +t_hargasatuan.getText()+"','"
            +t_hargapeng.getText()+"','"
            +t_ket.getText()+"','"
            +t_jumlah.getText()+"','"
            +tanggal+"','"
            +t_totalpenge.getText()+"','"
            +t_pembayaran.getText()+"','" 
            +t_kembalian.getText()+"','"
            +t_keuntungan.getText()+"')";

            Connection con=(Connection) koneksi.getKoneksi();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Berhasil menyimpan");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Gagal menyimpan"+e.getMessage());
         }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //TODO add your handling code here:
        DefaultTableModel model1 = (DefaultTableModel)tblbk.getModel();
        table_barang_keluar();
        refresh();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        hj = Integer.parseInt(t_hargapeng.getText());
        jj = Integer.parseInt(t_jumlah.getText());
        if (Integer.parseInt(t_hargasatuan.getText()) > Integer.parseInt(t_hargapeng.getText())) {
            JOptionPane.showMessageDialog(null, "Harga pengeluaran barang lebih kecil dari pemasukan");

        } else {
            jum = hj * jj;
            String jumlahLocal = String.valueOf(jum);
            t_totalpenge.setText(jumlahLocal);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void t_totalpengeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_totalpengeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_totalpengeActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        tot = Integer.parseInt(t_totalpenge.getText());
        bay = Integer.parseInt(t_pembayaran.getText());
        hj = Integer.parseInt(t_hargapeng.getText());
        jj = Integer.parseInt(t_jumlah.getText());
        bel = Integer.parseInt(t_hargasatuan.getText());
        kem = bay - tot;
        if (kem < 0) {
            JOptionPane.showMessageDialog(null, "Pembayaran tidak mencukupi total penjualan");
            JOptionPane.showMessageDialog(null, "Kurang Rp." + (Integer.parseInt((t_totalpenge.getText())) - Integer.parseInt(t_pembayaran.getText())));
        } else {
            totbel = bel * jj;
            unt = tot - totbel;
            String kembali = String.valueOf(kem);
            t_kembalian.setText(kembali);
            String untung = String.valueOf(unt);
            t_keuntungan.setText(untung);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void t_kdBrgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_kdBrgFocusLost
        // TODO add your handling code here:
        String kdBrgg = t_kdBrg.getText();
        try {
            Connection conn = koneksi.getKoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM tb_barang_masuk WHERE id_barang='"+kdBrgg+"'");
            if(sql.next()){
                t_namaBrg.setText(sql.getString("nama_barang"));
                t_satuan.setText(sql.getString("satuan"));
                t_hargasatuan.setText(sql.getString("harga_satuan"));
                t_ket.setText(sql.getString("keterangan"));
            }else{
                JOptionPane.showMessageDialog(null, "kode barang tidak ditemukan.");
                t_kdBrg.setText("");
            }
            koneksi.getKoneksi();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }//GEN-LAST:event_t_kdBrgFocusLost

    private void t_kdClientFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_kdClientFocusLost
        // TODO add your handling code here:
        String kdCln = t_kdClient.getText();
        try {
            Connection conn = koneksi.getKoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM tb_client WHERE id_client='"+kdCln+"'");
            if(sql.next()){
                t_namaClient.setText(sql.getString("nama_client"));
            }else{
                JOptionPane.showMessageDialog(null, "kode client tidak ditemukan.");
                t_kdClient.setText("");
            }
            koneksi.getKoneksi();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }//GEN-LAST:event_t_kdClientFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat df = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(df.format(tglpb.getDate()));
        
        try{
        String sql = "UPDATE tb_barang_keluar SET id_bk='"+ idbk.getText()
                + "',id_client='" + t_kdClient.getText()
                + "',nama_supplier='" + t_namaClient.getText()
                + "',id_barang='" + t_kdBrg.getText()
                + "',nama_barang='" + t_namaBrg.getText()
                + "',satuan='" + t_satuan.getText()
                + "',harga_satuan='" + t_hargasatuan.getText()
                + "',harga_pengeluaran='" + t_hargapeng.getText()
                + "',keterangan='" + t_ket.getText()
                + "',jumlah_m='" + t_jumlah.getText()
                + tanggal
                + "',total_pengeluaran='" + t_totalpenge.getText()
                + "',pembayaran='" + t_pembayaran.getText()
                + "',kembalian='" + t_kembalian.getText()
                + "',keuntungan='" + t_keuntungan.getText()
                + "'WHERE id_barang='" + idbk.getText() + "'";
                    
            Connection con = (Connection) koneksi.getKoneksi();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Berhasil Edit Data");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal Edit Data" + e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblbkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbkMouseClicked
        // TODO add your handling code here:
        int baris = tblbk.rowAtPoint(evt.getPoint());
        String idbmm = tblbk.getValueAt(baris, 0).toString();
        idbk.setText(idbmm);
        String kdCli = tblbk.getValueAt(baris, 1).toString();
        t_kdClient.setText(kdCli);
        String namaCli = tblbk.getValueAt(baris, 2).toString();
        t_namaClient.setText(namaCli);
        String kdbrg = tblbk.getValueAt(baris, 3).toString();
        t_kdBrg.setText(kdbrg);
        String namabrg = tblbk.getValueAt(baris, 4).toString();
        t_namaBrg.setText(namabrg);
        String sat = tblbk.getValueAt(baris, 5).toString();
        t_satuan.setText(sat);
        String hs = tblbk.getValueAt(baris, 6).toString();
        t_hargasatuan.setText(hs);
        String hargap = tblbk.getValueAt(baris, 7).toString();
        t_hargapeng.setText(hargap);
        String ket = tblbk.getValueAt(baris, 8).toString();
        t_ket.setText(ket);
        String jmlh = tblbk.getValueAt(baris, 9).toString();
        t_jumlah.setText(jmlh);
        tglpb.setDate(getTanggalFromTable(tblbk, 10));
        String totalP = tblbk.getValueAt(baris, 11).toString();
        t_totalpenge.setText(totalP);
        String pmbyr = tblbk.getValueAt(baris, 12).toString();
        t_pembayaran.setText(pmbyr);
        String kmbl = tblbk.getValueAt(baris, 13).toString();
        t_kembalian.setText(kmbl);
        String keun = tblbk.getValueAt(baris, 14).toString();
        t_keuntungan.setText(keun);
    }//GEN-LAST:event_tblbkMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Cari();
    }//GEN-LAST:event_jButton5ActionPerformed

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
    private javax.swing.JTextField idbk;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField t_cari;
    private javax.swing.JTextField t_hargapeng;
    private javax.swing.JTextField t_hargasatuan;
    private javax.swing.JTextField t_jumlah;
    private javax.swing.JTextField t_kdBrg;
    private javax.swing.JTextField t_kdClient;
    private javax.swing.JTextField t_kembalian;
    private javax.swing.JTextArea t_ket;
    private javax.swing.JTextField t_keuntungan;
    private javax.swing.JTextField t_namaBrg;
    private javax.swing.JTextField t_namaClient;
    private javax.swing.JTextField t_pembayaran;
    private javax.swing.JTextField t_satuan;
    private javax.swing.JTextField t_totalpenge;
    private javax.swing.JTable tblbk;
    private com.toedter.calendar.JDateChooser tglpb;
    // End of variables declaration//GEN-END:variables
}
