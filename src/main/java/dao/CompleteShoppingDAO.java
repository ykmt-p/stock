package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.CompleteShopping;

public class CompleteShoppingDAO {
    // データベース接続に使う情報
    private static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    // お買い物が完了したものをDBのSHOPPINGに反映させる処理
    public void updateAllQuantities(List<CompleteShopping> completeShoppingList, HttpServletRequest request) throws SQLException {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした", e);
        }

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // すべての商品情報を処理
            for (CompleteShopping completeShopping : completeShoppingList) {
                String sql = "UPDATE SHOPPING SET quantity = 1 WHERE user_id = ? AND product_name = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, completeShopping.getUser_id());
                ps.setString(2, completeShopping.getProduct_name());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
