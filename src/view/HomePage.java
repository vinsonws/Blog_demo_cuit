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

import column.Columns;
import entity.Essay;
import list.EssayList;


@WebServlet("/home.html")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomePage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Columns navs = new Columns();//必要
		HttpSession se = request.getSession();
		List<String> navsKeys = new ArrayList<>();
		List<Essay> essays =  new ArrayList<>();
		
		//导航栏
		for(String Ename:navs.getColumnMap().keySet()) {
			navsKeys.add(Ename);
			se.setAttribute(Ename, navs.getColumnMap().get(Ename));
			//首页列表
			for(Essay essay:EssayList.listMenuOnlyPass(Ename, 8)) {
//				if(essay.getEssayName().length()>20) {
//					essay.setEssayName(essay.getEssayName().substring(0, 20) + "...");
//					essays.add(essay);
//				}
				essays.add(essay);
			}
		}
		se.setAttribute("navsKeys", navsKeys);
		se.setAttribute("essayList", essays);
		
		request.getRequestDispatcher("WEB-INF/web/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
