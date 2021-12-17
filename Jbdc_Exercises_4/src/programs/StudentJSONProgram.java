package programs;

import data_access.StudentDAO;

public class StudentJSONProgram {

	public static void main(String[] args) {

		System.out.println("=== Print students (DAO version) ===");

		StudentDAO studentDAO = new StudentDAO();

		String studentJSON = studentDAO.getAllStudentsJSON();

		System.out.print(studentJSON);
	}

}
