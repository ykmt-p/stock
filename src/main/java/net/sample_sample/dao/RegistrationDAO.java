package net.sample_sample.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sample_sample.model.Registration;

public class RegistrationDAO { 
	//データベース接続に使う情報
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/STOCK";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "yuka9472";
    
    //新規登録の処理
    public  String create(Registration registration) {
    	//JDBCドライバを読み込む
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	} catch (ClassNotFoundException e) {
    		throw new IllegalStateException("JDBCドライバを読み込めませんでした");
   	 	}
    	//データベースに接続
    	try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    		//INSERT文の準備
    		String selectUserSQL = "SELECT COUNT(*) FROM ACCOUNTS WHERE USER_ID = ?";
    	    String selectEmailSQL = "SELECT COUNT(*) FROM ACCOUNTS WHERE MAIL = ?";
    	    String insertSQL = "INSERT INTO ACCOUNTS (USER_ID, PASS, MAIL) VALUES ( ?, ?, ?)";
    	    PreparedStatement selectUserStmt = conn.prepareStatement(selectUserSQL);
    	    PreparedStatement selectEmailStmt = conn.prepareStatement(selectEmailSQL);	
    	    PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
    	    
    	    // ユーザー名の一意性をチェック
        	selectUserStmt.setString(1, registration.getUser_id());
        	ResultSet userResultSet = selectUserStmt.executeQuery();
        	userResultSet.next();
        	int userCount = userResultSet.getInt(1);
        	// メールアドレスの一意性をチェック
        	selectEmailStmt.setString(1, registration.getMail());
        	ResultSet emailResultSet = selectEmailStmt.executeQuery();
        	emailResultSet.next();
        	int emailCount = emailResultSet.getInt(1);
        	
        	if (userCount > 0 && emailCount > 0) {
                return "ユーザー名とメールアドレスの両方が既に存在します。ログインから再度入り直してください。";
            } else if (userCount > 0) {
                return "ユーザー名が既に存在します";
            } else if (emailCount > 0) {
                return "メールアドレスが既に存在します";
            } else {
            	//INSERT文中の「？」に使用する値を設定してSQL文を完成
                insertStmt.setString(1, registration.getUser_id());
                insertStmt.setString(2, registration.getPass());
                insertStmt.setString(3, registration.getMail());

                int rowCount = insertStmt.executeUpdate();
                if (rowCount > 0) {
                    return registration.getUser_id(); // 登録に成功した場合にユーザー名を返す
                } else {
                    return "登録に失敗しました"; //登録に失敗
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "データベースエラーが発生しました";
        }
    }
}
