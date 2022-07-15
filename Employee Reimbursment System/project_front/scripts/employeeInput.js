let ele = document.getElementById('newBtn');
ele.addEventListener('click', getEmployeeRems);

async function getEmployeeRems(){
  let em2 = Number.parseFloat(document.getElementById('emlid').value);
  console.log(em2);

  if(em2){
  window.location.href="./singleRem.html";}
}
