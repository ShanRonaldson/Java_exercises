package programs;

import java.util.List;

import data_access.StudentDAO;

import models.Student;

public class StudentListProgram {

	public static void main(String[] args) {

		System.out.println("=== Print students (DAO version) ===");

		StudentDAO studentDAO = new StudentDAO();

		List<Student> studentList = studentDAO.getStudents();

		if (studentList == null) {

			System.out.println("The database is temporarily unavailable. Please try again later.");

		} else {

			for (Student student : studentList) {

				System.out.println(student.getId() + ": " + student.getFirstName() + " " + student.getLastName() + ", "

						+ student.getStrAddress() + ", " + student.getPostCode() + " " + student.getPostOffice());

			}

		}

	}

}
