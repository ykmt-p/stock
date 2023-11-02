package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegistrationDAO;
import model.Registration;
@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
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

	    // Registrationオブジェクトを作成
	    Registration registration = new Registration(user_id, pass, mail);

	    // RegistrationDAOを使用してユーザーの登録を試みる
	    RegistrationDAO registrationDAO = new RegistrationDAO();
	    
        // createメソッドの戻り値（user_idかエラーメッセージ）を取得    
        String result = registrationDAO.create(registration);
   
        if (result == user_id) {
            // 登録成功の処理
        	request.setAttribute("message", "新規登録が完了しました！");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login.jsp");
            dispatcher.forward(request, response);
        } else {
            // 登録に失敗した場合、エラーメッセージをセットして新規登録画面にフォワード
            request.setAttribute("errorMessage", result);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/newAccount.jsp");
            dispatcher.forward(request, response);
        }
	}
}
