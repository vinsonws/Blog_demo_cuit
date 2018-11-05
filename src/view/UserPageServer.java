package view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Essay;
import entity.User;
import list.SearchList;
import user.UpdateUser;


@WebServlet("/userPage")
public class UserPageServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserPageServer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		User user = (User) se.getAttribute("logUser");
		try {
			List<Essay> UserEssayList = SearchList.getEssayList(user.getUserName());
			
			se.setAttribute("userEssay", UserEssayList);
			request.getRequestDispatcher("WEB-INF/web/userPage.jsp").forward(request, response);
		} catch (Exception e){
			System.out.println("用户验证出错！");
			 response.sendRedirect("login");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		User user = (User) se.getAttribute("logUser");
		try {
			UpdateUser.updateUserPwd(user, request.getParameter("password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("login");
		}
		response.sendRedirect("userPage");
	}
	

}
