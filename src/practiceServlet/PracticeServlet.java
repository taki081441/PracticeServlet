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
	private String err_message;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		String jsp = "/WEB-INF/jsp/login.jsp";
		String errstay =  "index.jsp";
		//		form に入力された値は HttpServletRequest#getParameterメソッドで取得できます。
		//		jsp,html側ではinput属性にname属性を指定してこっちで取得する。。
		String name = request.getParameter("simei");
		String password = request.getParameter("pass");
		String confword = request.getParameter("cnfpass");
		String sanitaizpasswotd1 = Sanitaiz(password);
		String sanitaizpasswotd2 = Sanitaiz(confword);

		String mess = CheckPassword(sanitaizpasswotd1, sanitaizpasswotd2);
		try {
			if(mess != null) {
				request.setAttribute("userName", name);
				request.setAttribute("err_messages", mess);
				RequestDispatcher dispatcher = request.getRequestDispatcher(errstay);
				dispatcher.forward(request, response);
				return;
			}
		} catch (Exception e) {
			throw e;
		}

		String favaritoJClub = request.getParameter("jteam");
		request.setAttribute("userName", name);
		request.setAttribute("password", sanitaizpasswotd1);
		request.setAttribute("jteam", favaritoJClub);
		RequestDispatcher dispatcher = request.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private String Sanitaiz(String password) {
		String confpassword = password;
		confpassword = confpassword.replace("&", "&amp;");
		confpassword = confpassword.replace("\"", "&quot;");
		confpassword = confpassword.replace("<", "&lt;");
		confpassword = confpassword.replace(">", "&gt;");
		confpassword = confpassword.replace("'", "&#39;");

		return confpassword;
	}

	private String CheckPassword(String sanitaizpasswotd1, String sanitaizpasswotd2) {
		 if (sanitaizpasswotd1.equals("0000") || sanitaizpasswotd2.equals("0000")) {
			err_message = setErr_message(" '0000'は使うなよ。)");
			return err_message;
		} else if (sanitaizpasswotd1.equals("9999") || sanitaizpasswotd2.equals("9999")) {
			err_message = setErr_message(" '9999'は使うなよ。");
			return err_message;
		} else if (sanitaizpasswotd1.equals(sanitaizpasswotd2)) {
			err_message = null;
			return err_message;
		} else {
			err_message = setErr_message("パスワードが一致しません。");
			return err_message;
		}

	}

	private String setErr_message(String err_message) {
		this.err_message = err_message;
		return err_message;
	}

}