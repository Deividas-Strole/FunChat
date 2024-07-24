var inputElement;
var textElement;
var massage;

function getText() {
  inputElement = document.getElementById("myInput"); // input
  textElement = document.getElementById("messages"); // output
  const inputText = inputElement.value;
  textElement.value = inputText;
  console.log("textElement entered: " + inputText);
  message = {
      "messageUser": "Deividas", //inputElement,
      "messageText": inputText//textElement
  }

  console.log(inputText + "**********************"); // Prints the entered text to the console
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