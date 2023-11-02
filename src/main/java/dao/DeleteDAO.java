package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Delete;

public class DeleteDAO {
    // データベース接続に使う情報
    private static final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    // ストックする必要がなくなったものをDBのSHOPPINGから削除する処理
    public void deleteAll(List<Delete> deleteList, HttpServletRequest request) throws SQLException {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした", e);
        }

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // すべての商品情報を処理
            for (Delete delete : deleteList) {
                String sql = "DELETE FROM SHOPPING WHERE user_id = ? AND product_name = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, delete.getUser_id());
                ps.setString(2, delete.getProduct_name());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}


