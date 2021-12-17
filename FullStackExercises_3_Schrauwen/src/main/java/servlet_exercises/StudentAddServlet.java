package servlet_exercises;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_access.StudentDAO;
import model.Student;

/**
 * Servlet implementation class StudentAddServlet
 */
@WebServlet("/addStudent")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		response.setContentType("\"application/x-www-form-urlencoded");
		response.setCharacterEncoding("UTF-8");
		
		String stringId = request.getParameter("id");
		int givenId = Integer.parseInt(stringId);
		String givenFirstName = request.getParameter("firstName");
		String givenLastName = request.getParameter("lastName");
		String givenStreetAddress = request.getParameter("streetAddress");
		String givenPostCode = request.getParameter("postCode");
		String givenPostOffice = request.getParameter("postOffice");
		
		Student studentToAdd = new Student(givenId, givenFirstName, givenLastName, givenStreetAddress, givenPostCode,
				givenPostOffice);
		
		StudentDAO studentDAO = new StudentDAO();
		
		int output = studentDAO.insertStudent(studentToAdd);
		out.print(output);
	}

}
