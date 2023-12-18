package net.sample_sample.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sample_sample.dao.AllThingsDAO;
import net.sample_sample.model.AllThings;


@WebServlet("/AllThings")
public class AllThingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    HttpSession session = request.getSession();

	    AllThingsDAO allThingsDAO = new AllThingsDAO();
	    
	    // findAllメソッドの戻り値を取得    
	    List<AllThings> result = allThingsDAO.findAll(session);

	    // 取得したストックリストをリクエスト属性に設定
	    request.setAttribute("allThingsList", result);

	    // フォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/allThings.jsp");
	    dispatcher.forward(request, response);
	
	}
}
