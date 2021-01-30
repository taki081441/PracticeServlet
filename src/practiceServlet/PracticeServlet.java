package practiceServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PracticeServlet
 */
@WebServlet("/first")
public class PracticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PracticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		String jsp = "/WEB-INF/jsp/login.jsp";
//		form に入力された値は HttpServletRequest#getParameterメソッドで取得できます。
//		jsp,html側ではinput属性にname属性を指定してこっちで取得する。。
		String name = request.getParameter("simei");
		String password = request.getParameter("pass");
		String favaritoJClub = request.getParameter("jteam");
		request.setAttribute("userName", name);
		request.setAttribute("password", password);
		request.setAttribute("jteam",favaritoJClub);


		RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}