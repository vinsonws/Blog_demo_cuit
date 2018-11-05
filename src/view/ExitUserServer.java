package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/exitUserServer")
public class ExitUserServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ExitUserServer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		se.removeAttribute("logUser");
		se.removeAttribute("permission");
		Cookie cookie = new Cookie("userId", null);
		
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		response.sendRedirect("home.html");
	}

}
