package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Shopping;

public class ShoppingListDAO {
	//データベース接続に使う情報
    private static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    //ShoppingListを参照する
    public List<Shopping> findAll(HttpSession session) {
        String targetUserId = (String) session.getAttribute("user_id");
        List<Shopping> shoppingList = new ArrayList<>();
        //JDBCドライバを読み込む
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }
        //データベースに接続
        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            //SELECT文の準備
            String sql = "SELECT * FROM SHOPPING WHERE USER_ID = ? AND QUANTITY = 0";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, targetUserId);
            //SELECTを実行
            ResultSet rs = pstmt.executeQuery();
            //SELECT文の結果をArrayListに格納
            while (rs.next()) {
                //結果から必要なデータを取得
                String product_name = rs.getString("PRODUCT_NAME");
                int quantity = rs.getInt("QUANTITY");
                String store = rs.getString("STORE");

                // 取得したデータで新しいShoppingオブジェクトを作成
                Shopping shoppingItem = new Shopping(targetUserId, product_name, quantity, store);

                // 新しいShoppingオブジェクトをリストに追加
                shoppingList.add(shoppingItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return shoppingList;
    }
}