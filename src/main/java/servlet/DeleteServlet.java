package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; // HttpSessionのインポートを追加

import dao.DeleteDAO;
import dao.DeleteStockListDAO;
import model.Delete;
import model.DeleteStock;

@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 商品情報を格納するリストを作成
        List<Delete> deleteList = new ArrayList<>();

        // フォームから送信された選択された商品情報を取得
        String[] selectedItems = request.getParameterValues("selectedItems");
        
        for (String item : selectedItems) {
            // 商品情報を解析してConsumeオブジェクトを作成し、リストに追加
            String[] itemInfo = item.split("-");
            if (itemInfo.length == 3) {
                int quantity = 0; // ここでQUANTITYを0に設定
                String userId = itemInfo[2];
                String productName = itemInfo[1];
                Delete delete = new Delete(userId, productName, quantity);
                deleteList.add(delete);
            }
        }

        // DeleteDAOを使用して数量の更新を試みる
        DeleteDAO deleteDAO = new DeleteDAO();

        // 新しいメソッドを使用してデータベースを更新
        try {
            // すべての商品情報を送信
            deleteDAO.deleteAll(deleteList, request);
            request.setAttribute("message", "消費しました!");

            // DeleteStockListを再取得してリストを更新
            HttpSession session = request.getSession();
            DeleteStockListDAO deleteStockListDAO = new DeleteStockListDAO();
            List<DeleteStock> deleteStockList = deleteStockListDAO.findAll(session);

            // リクエスト属性にデリートストックリストを設定
            request.setAttribute("deleteStockList", deleteStockList);

            // 商品名をリクエスト属性に設定
            request.setAttribute("product_name", deleteList.get(0).getProduct_name()); 
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/deleteStockList.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // 登録に失敗した場合、エラーメッセージをセットして新規登録画面にフォワード
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/deleteStockList.jsp");
            dispatcher.forward(request, response);
        }
    }
}
