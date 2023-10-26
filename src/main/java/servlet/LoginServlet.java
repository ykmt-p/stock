package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
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
    
 // Loginオブジェクトを作成
    Login login = new Login(user_id, pass);

 // ログイン認証後に遷移する先を格納する
    String path = "";
          

            // ユーザーIDとパスワードが一致するユーザーが存在した時
            if (res.next()) {
            	//セッションに登録するユーザーIDを設定
            	Login loggedInUserId = new Login("user_id",user_id);
                // user_idをセッションに設定する
            	HttpSession session = request.getSession();
                
                session.setAttribute("loggedInUserId", loggedInUserId);

                // ログイン成功したらトップ画面に遷移する
                path = "jsp/index.jsp";
            } else {
                // ログイン失敗の文言を追加する
                request.setAttribute("loginFailure", "ログインに失敗しました");

                // ログインに失敗したときはもう一度ログイン画面を表示する
                path = "jsp/login.jsp";
            }
        }
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }

    RequestDispatcher dispatcher = request.getRequestDispatcher(path);
    dispatcher.forward(request, response);

  }
}
