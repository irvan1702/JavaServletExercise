package servletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet(description = "This is a sample servlet", urlPatterns = { "/Servlet" })
public class Servlet extends HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;
	
	List<String> student = new ArrayList<String>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().setAttribute("list", student);
		if(!(null==request.getParameter("deleted"))){
			student.remove(Integer.valueOf(request.getParameter("deleted"))-1);
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name").toString();
		student.add(name);
		request.getSession().setAttribute("list", student);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
