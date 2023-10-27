package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;

public class AccountsDAO {
	//データベース接続に使う情報
    private static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";
	
    //ログイン機能の処理
    public boolean login(Login login) {
    	//JDBCドライバを読み込む
    	try {
    		Class.forName("org.h2.Driver");
    	} catch (ClassNotFoundException e) {
    		throw new IllegalStateException("JDBCドライバを読み込めませんでした");
   	 	}
        // データベースとの照合ロジックを実装する
        // JDBC接続を使用してデータベースからユーザー情報を取得し、照合する
        try {
            // データベースに接続
            Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
            
            // SQLクエリを実行して結果を取得
            String sql = "SELECT COUNT(*) FROM ACCOUNTS WHERE USER_ID = ? AND PASS = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, login.getUser_id());
            pstmt.setString(2, login.getPass());
            
            ResultSet rs = pstmt.executeQuery();
            
         // 結果を確認してログイン成功か失敗かを判定
            if (rs.next() && rs.getInt(1) > 0) {
                // ユーザーが存在し、パスワードが一致する場合はログイン成功
                System.out.println("ログイン成功");
                return true;
            } else {
                // ユーザーが存在しないか、パスワードが一致しない場合はログイン失敗
                System.out.println("ログイン失敗");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("エラー: " + e.getMessage());
            return false; // エラーが発生した場合もログイン失敗
        }
    }
}


