package index;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SampleDAO dao = new SampleDAO();
		request.setCharacterEncoding("UTF-8");
		//パラメータを受け取る
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));

		HttpSession session = request.getSession();
		//処理結果に応じてメッセージを変える
		if(dao.insert(name,age) == 0) {
			session.setAttribute("message", "登録失敗");
		}else {
			session.setAttribute("message", "登録完了");
		}

		RequestDispatcher d = request.getRequestDispatcher("/result.jsp");
		d.forward(request, response);

		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}