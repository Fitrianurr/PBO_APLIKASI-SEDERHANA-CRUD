package crud;

/**
 * Class untuk mengelola session user yang sedang login
 * @author F.Nurhayati
 */
public class Session {
    private static String userID;
    private static String nama;
    private static String statusLogin;
    
    // Setter methods
    public static void setUserID(String userID) {
        Session.userID = userID;
    }
    
    public static void setNama(String nama) {
        Session.nama = nama;
    }
    
    public static void setStatusLogin(String statusLogin) {
        Session.statusLogin = statusLogin;
    }
    
    // Getter methods
    public static String getUserID() {
        return userID;
    }
    
    public static String getNama() {
        return nama;
    }
    
    public static String getStatusLogin() {
        return statusLogin;
    }
}