package model;

/**
 * Created by seriozhik on 11/1/2016.
 */
public class AccountModel {
    public boolean login(String username, String password)
    {
        return username.equalsIgnoreCase("abc")&&
                password.equalsIgnoreCase("123");
    }
}
