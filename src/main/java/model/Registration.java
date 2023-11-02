package model;

import java.io.Serializable;

public class Registration implements Serializable {
  private String user_id;
  private String pass;
  private String mail;

  public Registration () {}
  public Registration(String user_id, String pass, String mail) {
    this.user_id = user_id;
    this.pass = pass;
    this.mail = mail;


  }
  public String getUser_id() { return user_id; }
  public String getPass() { return pass; }
  public String getMail() { return mail; }
}