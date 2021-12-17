package servlet_exercises;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Student;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/jsontest")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		Student one = new Student(23, "Shannon","Schrauwen", "Töölönkatu 11", "00100", "Helsinki");
		Student two = new Student(33, "Niilo", "Laamanen", "Sahatie 2", "00100", "Vantaa");
		
		studentList.add(one);
		studentList.add(two);
		
		Gson gson = new Gson();
		String json = gson.toJson(studentList);
		out.println(json);
	}


}
