/*
 * Abstract class yang berisi method setter dan getter untuk Login
 */
package crud;

/**
 * Abstract class untuk User yang berisi method setter dan getter
 * @author F.Nurhayati
 */
public abstract class AbstractUser {
    protected String userID;
    protected String username;
    protected String password;
    protected String nama;
    protected String level;
    
    // Constructor
    public AbstractUser() {
    }
    
    public AbstractUser(String userID, String username, String password, String nama, String level) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.level = level;
    }
    
    // Setter Methods
    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setLevel(String level) {
        this.level = level;
    }
    
    // Getter Methods
    public String getUserID() {
        return userID;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getNama() {
        return nama;
    }
    
    public String getLevel() {
        return level;
    }
    
    // Abstract method yang harus diimplementasikan oleh subclass
    public abstract void displayUserInfo();
}