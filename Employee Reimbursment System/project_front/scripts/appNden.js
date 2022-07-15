let reqsList = document.getElementById("pend-req");

async function getPendingReqs() {
  let response = await fetch(`${apiUrl}/rems`);

  if(response.status == 200) {
    let data = await response.json();

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
  } else {
    console.log('Unable to retrieve users.')
  }
}

getPendingReqs();
let denidList = document.getElementById("subBtn");
denidList.addEventListener('click', deny);

async function approve(id) {
  const data = {
    id: id,
    status: "approved",
    reimbResolverId: principal.id
  }
  const response = await fetch(`${apiUrl}/rems/?id=${data.reimbId}&status=${data.status}&resolverId=${data.resolverId}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data) // body data type must match "Content-Type" header
  });
  location.reload();
  return response.json(); // parses JSON response into native JavaScript objects
}

async function deny(id) {
  const data = {
    id: id,
    status: "denied",
    resolverId: principal.id
  }
  const response = await fetch(`${apiUrl}/rems/?id=${data.id}&status=${data.status}&resolvedId=${data.resolvedId}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data) // body data type must match "Content-Type" header
  });
  location.reload();
  return response.json(); // parses JSON response into native JavaScript objects
}