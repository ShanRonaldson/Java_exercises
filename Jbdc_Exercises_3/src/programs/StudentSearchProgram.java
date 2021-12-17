package programs;
import java.util.Scanner;

import data_access.StudentDAO;
import models.Student;

public class StudentSearchProgram {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("=== Find student by id (DAO version) ===");
		
		StudentDAO studentDAO = new StudentDAO();
		
		System.out.print("Enter student id: ");		

		int givenId = Integer.parseInt(input.nextLine());
		
		Student studentToFind = studentDAO.getStudentById(givenId);
		
		if(studentToFind != null){
			System.out.print(studentToFind.toString());
		} else {
			System.out.print("Unknown student id" + " (" + givenId + ")");
		}
		input.close();
	}
}
