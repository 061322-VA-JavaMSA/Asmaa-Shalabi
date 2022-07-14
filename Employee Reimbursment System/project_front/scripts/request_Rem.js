
if(!principal){
  window.location.href="./login.html";
}
if(!principal || principal.role !== 'ADMIN'){
  window.location.href="./login.html";
}else{
  getRems();
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

async function login(){

  let username = document.getElementById('username').value;
  let password = document.getElementById('password').value;

  let response = await fetch(`${apiUrl}/auth`,{
      method: 'POST',
      credentials: 'include',
      headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
      },
      body: new URLSearchParams({
          'username': `${username}`,
          'password': `${password}`
      })
  });

  if(response.status == 200){
      let data = await response.json();

      /*
          persisting the User object sent back to session storage for use in other pages
          Session Storage only allows persistence of Strings so the JS Object is converted to a JSON string using JSON.stringify
       */
       sessionStorage.setItem('principal', JSON.stringify(data));
      // redirect to the homepage on success
      window.location.href="./employee.html";
  } else{
      console.log('Unable to login.')
  }
}