package model;

import java.io.Serializable;

public class Login implements Serializable {
  private String loggedInUserId;
  private String pass;
  
  public Login () {}
  public Login(String user_id, String pass) {
    this.loggedInUserId = user_id;
    this.pass = pass;
  }
  public String getUser_id() { return loggedInUserId; }
  public String getPass() { return pass; }
}