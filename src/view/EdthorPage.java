package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import article.DoEssay;
import entity.Essay;
import entity.User;


@WebServlet("/editor")
@MultipartConfig
public class EdthorPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EdthorPage() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		if(se.getAttribute("logUser") == null) {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().append("请登陆后再访问!");
			response.setHeader("refresh", "2;url=/home/login"); 
		} else {
			request.getRequestDispatcher("/WEB-INF/web/editor.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession se = request.getSession();
		Essay essay = new Essay();
		User user = new User();
		user = (User) se.getAttribute("logUser");
		essay.setEssayName(request.getParameter("title"));
		essay.setAuthor_id(user.getId());
		if(request.getParameter("colOptions") != null) {
			essay.setClassName(request.getParameter("colOptions"));
		} else {
			essay.setClassName("news");
		}
		essay.setContent(request.getParameter("content"));
		essay.setEssayStatus(2);
		if(DoEssay.insertEssay(essay)) {
			request.getRequestDispatcher("/WEB-INF/web/waitTest.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/web/failed.jsp").forward(request, response);
		}
	}

}
