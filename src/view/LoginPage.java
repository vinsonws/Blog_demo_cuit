package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import user.DoLogin;
import user.UserPremission;


@WebServlet("/login")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginPage() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		if(se.getAttribute("logUser") != null) {
			response.sendRedirect("home.html");
		} else {
			request.getRequestDispatcher("WEB-INF/web/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		User user = DoLogin.doLog(request.getParameter("userName"), request.getParameter("password"));
		if(user == null) {
			se.setAttribute("userError", 1);
			response.setHeader("refresh", "0");
		} else {
			se.setAttribute("logUser", user);
			if(UserPremission.IsAdmin(user)) se.setAttribute("permission", "admin");
			else se.setAttribute("permission", "user");
			if ("rememberme".equals((request.getParameter("autoLogin")))) {
				Cookie cookie = new Cookie("userId", Integer.toString(user.getId()));
				System.out.println("cookies");
				cookie.setMaxAge(7 * 24 * 60 *60);
				response.addCookie(cookie);
			}
			response.sendRedirect("home.html");
		}
	}

}
