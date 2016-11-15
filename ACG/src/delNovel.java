

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Novel;
import dao.NovelDAO;
import factory.NovelDAOFactory;

/**
 * Servlet implementation class delNovel
 */
@WebServlet("/delNovel")
public class delNovel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delNovel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
//		String name=request.getParameter("search");
		String name=request.getParameter("name");
		String choice =request.getParameter("choice");
		Novel novel=new Novel();
		NovelDAO novelDAO=NovelDAOFactory.getNovelDAOInstance();
		ServletContext servletContext=getServletContext();
		RequestDispatcher dispatcher=null;		
		if(name==""){
			request.setAttribute("error", "必须出入小说名称");
			dispatcher=servletContext.getRequestDispatcher("/delNovel.jsp");
			}else{
		         if(choice.equals("查询")){
		         novel=novelDAO.findNovelbyName(name);
		         request.getSession().setAttribute("novel", novel);
			     response.sendRedirect("delNovel.jsp");
			     return;
			     }
		         if(choice.equals("确定删除")){
			      novelDAO.delNovel(name);	
			      novel=null;
			      request.getSession().setAttribute("novel", novel);
			      response.sendRedirect("delNovel.jsp");
			      return;
			      }
		}
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
