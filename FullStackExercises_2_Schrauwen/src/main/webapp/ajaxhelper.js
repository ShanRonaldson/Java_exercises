/**
 * 
 */
 
 function getDataFromServer(URL, showList){
	fetch(URL)
	.then(response => response.json())
	.then(list =>showList(list))
	.catch(errorText => alert("getDataFromServer failed: " + errorText))
}