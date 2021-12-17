/**
 * 
 */
 
 function getDataFromServer(URL, showList){
	fetch(URL)
	.then(response => response.json())
	.then(list =>showList(list))
	.catch(errorText => alert("getDataFromServer failed: " + errorText))
}

function postDataToServer(URL, requestParameters, callBack){
	var requestOptions = {
		method: "POST",
		headers: {
			"Content-Type": "application/x-www-form-urlencoded"
		},
		body: requestParameters
	}
	
	fetch(URL, requestOptions)
	.then(response => {
		if(response.ok){
			return response.json();
		} else {
			throw "HTTP status code is " + response.status;
		}
	})
	.then(result => callBack(result))
	.catch(errorText => alert("postDataToServer failed: " + errorText))
}