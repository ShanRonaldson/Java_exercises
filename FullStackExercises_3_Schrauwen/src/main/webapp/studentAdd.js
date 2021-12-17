/**
 * 
 */

function addStudents() {
	var url = "http://localhost:8080/WebAppExercises/addStudent";
	var form = document.forms["addStudentForm"];

	var requestParameters =
		"id=" + form["givenId"].value +
		"&firstName=" + form["givenFirstName"].value +
		"&lastName=" + form["givenLastName"].value +
		"&streetAddress=" + form["givenStreetAddress"].value +
		"&postCode=" + form["givenPostCode"].value +
		"&postOffice=" + form["givenPostOffice"].value;

	postDataToServer(url, requestParameters, processResponseStatus);
}

function processResponseStatus(output) {

	if (output === 1) {
		alert("Student data added!")
	} else if (output === 0) {
		alert("Cannot add the student. The student id is already in use!")
	} else {
		alert("The database is temporarily unavailable. Please try again later. ")
	}
}