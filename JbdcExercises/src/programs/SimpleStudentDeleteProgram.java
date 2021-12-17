package programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import data_access.ConnectionParameters;
import data_access.DbUtils;

public class SimpleStudentDeleteProgram {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		System.out.println("=== Delete student === \n");

		Scanner input = new Scanner(System.in);
		System.out.print("Enter student id: ");
		int givenId = Integer.parseInt(input.nextLine());

		try {
			connection = DriverManager.getConnection(ConnectionParameters.connectionString,

					ConnectionParameters.username, ConnectionParameters.password);

			String sqlText = "DELETE FROM Student WHERE id = ?";

			preparedStatement = connection.prepareStatement(sqlText);

			preparedStatement.setInt(1, givenId);

			int result = preparedStatement.executeUpdate();

			if (result == 1) {

				System.out.println("Student deleted!");

			} else {

				System.out.println("Nothing deleted. Unknown student id (" + givenId + ")");

			}

		} catch (SQLException sqle) {

			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());

		} finally {

			DbUtils.closeQuietly(preparedStatement, connection);

		}

		input.close();

	}

}