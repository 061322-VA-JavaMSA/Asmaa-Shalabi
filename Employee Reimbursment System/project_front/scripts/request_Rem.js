var elem = document.getElementById('approve');
if(!principal){
  window.location.href="./login.html";
}
if(!principal ){
  window.location.href="./login.html";
}else if (principal.role == 'ADMIN' ){
  getRems();
}
else{
  getRemsById();
}
async function getRems(){

  let response = await fetch(`${apiUrl}/rems`, {
      credentials: 'include'
  });

  if(response.status == 200){
      let data = await response.json();

      populateTable(data);
  } else{
      console.log('Unable to retrieve rems.')
  }
  elem.addEventListener('click', approveOrDeny);
}
async function getRemsById(){
  
    elem.parentNode.removeChild(elem);

  let response = await fetch(`${apiUrl}/rems`, {
      credentials: 'include'
  });

  if(response.status == 200){
      let data = await response.json();

      populateTableById(data);
  } else{
      console.log('Unable to retrieve rems.')
  }
  
}

function populateTable(data){
  
  let tableBody = document.getElementById('tasks-tbody');

  data.forEach(user => {
   console.log(user);
      let tr = document.createElement('tr');
      let tdId = document.createElement('td');
      let tdDescription = document.createElement('td');
      let tdEmId = document.createElement('td');
      let tdAmount = document.createElement('td');
      let tdStatus = document.createElement('td');
      tdId.innerHTML = user.id;
      tdDescription.innerHTML = user.description;
      tdEmId.innerHTML = user.employee_id;
      tdAmount.innerHTML = user.amount;
      tdStatus.innerHTML = user.status;
      
      tr.append(tdId);
      tr.append(tdDescription);
      tr.append(tdEmId);
      tr.append(tdAmount);
      tr.append(tdStatus);

      tableBody.append(tr);
  });
}
function populateTableById(data){
  
  let tableBody = document.getElementById('tasks-tbody');

  data.forEach(user => {
   console.log(user);
      let tr = document.createElement('tr');
      let tdId = document.createElement('td');
      let tdDescription = document.createElement('td');
      let tdEmId = document.createElement('td');
      let tdAmount = document.createElement('td');
      let tdStatus = document.createElement('td');
      tdId.innerHTML = user.id;
      tdDescription.innerHTML = user.description;
      tdEmId.innerHTML = user.employee_id;
      tdAmount.innerHTML = user.amount;
      tdStatus.innerHTML = user.status;
      
      tr.append(tdId);
      tr.append(tdDescription);
      tr.append(tdEmId);
      tr.append(tdAmount);
      tr.append(tdStatus);
if (principal.id ===user.employee_id )
      {tableBody.append(tr);}
  });
}

async function approveOrDeny(){
  window.location.href= "../appNden.html";
}