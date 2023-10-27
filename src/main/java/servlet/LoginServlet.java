package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountsDAO;
import model.Login;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/login.jsp");
    dispatcher.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // ユーザーから送信されたユーザーIDとパスワードを取得する。
	    String user_id = request.getParameter("user_id");
	    String pass = request.getParameter("pass");
	     
	    // Loginクラスのインスタンスを作成
	    Login login = new Login(user_id,pass);
	    
	 // AccountsDAOクラスのインスタンスを作成
	    AccountsDAO accountsDAO = new AccountsDAO();

	    // ログインメソッドを呼び出し
	    boolean success = accountsDAO.login(login);

	    if (success) {
	        // ログイン成功時の処理
	        // メッセージを設定
	        request.setAttribute("message", "ログインに成功しました");
	        System.out.println("ログイン成功");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/index.jsp");
	        dispatcher.forward(request, response);
	    } else {
	        // ログイン失敗時の処理
	        // メッセージを設定
	        request.setAttribute("message", "ログインに失敗しました");
	        System.out.println("ログイン失敗");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
	        dispatcher.forward(request, response);
	    }
	}

}
