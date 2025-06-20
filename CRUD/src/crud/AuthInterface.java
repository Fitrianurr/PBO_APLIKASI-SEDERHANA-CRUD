/*
 * Interface yang berisi method-method untuk operasi database authentication
 */
package crud;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interface untuk operasi authentication database
 * @author F.Nurhayati
 */
public interface AuthInterface {
    
    /**
     * Method untuk melakukan pengecekan login user
     * @param username username yang akan dicek
     * @param password password yang akan dicek
     * @return ResultSet hasil query login
     * @throws SQLException jika terjadi error database
     */
    public ResultSet cekLogin(String username, String password) throws SQLException;
    
    /**
     * Method untuk melakukan logout user dan mencatat waktu logout
     * @param userID ID user yang akan logout
     * @throws SQLException jika terjadi error database
     */
    public void logout(String userID) throws SQLException;
    
    /**
     * Method untuk mencatat log login ke database
     * @param userID ID user yang login
     * @throws SQLException jika terjadi error database
     */
    public void logLogin(String userID) throws SQLException;
    
    /**
     * Method untuk update waktu logout di log
     * @param userID ID user yang logout
     * @throws SQLException jika terjadi error database
     */
    public void logLogout(String userID) throws SQLException;
}