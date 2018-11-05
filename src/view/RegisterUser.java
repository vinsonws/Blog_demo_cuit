package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import user.DoLogin;
import user.RegisterOneUser;


@WebServlet("/register")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterUser() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		if(se.getAttribute("logUser") != null) {
			response.sendRedirect("home.html");
		} else {
			request.getRequestDispatcher("WEB-INF/web/register.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		User user = RegisterOneUser.register(request.getParameter("userName"), request.getParameter("inputPassword"));
		if (user != null) {
			response.sendRedirect("login");
		} else {
			response.sendRedirect("home.html");
		}
				
	}

}
