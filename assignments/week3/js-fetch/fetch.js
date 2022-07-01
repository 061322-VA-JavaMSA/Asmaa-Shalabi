// document.getElementById('getData').onclick = getData;

document.getElementById('getData').addEventListener("click", getData);
let baseApiURL = 'https://pokeapi.co/api/v2/pokemon';

 async function getData() {
  let id = document.getElementById('dataInput').value;
  console.log(`id = ${id}`);
  let httpResponse = await fetch(`${baseApiURL}/${id}`);



 if(httpResponse.status >= 200 && httpResponse.status < 300){
   let data = await httpResponse.json();
  createTable(data);
    
 } else {
    console.log('Invalid request.');
 }
 }

 //function populateData(response) {
  //console.log(response);




// /*
//     - When button is clicked, send http request to API for a specific id
//     - get the id value from input box
//     - send request to PokeAPI
//         - Method: GET
//         - Headers: None
//         - Body: None
//         - url: https://pokeapi.co/api/v2/pokemon/ + id from input box
//     - might have to convert JSON to JS object
//     - populate the data in Section
// /*
 //}
var flag = 0;
var tableDiv = document.getElementById('tableDiv');

function createTable(response) {
  console.log(response);
  

  var table = document.createElement('table');
  var rows =  2;
  var cols =  3;
  for (var i = 0; i < rows; i++){
    let tr;
    tr = document.createElement('tr');
    for(var j = 0; j < cols; j++){
        var td;
        if (i === 0 && flag === 0) {
            td = document.createElement('th');
            if(j === 0) td.innerHTML = 'name';
            else if (j === 1) td.innerHTML = 'hieght';
            else {td.innerHTML = 'weight';
            flag = 1;
          }
        }
        else{ 
        td = document.createElement('td');
        if(j === 0) td.innerHTML = response.name;
        else if (j === 1){
          
            td.innerHTML = response.height;
        }
        else{
          
           td.innerHTML = response.weight;
        }
    }
        tr.appendChild(td);
    }
    table.appendChild(tr);
}
  tableDiv.appendChild(table);

  //createTableBtn.innerHTML = 'Remove Table';
  //createTableBtn.onclick = removeTable;
}



    

   

 

// function populateData(response) {
    
// }
// */