let loginButton = document.getElementById('submitBtn');

loginButton.addEventListener('click', createRem);

async function createRem(){
  
  let amount = document.getElementById('amount').value;
  let description = document.getElementById('description').value;
  let emId = principal.id;
  console.log(amount);
  // let response = await fetch(`${apiUrl}/rems`,{
  //     method: 'POST',
  //     credentials: 'include',
  //     headers: {
  //         'Content-Type': 'application/x-www-form-urlencoded'
  //     },
  //     body: new URLSearchParams({
  //         amount: `${amount}`,
  //         description: `${description}`,
  //         employee_id:`${emId}`
          
  //     })
  // });
  let object = {
    'amount': Number.parseFloat(document.getElementById('amount').value),
    'description': document.getElementById('description').value,
    
    'employee_id': emId,
    
}
console.log(object); // The data has been sent
let response = await fetch(`${apiUrl}/rems`, {
    method: 'POST',
    credentials: 'include',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded'
    },
    body: JSON.stringify(object)
})

  if(response.status > 200 && response.status < 205){
    //  let data = await response.json();

      /*
          persisting the User object sent back to session storage for use in other pages
          Session Storage only allows persistence of Strings so the JS Object is converted to a JSON string using JSON.stringify
       */
       //sessionStorage.setItem('principal', JSON.stringify(data));
      // redirect to the homepage on success
      window.location.href= "./welcome_page.html";
  } else{
      console.log('Unable to create reimbursment.')
  }
}
