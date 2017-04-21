package servletPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.*;


/**
 * Servlet implementation class Servlet
 */
@WebServlet(description = "This is a sample servlet", urlPatterns = { "/StudentServlet" })
public class StudentServlet extends HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		JSONArray list = new JSONArray();
//		list.add("msg1");
//		list.add("msg2");
		JSONObject json = new JSONObject();
        json.put("name", "aaa");
        json.put("id", "20");

        response.setContentType("application/json");
        String output = json.toString();
        PrintWriter writer = response.getWriter();
        writer.write(output);
        writer.close();
	}

}
