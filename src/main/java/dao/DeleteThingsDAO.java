package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DeleteThings;

public class DeleteThingsDAO {
    // データベース接続に使う情報
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/STOCK";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "yuka9472";

    // ストックする必要がなくなったものをDBのSHOPPINGから削除する処理
    public void deleteAll(List<DeleteThings> deleteThingsList, HttpServletRequest request) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバを読み込めませんでした", e);
        }

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
            // すべての商品情報を処理
            for (DeleteThings deleteThings : deleteThingsList) {
                String sql = "DELETE FROM SHOPPING WHERE user_id = ? AND product_name = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, deleteThings.getUser_id());
                ps.setString(2, deleteThings.getProduct_name());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}


