/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
/**
 *
 * @author F.Nurhayati
 */
public class Login extends AbstractUser implements AuthInterface {

    private Connection koneksi;
    private PreparedStatement psmt;
    private ResultSet dataUser;
    private String query;

    public Login() {
        KoneksiMysql connection = new KoneksiMysql();
        try {
            koneksi = connection.getKoneksi();
        } catch (SQLException ex) {
            System.out.println("Koneksi gagal: " + ex.getMessage());
        }
    }

    @Override
    public ResultSet cekLogin(String username, String password) throws SQLException {
        query = "SELECT nama FROM user WHERE id_user=? AND password=md5(?)";
        psmt = koneksi.prepareStatement(query);
        psmt.setString(1, username);
        psmt.setString(2, password);
        dataUser = psmt.executeQuery();

        if (dataUser.next()) {
            // Login berhasil, set session
            Session.setUserID(username);
            Session.setNama(dataUser.getString("nama"));
            Session.setStatusLogin("AKTIF");

            // Catat log login
            logLogin(username);
        } else {
            // Login gagal
            throw new SQLException("Login gagal: Username atau password salah.");
        }

        return dataUser;
    }

    @Override
    public void logout(String userID) throws SQLException {
        logLogout(userID); // Panggil method yang sudah dibuat
        koneksi.close();   // Tutup koneksi
        Session.setUserID(null);
        Session.setNama(null);
        Session.setStatusLogin(null);
    }

    @Override
    public void logLogin(String userID) throws SQLException {
        query = "INSERT INTO log_login (id_user) VALUES (?)";
        psmt = koneksi.prepareStatement(query);
        psmt.setString(1, userID);
        psmt.executeUpdate();
        psmt.close();
    }

    @Override
    public void logLogout(String userID) throws SQLException {
        query = "UPDATE log_login SET waktu_logout=CURRENT_TIMESTAMP() WHERE id_user=? ORDER BY id DESC LIMIT 1";
        psmt = koneksi.prepareStatement(query);
        psmt.setString(1, userID);
        psmt.executeUpdate();
        psmt.close();
    }

    @Override
    public void displayUserInfo() {
        System.out.println("=== Informasi User ===");
        System.out.println("User ID: " + (this.userID != null ? this.userID : "Tidak ada"));
        System.out.println("Nama: " + (Session.getNama() != null ? Session.getNama() : "Tidak ada"));
        System.out.println("Status Login: " + (Session.getStatusLogin() != null ? Session.getStatusLogin() : "Tidak aktif"));
    }
}