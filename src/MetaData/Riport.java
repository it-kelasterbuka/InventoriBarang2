/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MetaData;

import java.io.File;
import java.sql.Connection;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Randi
 */
public class Riport {
    
    public Riport(String filename, Connection conn){
        try {
            File report = new File(filename);
            JasperReport jreprt = (JasperReport)JRLoader.loadObject(report);
            JasperPrint jprintt = JasperFillManager.fillReport(jreprt,null, conn);
            JasperViewer.viewReport(jprintt,false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Gagal Membuka Laporan","Cetak Laporan",JOptionPane.ERROR_MESSAGE);
        }
    }
}
