/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Koneksi;
import java.sql.*;
/**
 *
 * @author Randi
 */
public class koneksi {
    private static java.sql.Connection koneksi;
    
    public static java.sql.Connection getKoneksi(){
        if(koneksi == null){
            try{
                String url = "jdbc:mysql://localhost/db_inventori";
                String user = "root";
                String Password = "";
                
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, Password);
            }catch(SQLException e){
                System.out.println("Eroor membuat koneksi" +e);
            }
        }
        return koneksi;
    }
}
