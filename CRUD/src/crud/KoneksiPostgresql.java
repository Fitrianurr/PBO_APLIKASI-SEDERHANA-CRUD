/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author F.Nurhayati
 */
public class KoneksiPostgresql {
    private Connection connect;
    private String driverName = "org.postgresql.Driver"; //Driver untuk koneksi ke MySQL
    private String jdbc = "jdbc:postgresql://";
    private String host = "localhost:";
    private String port = "5432/";
    private String database = "crud22110324";
    private String url = jdbc + host + port + database;
    private String username = "postgres";
    private String password = "";
    public Connection getKoneksi() throws SQLException {
        if (connect == null){
            try{
                Class.forName(driverName);
                System.out.println("Class Driver Ditemukan");
                try{
                    connect = DriverManager.getConnection(url, username, password);
                    System.out.println("Koneksi Database Sukses");
                }catch (SQLException se){
                    System.out.println("Koneksi Database Gagal : " + se);
                    System.exit(0);
                }
                }catch (ClassNotFoundException cnfe){
                    System.out.println("Class Driver Tidak Ditemukan, Terjadi Kesalahan Pada : " + cnfe);
                    System.exit(0);
                }
            }
            return connect;
    }
}