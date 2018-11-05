package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import column.Columns;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
						, urlPatterns = { "/*" })
public class NavInput implements Filter {

    public NavInput() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		Columns navs = new Columns();//必要
		HttpSession se = ((HttpServletRequest)request).getSession();
		List<String> navsKeys = new ArrayList<>();
		
		//顶端导航栏
		if(se.getAttribute("topnav") == null) {
			
		}
		
		
		if(se.getAttribute("navsKeys") == null) {
			//导航栏
			for(String Ename:navs.getColumnMap().keySet()) {
				navsKeys.add(Ename);
				se.setAttribute(Ename, navs.getColumnMap().get(Ename));
			}
			se.setAttribute("navsKeys", navsKeys);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
