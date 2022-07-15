let fName = document.getElementById('fName');
let lName = document.getElementById('lName');
let email = document.getElementById('email');
let userName = document.getElementById('uName');
let role = document.getElementById('role');

// Different welcome message based on logged in user retrieved from session storage
if(principal){
  console.log(principal);
    fName.innerHTML = `First Name:    ${principal.first_name}`
    lName.innerHTML = `Last Name:    ${principal.last_name}`
    email.innerHTML = `Email:   ${principal.email}`
    userName.innerHTML = `User Name:   ${principal.username}`
    
} 
let doneButton = document.getElementById('doneBtn');

doneButton.addEventListener('click', done);
let editButton = document.getElementById('editBtn');

editButton.addEventListener('click', edit);
async function done(){
  window.location.href= "./welcome_page.html";
}
async function edit(){
  window.location.href= "./edit_page.html";
}