

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Novel;
import dao.NovelDAO;
import factory.NovelDAOFactory;

/**
 * Servlet implementation class GetNovelList
 */
@WebServlet("/GetNovelList")
public class GetNovelList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNovelList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NovelDAO novelDAO=NovelDAOFactory.getNovelDAOInstance();
		List<Novel>novels=novelDAO.findAllNovel();
//		System.out.println(novels.size());
//		String a=novels.get(2).getName();
		request.getSession().setAttribute("novelList", novels);
//		System.out.println(a);
		response.sendRedirect("Search.jsp");

//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
