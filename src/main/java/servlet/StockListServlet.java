package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StockListDAO;
import model.Stock;


@WebServlet("/StockList")
public class StockListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // ログインした時にユーザーが入力したユーザーIDを取得
	    HttpSession session = request.getSession();

	    // StockListDAOを使用してお買い物リストの参照を試みる
	    StockListDAO stockListDAO = new StockListDAO();
	    
	    // findAllメソッドの戻り値を取得    
	    List<Stock> result = stockListDAO.findAll(session);

	    // 取得したショッピングリストをリクエスト属性に設定
	    request.setAttribute("stockList", result);

	    // フォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/stockList.jsp");
	    dispatcher.forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	}

}
