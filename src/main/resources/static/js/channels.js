var inputElement;
var textElement;
var massage;
//var yourName = "[[${name}]]";

//function fetchDataFromServer(message) {
//  fetch('http://localhost:8080/channels2')
//    .then(response => response.json())
//    .then(data => {
//      console.log('Data from server:', message);
//      updateDOM(message);
//    })
//    .catch(error => {
//      console.error('Error fetching data:', error);
//    });
//}
//
//// Function to update the DOM with the received data
//function updateDOM(message) {
//  const dataContainer = document.getElementById('data-container');
//  dataContainer.innerHTML = '';
//  data.forEach(item => {
//    const div = document.createElement('div');
//    div.textContent = item;
//    dataContainer.appendChild(div);
//  });
//}

//var sendDataToServer = async (message) => {
//  //const data = {message: message};
//  try {
//
//    const response = await fetch('http://localhost:8080/channels2', {
//      method: 'POST',
//      headers: { 'Content-Type': 'application/json' },
//      body: JSON.stringify(message)
//    })
//     .then(response => {
//         if (!response.ok) {
//            throw new Error('Network response was not ok');
//     }
//     return response.json();
//  })
//  .then(data => {
//    console.log("Success", message);
//  })
////    // The response is now HTML, so we'll load it into the document
////
////    const htmlContent = await response.text();
////    document.open();
////    document.write(htmlContent);
////    document.close();
////  }
//    catch (error => {
//    console.error('Error:', error);
//  })
//}
//};

async function postData(data) {
  try {
    const response = await fetch('http://localhost:8080/channels2', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)

    });

    if (!response.ok) {
      throw new Error('Network response was not ok');
    }

    const result = await response.json();

    var conversation = JSON.stringify(result);
    console.log("printing object: " + conversation);

//    for (var i = 0; i < result.length; i++) {
//        console.log(result.messageUser[i]);
//    }

    //const jsonObject = JSON.parse(result);


    textElement.value = conversation;


  } catch (error) {
    console.error('Error:', error);
  }
}

function getText() {

  textElement = document.getElementById("messages"); // output
  inputElement = document.getElementById("myInput"); // input text

  const inputText = inputElement.value;
  console.log("2 input text before assignation: " + inputText);

  textElement.value = listOfMessages; //yourName + ": " + inputText;

  console.log("textElement entered: " + inputText);
  console.log("your name in channels.js: " + yourName);

  message = {
      "messageUser": yourName, //"Test-User-Name", //userName, //userName,
      "messageText": inputText //textElement
  }

  //sendDataToServer(message);
  //fetchDataFromServer(message)
  postData(message);
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