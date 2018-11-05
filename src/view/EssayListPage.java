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
import list.EssayList;


@WebServlet("/essayList")
public class EssayListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EssayListPage() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession se = request.getSession();
		String className = "news";
		int maxNum = 10;
		int page = 1;
		if(request.getParameter("className") != null && request.getParameter("className").length()>0) className = request.getParameter("className");
		if(request.getParameter("maxNum") != null && request.getParameter("maxNum").length()>0) maxNum = Integer.parseInt(request.getParameter("maxNum"));
		if(request.getParameter("page") != null && request.getParameter("page").length()>0 && !request.getParameter("page").equals("0")) page = Integer.parseInt(request.getParameter("page"));
		List<Essay> essayList = EssayList.listMenuOnlyPass(className, maxNum, page);
		se.setAttribute("className",  EssayList.getZHName(className));
		List<Integer> listAllNum = new ArrayList<>();
		for(int i=1;i<=EssayList.getEssayListPageNum(className, maxNum, page);i++){
			listAllNum.add(i);
		}

		se.setAttribute("essayList", essayList);
		se.setAttribute("nowCol", request.getParameter("className"));
		se.setAttribute("listAllNum", listAllNum);
		se.setAttribute("pagePre", page - 1);
		se.setAttribute("page", page);
		int pageNext = page + 1;
		if(pageNext > listAllNum.size()) pageNext = 0;
		se.setAttribute("pageNext",  pageNext);
		request.getRequestDispatcher("WEB-INF/web/listmenu.jsp").forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
