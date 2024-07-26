var inputElement;
var textElement;
var massage;
//var yourName = "[[${name}]]";

function getText() {
  inputElement = document.getElementById("myInput"); // input text
//  userNameInputElement = document.getElementById("userName"); // userName
  textElement = document.getElementById("messages"); // output

  const inputText = inputElement.value;
//  const userName = userNameInputElement.value;
  textElement.value = inputText;

  console.log("textElement entered: " + inputText);
  console.log("your name in channels.js: " + yourName);

  message = {
      "messageUser": yourName, //"Test-User-Name", //userName, //userName,
      "messageText": inputText //textElement
  }

  console.log("******yourname****************" + yourName); // Prints the entered text to the console
  //console.log(
  sendDataToServer(message);
}

function sendDataToServer(message) {
  fetch('http://localhost:8080/channels2', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(message)
  })
  .then(response => response.json())
  .then(data => console.log(data))
  //.then(data => {console.log('Server response:', massage);})
  .catch(error => {console.error('Error:', error);});
}