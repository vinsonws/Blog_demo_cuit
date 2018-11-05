package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.EssayOne;


@WebServlet("/essay")
public class EssayPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EssayPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession se = request.getSession();
		se.setAttribute("essay", EssayOne.TheEssay(request.getParameter("className"), Integer.parseInt(request.getParameter("essay_id"))));
		request.getRequestDispatcher("WEB-INF/web/essay.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
