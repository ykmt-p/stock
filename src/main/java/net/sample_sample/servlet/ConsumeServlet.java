package net.sample_sample.servlet;

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

import net.sample_sample.dao.ConsumeDAO;
import net.sample_sample.dao.StockListDAO;
import net.sample_sample.model.Consume;
import net.sample_sample.model.Stock;

@WebServlet("/Consume")
public class ConsumeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 商品情報を格納するリストを作成
        List<Consume> consumeList = new ArrayList<>();

        // フォームから送信された選択された商品情報を取得
        String[] selectedItems = request.getParameterValues("selectedItems");
        
        for (String item : selectedItems) {
            // 商品情報を解析してConsumeオブジェクトを作成し、リストに追加
            String[] itemInfo = item.split("-");
            if (itemInfo.length == 3) {
                int quantity = 0; // ここでQUANTITYを0に設定
                String userId = itemInfo[2];
                String productName = itemInfo[1];
                Consume consume = new Consume(userId, productName, quantity);
                consumeList.add(consume);
            }
        }

        // ConsumeDAOを使用して数量の更新を試みる
        ConsumeDAO consumeDAO = new ConsumeDAO();

        // 新しいメソッドを使用してデータベースを更新
        try {
            // すべての商品情報を送信
            consumeDAO.updateAllQuantities(consumeList, request);
            request.setAttribute("message", "消費しました!");

            // StockListを再取得してリストを更新
            HttpSession session = request.getSession();
            StockListDAO stockListDAO = new StockListDAO();
            List<Stock> stockList = stockListDAO.findAll(session);

            // リクエスト属性にお買い物リストを設定
            request.setAttribute("stockList", stockList);

            // 商品名をリクエスト属性に設定
            request.setAttribute("product_name", consumeList.get(0).getProduct_name()); 
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/stockList.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            // 登録に失敗した場合、エラーメッセージをセットして新規登録画面にフォワード
            request.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/stockList.jsp");
            dispatcher.forward(request, response);
        }
    }
}
