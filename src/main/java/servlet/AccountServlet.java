package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountsDAO;
import model.Account;


@WebServlet("/Account")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/newAccount.jsp");
	    dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // ユーザーから送信された情報を取得
	    String user_id = request.getParameter("user_id");
	    String pass = request.getParameter("pass");
	    String mail = request.getParameter("mail");
	    String name = request.getParameter("name");

	    // Accountオブジェクトを作成
	    Account account = new Account(user_id, pass, mail, name);

	    // AccountsDAOを使用してユーザーの登録を試みる
	    AccountsDAO accountsDAO = new AccountsDAO();
	    
	    try {
	        boolean registrationSuccess = accountsDAO.create(account);
	        if (registrationSuccess) {
	            // 登録成功の処理
	            // 例: ログイン画面にフォワード
	        	 RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/accountOK.jsp");
	 	        dispatcher.forward(request, response);
	 	    }
	    } catch (IllegalStateException e) {
	        // 登録に失敗した場合、エラーメッセージをセットして新規登録画面にフォワード
	        request.setAttribute("loginFailure", e.getMessage());
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/newAccount.jsp");
	        dispatcher.forward(request, response);
	    }
	}
}
