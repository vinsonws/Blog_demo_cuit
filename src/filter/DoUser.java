package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import user.LoginFromCookies;
import user.UserPremission;

@WebFilter("/*")
public class DoUser implements Filter {


    public DoUser() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Cookie[] cookies = ((HttpServletRequest) request).getCookies();
		HttpSession se = ((HttpServletRequest)request).getSession();
		if(se.getAttribute("logUser") == null) {
			//boolean flag = true;
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("userId") && cookie.getValue().length() > 0) {
					User user = LoginFromCookies.getUser(Integer.parseInt(cookie.getValue()));
					if(user != null) {
						se.setAttribute("logUser", user);
						//flag = false;
						if(UserPremission.IsAdmin(user)) se.setAttribute("permission", "admin");
						else se.setAttribute("permission", "user");
					}
					
					break;
				}
			}
			
//			if(flag) {
//				((HttpServletResponse)response).setHeader("refresh", "2;url=/home/login");   
//			}
			
		}
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
