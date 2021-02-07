package practiceServlet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		String jsp = "/WEB-INF/jsp/login.jsp";
//		form に入力された値は HttpServletRequest#getParameterメソッドで取得できます。
//		jsp,html側ではinput属性にname属性を指定してこっちで取得する。。
		String name = request.getParameter("simei");
		String password = request.getParameter("pass");
		String confword = request.getParameter("cnfpass");
		String sanitaizpasswotd = Sanitaiz(confword);

		String mess = null;

		try{
			mess = CheckPassword(password,sanitaizpasswotd);
			request.setAttribute("err_messages", mess);
		}catch(Exception e){
			throw e;
		}


		String favaritoJClub = request.getParameter("jteam");

		String jleages = getServletContext().getInitParameter("JleagesTeam");

		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list1 = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("/pleades_workspace/PracticeServlet/src/practiceServlet/jleages.txt"));
			String line;
			while ((line = reader.readLine()) != null) {
			    list.add(line);
				String[] array00 = line.split(" ");
				for(int i = 0; i < array00.length; i++) {
					list1.add(array00[i]);
					System.out.println(array00[i]);
					System.out.println(list1);
				}
			}
			reader.close();
		}catch(FileNotFoundException e){
			System.out.println("ダメダメ");
		}

		request.setAttribute("userName", name);
		request.setAttribute("password", sanitaizpasswotd);
		request.setAttribute("jteam",favaritoJClub);
		request.setAttribute("jteamteams",jleages);


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


	private String Sanitaiz(String confword){
	    String confpassword = confword;

	    confpassword = confpassword.replace("&", "&amp;");
	    confpassword = confpassword.replace("\"", "&quot;");
	    confpassword = confpassword.replace("<", "&lt;");
	    confpassword = confpassword.replace(">", "&gt;");
	    confpassword = confpassword.replace("'", "&#39;");

	    return confpassword;
	}

	private String CheckPassword(String password, String sanitaizpasswotd) {
		if(password != sanitaizpasswotd) {
			err_message = setErr_message("パスうワードが一致しません。");
			return err_message;
		}else {
			err_message = setErr_message("一致しました。おめでとう");
			return err_message;
		}

	}


	private String setErr_message(String err_message) {
		this.err_message = err_message;
		return err_message;
	}

	public String getErr_message() {
		return err_message;
	}

//	public String setErr_message(String err_message) {
//		this.err_message = err_message;
//		return err_message;
//	}


}