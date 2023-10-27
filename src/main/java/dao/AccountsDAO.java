package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;

public class AccountsDAO {
	//データベース接続に使う情報
    private static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";
    
    public  String create(Account account) {
    	//JDBCドライバを読み込む
    	try {
    		Class.forName("org.h2.Driver");
    	} catch (ClassNotFoundException e) {
    		throw new IllegalStateException("JDBCドライバを読み込めませんでした");
   	 	}
    	//データベースに接続
    	try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
    		//INSERT文の準備
    		String selectUserSQL = "SELECT COUNT(*) FROM ACCOUNTS WHERE USER_ID = ?";
    	    String selectEmailSQL = "SELECT COUNT(*) FROM ACCOUNTS WHERE MAIL = ?";
    	    String insertSQL = "INSERT INTO ACCOUNTS (USER_ID, PASS, MAIL, NAME) VALUES ( ?, ?, ?, ?)";
    	    PreparedStatement selectUserStmt = conn.prepareStatement(selectUserSQL);
    	    PreparedStatement selectEmailStmt = conn.prepareStatement(selectEmailSQL);	
    	    PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
    	    
    	    // ユーザー名の一意性をチェック
        	selectUserStmt.setString(1, account.getUser_id());
        	ResultSet userResultSet = selectUserStmt.executeQuery();
        	userResultSet.next();
        	int userCount = userResultSet.getInt(1);
        	// メールアドレスの一意性をチェック
        	selectEmailStmt.setString(1, account.getMail());
        	ResultSet emailResultSet = selectEmailStmt.executeQuery();
        	emailResultSet.next();
        	int emailCount = emailResultSet.getInt(1);
        	
        	if (userCount > 0 && emailCount > 0) {
                return "ユーザー名とメールアドレスの両方が既に存在します。ログインから再度入り直していただけますでしょうか";
            } else if (userCount > 0) {
                return "ユーザー名が既に存在します";
            } else if (emailCount > 0) {
                return "メールアドレスが既に存在します";
            } else {
            	//INSERT文中の「？」に使用する値を設定してSQL文を完成
                insertStmt.setString(1, account.getUser_id());
                insertStmt.setString(2, account.getPass());
                insertStmt.setString(3, account.getMail());
                insertStmt.setString(4, account.getName());

                int rowCount = insertStmt.executeUpdate();
                if (rowCount > 0) {
                    return null; //登録に成功
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

