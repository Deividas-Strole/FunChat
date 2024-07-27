var inputElement;
var textElement;
var massage;
//var yourName = "[[${name}]]";

const sendDataToServer = async (message) => {

  //const data = {message: message};

  try {

    const response = await fetch('http://localhost:8080/channels2', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(message)
    });

    if (!response.ok) {
      throw new Error('Network response was not ok');
    }

    // The response is now HTML, so we'll load it into the document
    const htmlContent = await response.text();
    document.open();
    document.write(htmlContent);
    document.close();
  }

    catch (error) {
    console.error('Error:', error);
  }

};

function getText() {

//  userNameInputElement = document.getElementById("userName"); // userName
  textElement = document.getElementById("messages"); // output
  inputElement = document.getElementById("myInput"); // input text


  const inputText = inputElement.value;
  console.log("2 input text before assignation: " + inputText);
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



// *************** my func
//function sendDataToServer(message) {
//  fetch('http://localhost:8080/channels2', {
//    method: 'POST',
//    headers: {
//      'Content-Type': 'application/json'
//    },
//    body: JSON.stringify(message)
//  })
//  .then(                        //response => response.json())
//  {
//    const htmlContent = await response.text();
//        document.open();
//        document.write(htmlContent);
//        document.close();
//  })
//
//
//  .then(data => console.log(data))
//  //.then(data => {console.log('Server response:', massage);})
//  .catch(error => {console.error('Error:', error);});
//}