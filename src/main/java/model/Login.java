package model;

import java.io.Serializable;

public class Login implements Serializable {
    private String loggedInUserId;
    private String pass;

    public Login() {}
    
    public Login(String user_id, String pass) {
        this.loggedInUserId = user_id;
        this.pass = pass;
    }

    public String getUser_id() {
        return loggedInUserId;
    }

    public String getPass() {
        return pass;
    }
    
    public boolean login(String user_id, String pass2) {
        // ログイン照合ロジックをここに実装
        if (this.loggedInUserId.equals(user_id) && this.pass.equals(pass2)) {
            return true;
        } else {
            return false;
        }
    }
}
