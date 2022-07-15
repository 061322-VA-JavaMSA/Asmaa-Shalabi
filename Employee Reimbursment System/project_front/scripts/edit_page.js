if(principal){
let editButton = document.getElementById('subBtn');

editButton.addEventListener('click', editInfo);}
 async function editInfo(){
  
  let emId = principal.id;
  let first_name = principal.firstName;

  let last_name = principal.lastName;
 
  let username = principal.username;
  let email = principal.email;
  let role = principal.role;
  if(principal.role === "ADMIN"){
 role = "ADMIN";
  }
  else{
   role = "BASIC_ROLE";
  }
  
  let password = principal.password;
 
  let firstName2 = document.getElementById('fname').value;
  let lastName2 = document.getElementById('lname').value;
  let username2 = document.getElementById('uname').value;
  let email2 = document.getElementById('mail').value;
  let password2 = document.getElementById('pass').value;

// let object = {
//   'id': emId,
//   'first_name': (firstName !== firstName2 && firstName2 !== "") ? firstName2 : firstName,
//   'last_name': (lastName !== lastName2 && lastName2 !== "") ? lastName2 : lastName,
//   'username': (username !== username2 && username2 !== "") ? username2 : username,
//   'password': (password !== password2 && password2 !== "") ? password2 : password,
//   'email': (email !== email2 && email2 !== "") ? email2 : email
   
// };
//var myHeaders = new Headers();


//myHeaders.append("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
let response = await fetch(`${apiUrl}/users/${principal.id}`, {
  method: 'PUT',
  credentials: 'include',
  headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
  },
  body: JSON.stringify({
    'id':emId,
      'first_name': `${firstName2}`,
      'last_name': `${lastName2}`,
      'username':`${username2}`,
      'email': `${email2}`,
      'password':`${password2}`,
      'role':`${role}`
      
  })
})
  if(response.status == 201){
    
    let data = await response.json();
    sessionStorage.setItem('principal', JSON.stringify(data));
        window.location.href= "./employee_info.html";
     
    } else{
        console.log('Unable to update user.');
    }
     }
  



// let response = await fetch(`${apiUrl}/users`,  {
//   method: 'PUT',
//   credentials: 'include',
 
//   headers: {

//       myHeaders
//   },
//   body: JSON.stringify(object)
// });
// if(response.status >= 201){
//     let data = await response.json();
//sessionStorage.setItem('principal', JSON.stringify(data));
//     window.location.href= "./employee_info.html";
 
// } else{
//     console.log('Unable to update user.');
// }
// }

