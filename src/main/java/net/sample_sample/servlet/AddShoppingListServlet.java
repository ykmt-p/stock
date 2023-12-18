package net.sample_sample.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sample_sample.dao.AddShoppingDAO;
import net.sample_sample.model.AddShopping;


@WebServlet("/AddShoppingList")
public class AddShoppingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/addShoppingList.jsp");
	    dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログインした時にユーザーが入力したユーザーIDを取得
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		// ユーザーから送信された情報を取得
	    String product_name = request.getParameter("product_name");
	    int quantity = Integer.parseInt(request.getParameter("quantity"));
	    String store = request.getParameter("store");

	    // AddShoppingオブジェクトを作成
	    AddShopping addShopping = new AddShopping(user_id, product_name, quantity, store);

	    // AddShoppingDAOを使用してユーザーの登録を試みる
	    AddShoppingDAO addShoppingDAO = new AddShoppingDAO();
	    
        // createメソッドの戻り値（user_idかエラーメッセージ）を取得    
        String result = addShoppingDAO.create(addShopping);
   
        if (result == product_name) {
            // 登録成功の処理
        	request.setAttribute("message", "新規登録が完了しました！");
            request.setAttribute("product_name", result); // 商品名をリクエスト属性に設定
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/addShoppingList.jsp");
            dispatcher.forward(request, response);
        } else {
            // 登録に失敗した場合、エラーメッセージをセットして新規登録画面にフォワード
            request.setAttribute("errorMessage", result);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/addShoppingList.jsp");
            dispatcher.forward(request, response);
        }
	}
}
