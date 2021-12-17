/**
 * 
 */

function main() {
	fetch()
		.then(response => response.json())
		.then(studentList => printStudents(studentList))
}

function printStudents(studentList) {
	var tableOutput = document.getElementById("tableBody")

	var tableData = "<tr>" +
		"<th> ID </th>" +
		"<th> Last name </th>" +
		"<th> First name </th>" +
		"<th> Street </th>" +
		"<th> Postcode </th>" +
		"<th> Post office </th>"


	console.log(studentList)

	for (var student of studentList) {
		tableData += "<tr> <td>"
			+ student.id
			+ "</td> <td>"
			+ student.lastName
			+ "</td> <td>"
			+ student.firstName
			+ "</td> <td>"
			+ student.streetAddress
			+ "</td> <td>"
			+ student.postCode
			+ "</td> <td>"
			+ student.postOffice
			+ "</td> </tr>"
	}

	tableOutput.innerHTML = tableData
}

getDataFromServer("http://localhost:8080/WebAppExercises/students", printStudents)