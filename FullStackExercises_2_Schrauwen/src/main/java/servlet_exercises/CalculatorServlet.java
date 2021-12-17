package servlet_exercises;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String operation = request.getParameter("operation");

		int result = 0;

		String operator = "";

		if (operation.equalsIgnoreCase("add")) {
			result = Integer.parseInt(x) + Integer.parseInt(y);
			operator = "+";
		} else if (operation.equalsIgnoreCase("multiply")) {
			result = Integer.parseInt(x) * Integer.parseInt(y);
			operator = "*";
		} else if (operation.equalsIgnoreCase("minus")) {
			result = Integer.parseInt(x) - Integer.parseInt(y);
			operator = "-";
		} else if (operation.equalsIgnoreCase("divide")) {
			result = Integer.parseInt(x) / Integer.parseInt(y);
			operator = "/";
		} else {
			out.println("Unsupported operation, please try again");
		}
		
		out.println(x + " " + operator + " " + y + " = " + result);

	}

}
