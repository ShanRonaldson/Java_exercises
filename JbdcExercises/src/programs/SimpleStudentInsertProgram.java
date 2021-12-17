package programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import data_access.ConnectionParameters;
import data_access.DbUtils;

public class SimpleStudentInsertProgram {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		System.out.println("=== Add student === \n");

		Scanner input = new Scanner(System.in);

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

		try {

			connection = DriverManager.getConnection(ConnectionParameters.connectionString,

					ConnectionParameters.username, ConnectionParameters.password);

			String sqlText = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode,  postoffice) VALUES (?, ?, ?, ?, ?, ?)";

			preparedStatement = connection.prepareStatement(sqlText);

			preparedStatement.setInt(1, givenId);

			preparedStatement.setString(2, givenFirstname);

			preparedStatement.setString(3, givenLastname);

			preparedStatement.setString(4, givenStreetaddress);

			preparedStatement.setString(5, givenPostcode);

			preparedStatement.setString(6, givenPostoffice);

			preparedStatement.executeUpdate();

			System.out.println("Id: " + givenId + "\n First name: " + givenFirstname + "\n Last name: "

					+ givenLastname + "\n Street: " + givenStreetaddress + "\n Postcode: "

					+ givenPostcode + "\n Post office:  " + givenPostoffice);

			System.out.println("\n Student data added!");

		} catch (SQLException sqle) {

			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				System.out.println("Cannot insert the student. The student id " + givenId + " is already in use.");
			} else {
				System.out.println(
						"\n\"The database is temporarily unavailable. Please try again later. " + sqle.getMessage());
			}

		} finally {
			DbUtils.closeQuietly(preparedStatement, connection);
		}
		input.close();

	}

}