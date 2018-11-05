package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Essay;
import list.SearchList;

@WebServlet("/searchDataServer")
public class SearchDataServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchDataServer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		HttpSession se = request.getSession();
		int maxNum = 10;
		int page = 1;
		if(request.getParameter("searchdata") == null) response.sendRedirect("home.html");
		if(request.getParameter("maxNum") != null) maxNum = Integer.parseInt(request.getParameter("maxNum"));
		if(request.getParameter("page") != null && !request.getParameter("page").equals("0") ) page = Integer.parseInt(request.getParameter("page"));
		List<Essay> essayList = SearchList.getEssayList(request.getParameter("searchdata"));
		List<Essay> afterList = SearchList.afterPage(essayList, maxNum, page);
		se.setAttribute("searchDataList", afterList);

		List<Integer> listAllNum = new ArrayList<>();
		for(int i=1;i<=SearchList.afterPageNum(essayList, maxNum, page);i++){
			listAllNum.add(i);
		}
		se.setAttribute("searchData", request.getParameter("searchdata"));
		se.setAttribute("listAllNum", listAllNum);
		se.setAttribute("pagePre", page - 1);
		se.setAttribute("page", page);
		int pageNext = page + 1;
		if(pageNext > listAllNum.size()) pageNext = 0;
		se.setAttribute("pageNext",  pageNext);
		request.getRequestDispatcher("WEB-INF/web/search.jsp").forward(request, response);
	}
}
