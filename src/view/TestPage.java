package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.DoEssay;
import article.EssayOne;
import entity.Essay;
import list.TestList;


@WebServlet("/test")
public class TestPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TestPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession se = request.getSession();
		if(se.getAttribute("permission") == null) {
			response.sendRedirect("home.html");
		}else {
			if(request.getParameter("instruct") != null && request.getParameter("className") != null && request.getParameter("essay_id") != null) {
				Essay essay = EssayOne.TheEssay(request.getParameter("className"), Integer.parseInt(request.getParameter("essay_id")));
				if(request.getParameter("instruct").equals("pass")) {
					DoEssay.passEssay(essay);
				}else if (request.getParameter("instruct").equals("failed")) {
					DoEssay.failedEssay(essay);
					System.out.println("failed");
				}
			}
			
			
			se.setAttribute("testingList", TestList.EssayTesting());
			request.getRequestDispatcher("WEB-INF/web/test.jsp").forward(request, response);
		}
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
