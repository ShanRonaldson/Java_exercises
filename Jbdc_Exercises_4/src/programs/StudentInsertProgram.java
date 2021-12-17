package programs;

import java.util.Scanner;

import data_access.StudentDAO;
import models.Student;

public class StudentInsertProgram {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		StudentDAO studentDAO = new StudentDAO();

		System.out.println("=== Add student === \n");

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

		Student studentToAdd = new Student(givenId, givenFirstname, givenLastname, givenStreetaddress, givenPostcode,
				givenPostoffice);

		int output = studentDAO.insertStudent(studentToAdd);

		if (output == 1) {
			System.out.println("Student data added!");
		} else if (output == 0) {
			System.out.println("Cannot insert the student. The student id \" + givenId + \" is already in use.");
		} else {
			System.out.println("\n The database is temporarily unavailable. Please try again later. ");
		}

		input.close();

	}

}
