package crud;

import java.sql.*;

/**
 *
 * @author F.Nurhayati
 */
public class CRUD extends DataSiswa implements SiswaInterface {
    private String id, nama, alamat;
    private Connection CRUDkoneksi;
    private PreparedStatement CRUDpsmt;
    private Statement CRUDstat;
    private ResultSet CRUDhasil;
    private String CRUDquery;

    public CRUD() {
        try {
            KoneksiMysql connection = new KoneksiMysql();
            CRUDkoneksi = connection.getKoneksi();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    // Setter & Getter dari abstract class (boleh kamu hapus di sini, karena sudah ada di DataSiswa)
    @Override
    public void setID(String id) {
        this.id = id;
    }

    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public String getAlamat() {
        return alamat;
    }

    @Override
    public ResultSet tampilData() {
        CRUDquery = "SELECT * FROM siswa";
        try {
            CRUDstat = CRUDkoneksi.createStatement();
            CRUDhasil = CRUDstat.executeQuery(CRUDquery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }

    @Override
    public String simpanData(String id, String nama, String alamat) {
        CRUDquery = "INSERT INTO siswa VALUES (?, ?, ?)";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id);
            CRUDpsmt.setString(2, nama);
            CRUDpsmt.setString(3, alamat);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
            return "Data berhasil disimpan.";
        } catch (Exception e) {
            return "Data gagal disimpan: " + e.getMessage();
        }
    }

    @Override
    public String ubahData(String id, String nama, String alamat) {
        CRUDquery = "UPDATE siswa SET nama=?, alamat=? WHERE id=?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, nama);
            CRUDpsmt.setString(2, alamat);
            CRUDpsmt.setString(3, id);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
            return "Data berhasil diubah.";
        } catch (Exception e) {
            return "Data gagal diubah: " + e.getMessage();
        }
    }

    @Override
    public String hapusData(String id) {
        CRUDquery = "DELETE FROM siswa WHERE id=?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
            return "Data berhasil dihapus.";
        } catch (Exception e) {
            return "Data gagal dihapus: " + e.getMessage();
        }
    }

    @Override
    public ResultSet cariData(String keyword) {
        CRUDquery = "SELECT * FROM siswa WHERE id LIKE ? OR nama LIKE ?";
        try {
            CRUDpsmt = CRUDkoneksi.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, "%" + keyword + "%");
            CRUDpsmt.setString(2, "%" + keyword + "%");
            CRUDhasil = CRUDpsmt.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
        return CRUDhasil;
    }
}
