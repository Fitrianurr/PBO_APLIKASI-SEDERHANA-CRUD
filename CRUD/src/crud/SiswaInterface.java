/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author F.Nurhayati
 */
public interface SiswaInterface {
    public String simpanData(String id, String nama, String alamat) throws SQLException;
    public ResultSet tampilData() throws SQLException;
    public String ubahData(String id, String nama, String alamat) throws SQLException;
    public String hapusData(String id) throws SQLException;
    public ResultSet cariData(String keyword) throws SQLException;
}