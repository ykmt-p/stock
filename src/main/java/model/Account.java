package model;

import java.io.Serializable;

public class Account implements Serializable {
  private String user_id;
  private String pass;
  private String mail;
  private String name;

  public Account () {}
  public Account(String user_id, String pass, String mail, String name) {
    this.user_id = user_id;
    this.pass = pass;
    this.mail = mail;
    this.name = name;

  }
  public String getUser_id() { return user_id; }
  public String getPass() { return pass; }
  public String getMail() { return mail; }
  public String getName() { return name; }
}