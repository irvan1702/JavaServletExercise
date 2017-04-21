package servletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
// @ServletSecurity(@HttpConstraint(rolesAllowed = {"admin","guest"}))
public class StudentServlet extends HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	private List<Student> students;

	public StudentServlet() {
		this.students = new ArrayList<Student>();
		students.add(new Student("aaa", "20"));
		students.add(new Student("bbb", "50"));
		students.add(new Student("ccc", "60"));
		students.add(new Student("ddd", "70"));
		students.add(new Student("eee", "80"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		JSONArray array = new JSONArray();
		for (int i = 0; i < students.size(); i++) {
			JSONObject json = new JSONObject();
			json.put("name", students.get(i).getName());
			json.put("id", students.get(i).getId());
			array.add(json);
		}
		JSONObject json2 = new JSONObject();
		json2.put("data", array);
		json2.put("message", "hello from server");
		out.print(json2.toString());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		JSONArray array = new JSONArray();
		List<Student> result = students.stream().filter(s->s.getName().
				equalsIgnoreCase(name) || s.getId().
				equalsIgnoreCase(id)).collect(Collectors.toList());
		
		for (int i = 0; i < result.size(); i++) {
			JSONObject json = new JSONObject();
			json.put("name", result.get(i).getName());
			json.put("id", result.get(i).getId());
			array.add(json);
		}
		JSONObject json2 = new JSONObject();
		json2.put("data", array);
		json2.put("message", "hello from server");
		out.print(json2.toString());
	}
	

}
