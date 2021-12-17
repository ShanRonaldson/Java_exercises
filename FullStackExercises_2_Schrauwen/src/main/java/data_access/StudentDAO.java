package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.Student;
import com.google.gson.Gson;

public class StudentDAO {

	public StudentDAO() {
		try {
			Class.forName(ConnectionParameters.jdbcDriver);
		} catch (ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}
	}

	private Connection openConnection() throws SQLException {
		return DriverManager.getConnection(ConnectionParameters.connectionString, ConnectionParameters.username,
				ConnectionParameters.password);
	}

	public List<Student> getStudents() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> studentList = new ArrayList<Student>();

		try {
			connection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student ORDER BY id, lastname, firstname";

			preparedStatement = connection.prepareStatement(sqlText);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");

				String firstname = resultSet.getString("firstname");

				String lastname = resultSet.getString("lastname");

				String streetaddress = resultSet.getString("streetaddress");

				String postcode = resultSet.getString("postcode");

				String postoffice = resultSet.getString("postoffice");

				studentList.add(new Student(id, firstname, lastname, streetaddress, postcode, postoffice));

			}

		} catch (SQLException sqle) {
			System.out.println("\n[ERROR] StudentDAO: getStudents() failed. " + sqle.getMessage() + "\n");
			studentList = null;

		} finally {
			DbUtils.closeQuietly(resultSet, preparedStatement, connection);
		}

		return studentList;
	}

	public Student getStudentById(int givenId) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;
		Student student = new Student();

		try {

			connection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student WHERE id = ? ORDER BY id, lastname, firstname";

			preparedStatement = connection.prepareStatement(sqlText);

			preparedStatement.setInt(1, givenId);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt("id");

				String firstname = resultSet.getString("firstname");

				String lastname = resultSet.getString("lastname");

				String streetaddress = resultSet.getString("streetaddress");

				String postcode = resultSet.getString("postcode");

				String postoffice = resultSet.getString("postoffice");

				student.setId(id);
				student.setFirstName(firstname);
				student.setLastName(lastname);
				student.setPostCode(postcode);
				student.setPostOffice(postoffice);
				student.setStrAddress(streetaddress);
			}

		} catch (SQLException sqle) {

			System.out.println("[ERROR] StudentDAO: getStudentById() failed. " + sqle.getMessage() + "\n");

		} finally {

			DbUtils.closeQuietly(resultSet, preparedStatement, connection);

		}

		return student;

	}

	public String getAllStudentsJSON() {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		ArrayList <Student> studentList = new ArrayList<Student>();

		Gson gson = new Gson();


		try {

			connection = openConnection();

			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student ORDER BY id, lastname, firstname";

			preparedStatement = connection.prepareStatement(sqlText);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt("id");

				String firstname = resultSet.getString("firstname");

				String lastname = resultSet.getString("lastname");

				String streetaddress = resultSet.getString("streetaddress");

				String postcode = resultSet.getString("postcode");

				String postoffice = resultSet.getString("postoffice");

				studentList.add(new Student(id, firstname, lastname, streetaddress, postcode, postoffice));

			}

		} catch (SQLException sqle) {

			System.out.println("\n[ERROR] StudentDAO: getAllStudents() failed. " + sqle.getMessage() + "\n");

		} finally {

			DbUtils.closeQuietly(resultSet, preparedStatement, connection);

		}

		String jsonString = gson.toJson(studentList);
		return jsonString;

	}

	public int insertStudent(Student student) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		int output = 0;

		int id = student.getId();
		String firstName = student.getFirstName();
		String lastName = student.getLastName();
		String strAddress = student.getStrAddress();
		String postCode = student.getPostCode();
		String postOffice = student.getPostOffice();

		try {

			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);

			String sqlText = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode, postoffice) VALUES (?,?,?,?,?,?)";

			preparedStatement = connection.prepareStatement(sqlText);

			preparedStatement.setInt(1, id);

			preparedStatement.setString(2, firstName);

			preparedStatement.setString(3, lastName);

			preparedStatement.setString(4, strAddress);

			preparedStatement.setString(5, postCode);

			preparedStatement.setString(6, postOffice);

			int updateResult = preparedStatement.executeUpdate();

			if (updateResult == 1) {
				output = 1;
			} else if (updateResult == 0) {
				output = 0;
			}

		} catch (SQLException sqle) {

			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {

				output = -1;

			} else {

				System.out.println("\n[ERROR] StudentDAO: insertStudent() failed. " + sqle.getMessage() + "\n");

				output = -1;

			}

		} finally {

			DbUtils.closeQuietly(preparedStatement, connection);

		}

		return output;

	}

	public int deleteStudent(int studentId) {

		Connection connection = null;

		PreparedStatement preparedStatement = null;

		int id = studentId;
		int output = 1;

		try {

			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);

			String sqlText = "DELETE FROM Student WHERE id = ?";

			preparedStatement = connection.prepareStatement(sqlText);

			preparedStatement.setInt(1, id);

			int updateCode = preparedStatement.executeUpdate();

			if (updateCode == 1) {
				output = 1;
			} else if (updateCode == 0) {
				output = 0;
			}

		} catch (SQLException sqle) {

			System.out.println("\n[ERROR] Database error. " + sqle.getMessage());
			output = -1;

		} finally {

			DbUtils.closeQuietly(preparedStatement, connection);

		}

		return output;

	}

	public int updateStudent(Student student) {
		
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		int output = 1;

		int id = student.getId();
		String firstName = student.getFirstName();
		String lastName = student.getLastName();
		String strAddress = student.getStrAddress();
		String postCode = student.getPostCode();
		String postOffice = student.getPostOffice();
		
		try {

			connection = DriverManager.getConnection(ConnectionParameters.connectionString,
					ConnectionParameters.username, ConnectionParameters.password);

			String sqlText = "UPDATE Student SET id=?, firstName=?, lastName=?, streetAddress=?, postCode=?, postOffice=? WHERE id=?";
			preparedStatement = connection.prepareStatement(sqlText);

			preparedStatement.setInt(1, id);

			preparedStatement.setString(2, firstName);

			preparedStatement.setString(3, lastName);

			preparedStatement.setString(4, strAddress);

			preparedStatement.setString(5, postCode);

			preparedStatement.setString(6, postOffice);
			
			preparedStatement.setInt(7, id);

			int updateResult = preparedStatement.executeUpdate();

			if (updateResult == 1) {
				output = 1;
			} else if (updateResult == 0) {
				output = 0;
			}

		} catch (SQLException sqle) {

			if (sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {

				output = -1;

			} else {

				System.out.println("\n[ERROR] StudentDAO: updateStudent() failed. " + sqle.getMessage() + "\n");

				output = -2;

			}

		} finally {

			DbUtils.closeQuietly(preparedStatement, connection);

		}

		return output;
	}
}
