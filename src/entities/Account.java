package entities;

/**
 * Created by seriozhik on 11/1/2016.
 */
public class Account {
    private String username;
    private String password;

    public Account() {
        super();
    }

    public Account(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
