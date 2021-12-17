package programs;

import java.util.Scanner;

import data_access.StudentDAO;
import models.Student;

public class StudentUpdateProgram {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StudentDAO studentDAO = new StudentDAO();

		System.out.println("=== Update student ===");

		System.out.print("Id: ");
		int givenId = Integer.parseInt(input.nextLine());

		System.out.print("First name: ");
		String givenFirstname = input.nextLine();

		System.out.print("Last name: ");
		String givenLastname = input.nextLine();

		System.out.print("Street: ");
		String givenStreetaddress = input.nextLine();

		System.out.print("Postcode: ");
		String givenPostcode = input.nextLine();

		System.out.print("Post office:  ");
		String givenPostoffice = input.nextLine();

		Student studentToUpdate = new Student(givenId, givenFirstname, givenLastname, givenStreetaddress, givenPostcode,
				givenPostoffice);
		
		int output = studentDAO.updateStudent(studentToUpdate);
		
		if(output == 1) {
			System.out.println("Student updated!");
		} else if(output == 0) {
			System.out.println("Nothing updated. Unknown student id (" + givenId + ")");
		}
		

		input.close();
	}

}
