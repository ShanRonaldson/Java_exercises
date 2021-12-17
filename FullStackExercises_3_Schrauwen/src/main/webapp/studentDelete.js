/**
 * 
 */
 
 function deleteStudent(){
		var url = "http://localhost:8080/WebAppExercises/deleteStudent";
		
		var form = document.forms["deleteStudentForm"];
		
		var requestParameters =
		"id=" + form["givenId"].value
		
		console.log(requestParameters)
		
		postDataToServer(url, requestParameters, processResponseStatus);
}

function processResponseStatus(output){
	console.log(output)
	if(output === 1){
		alert("Student data deleted!")
	} else if(output === 0){
		alert("Student data not deleted. Unknown student ID.")
	} else{
		alert("The database is temporarily unavailable. Please try again later. ")
	}
}