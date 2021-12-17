package servlet_exercises;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data_access.StudentDAO;

/**
 * Servlet implementation class StudentDeleteServlet
 */
@WebServlet("/deleteStudent")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter output = response.getWriter();
		
		int givenId = Integer.parseInt(request.getParameter("id"));
		
		StudentDAO studentDAO = new StudentDAO();
		
		int result = studentDAO.deleteStudent(givenId);
		
		output.print(result);
	}

}
