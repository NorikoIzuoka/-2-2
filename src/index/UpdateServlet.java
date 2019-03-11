package index;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		SampleDAO dao = new SampleDAO();
		ArrayList<Person> list =dao.selectAll();


		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));


		HttpSession session = request.getSession();
		//結果に応じてメッセージを変える
		if(dao.update(id,name,age) == 0) {
			session.setAttribute("message","更新失敗");
		}else {
			session.setAttribute("message","更新完了");
		}

RequestDispatcher d = request.getRequestDispatcher("/list.jsp");
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
