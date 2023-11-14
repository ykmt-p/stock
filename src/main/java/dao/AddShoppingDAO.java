package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AddShopping;

public class AddShoppingDAO {
    //データベース接続に使う情報
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/STOCK";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "yuka9472";
    
    //お買い物リストに新規登録の処理
    public String create(AddShopping addShopping) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした");
        }

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // ユーザーIDと商品名が同じものがないか確認する
            String checkSQL = "SELECT * FROM SHOPPING WHERE USER_ID = ? AND PRODUCT_NAME = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSQL);
            checkStmt.setString(1, addShopping.getUser_id());
            checkStmt.setString(2, addShopping.getProduct_name());

            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // 同じものがあったら数量を０に更新する
                String updateSQL = "UPDATE SHOPPING SET QUANTITY = 0 WHERE USER_ID = ? AND PRODUCT_NAME = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateSQL);
                updateStmt.setString(1, addShopping.getUser_id());
                updateStmt.setString(2, addShopping.getProduct_name());

                int rowCount = updateStmt.executeUpdate();
                if (rowCount > 0) {
                    return addShopping.getProduct_name(); // 更新成功
                } else {
                    return "更新に失敗しました"; // 更新失敗
                }
            } else {
                // 同じものがなかったら新しく追加する
                String insertSQL = "INSERT INTO SHOPPING (USER_ID, PRODUCT_NAME, QUANTITY, STORE) VALUES (?, ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
                insertStmt.setString(1, addShopping.getUser_id());
                insertStmt.setString(2, addShopping.getProduct_name());
                insertStmt.setInt(3, 0);  // QUANTITYを0で登録
                insertStmt.setString(4, addShopping.getStore());

                int rowCount = insertStmt.executeUpdate();
                if (rowCount > 0) {
                    return addShopping.getProduct_name(); // 登録成功
                } else {
                    return "登録に失敗しました"; // 登録失敗
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException("データベース接続またはクエリの実行に失敗しました", e);
        }
    }

}
