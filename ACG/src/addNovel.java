

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
 * Servlet implementation class addNovel
 */
@WebServlet("/addNovel")
public class addNovel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNovel() {
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
		int number;
		int score;
		ServletContext servletContext=getServletContext();
		RequestDispatcher dispatcher=null;		
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		if(author==""){author=null;}
		String illustrator=request.getParameter("illustrator");
		if(illustrator==""){illustrator=null;}
		String library=request.getParameter("library");
		if(library==""){library=null;}
		String character=request.getParameter("character");
		if(character==""){character=null;}
		String synopsis=request.getParameter("synopsis");
		if(synopsis==""){synopsis=null;}
		String n=request.getParameter("number");
		if(n==""){number=0;}else{
		number=Integer.parseInt(n);}
		String s=request.getParameter("score");
		if(s==""){score=0;}else{
		score=Integer.parseInt(s);}  		
		String remarks=request.getParameter("remarks");
		if(remarks==""){remarks=null;}
		Novel novel=new Novel();
		novel.setName(name);
		novel.setAuthor(author);
		novel.setIllustrator(illustrator);
		novel.setLibrary(library);
		novel.setCharacter(character);
		novel.setSynopsis(synopsis);
		novel.setNumber(number);
		novel.setScore(score);
		novel.setRemarks(remarks);
		NovelDAO novelDAO=NovelDAOFactory.getNovelDAOInstance();
		String novelname=novelDAO.findNovelbyName(name).getName();
		if(name==""){
			request.setAttribute("error", "必须出入小说名称");
			dispatcher=servletContext.getRequestDispatcher("/addNovel.jsp");
		}else if(name.equals(novelname)){
			request.setAttribute("error", "小说名称冲突");
			dispatcher=servletContext.getRequestDispatcher("/addNovel.jsp");
		}else{
		novelDAO.addNovel(novel);
   	    request.getSession().setAttribute("novelList", novel);
		response.sendRedirect("addNovel.jsp");
		return;
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
