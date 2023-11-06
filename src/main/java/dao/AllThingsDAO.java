package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.AllThings;

public class AllThingsDAO {
	//データベース接続に使う情報
    private static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";
    
    public List<AllThings> findAll(HttpSession session) {
        String targetUserId = (String) session.getAttribute("user_id"); 
        List<AllThings> allThingsList = new ArrayList<>();
        
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            String sql = "SELECT * FROM SHOPPING WHERE USER_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, targetUserId);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                //結果から必要なデータを取得
                String product_name = rs.getString("PRODUCT_NAME");
                int quantity = rs.getInt("QUANTITY");
                String store = rs.getString("STORE");

                // 取得したデータで新しいAllThingsオブジェクトを作成
                AllThings allThingsItem = new AllThings(targetUserId, product_name, quantity, store);

                // 新しいAllThingsオブジェクトをリストに追加
                allThingsList.add(allThingsItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return allThingsList;
    }
}