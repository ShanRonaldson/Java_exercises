package programs;

import java.util.Scanner;

import data_access.StudentDAO;

public class StudentDeleteProgram {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StudentDAO studentDAO = new StudentDAO();
		
		System.out.println("=== Delete student ===");

		System.out.print("Enter student id: ");
		int givenId = Integer.parseInt(input.nextLine());
		
		int output = studentDAO.deleteStudent(givenId);
		
		if(output == 1) {
			System.out.println("Student deleted!");
		} else if(output == 0) {
			System.out.println("Nothing deleted. Unknown student id (" + givenId + ")");
		}
		
		input.close();
	}

}
