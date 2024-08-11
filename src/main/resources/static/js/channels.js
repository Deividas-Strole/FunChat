var inputElement;
var textElement;
var massage;

//console.log("----=== we are in main body!");

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
    console.log("************ object: " + typeof result);

    populateChatBox (result);

  } catch (error) {
    console.error('Error:', error);
  }
}

function getAllMessages() {

            console.log("-------------> we are in getAllMessages!");
            fetch('http://localhost:8080/channels')
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok ' + response.statusText);
                    }
                    return response.json(); // Expecting a simple string response
                })
                .then(data => {
                    populateChatBox (data);
                    //console.log("We are in getAllMessages, cia data: " + data);
                })
                .catch(error => {
                    console.error('Error fetching data:', error);
                });

        }


function populateChatBox (result) {
    const container = document.getElementById('data-container');
    container.innerHTML = ''; // Clear any existing content
                // Create HTML elements to display the data
    result.forEach(item => {
        const itemDiv = document.createElement('div');
        itemDiv.className = 'data-item';
        itemDiv.innerHTML = `<strong>${item.messageUser}:</strong>  ${item.messageText}<br>`;
        container.appendChild(itemDiv);
    });
}


function displayData(data) {
    const container = document.getElementById('data-container');
    container.innerHTML = ''; // Clear any existing content
    // Create HTML elements to display the data
    data.forEach(item => {
        const itemDiv = document.createElement('div');
        itemDiv.className = 'data-item';
        itemDiv.innerHTML = `
            <p><strong>Name:</strong> ${item.name}</p>
            <p><strong>Value:</strong> ${item.value}</p>
        `;
        container.appendChild(itemDiv);
    });
}

function test() {
    console.log("qwert");
}


function getText() {
  //textElement = document.getElementById("messages"); // output
  inputElement = document.getElementById("myInput"); // input text

  const inputText = inputElement.value;
  console.log("2 input text before assignation: " + inputText);

 // textElement.value = listOfMessages; //yourName + ": " + inputText;

  console.log("textElement entered: " + inputText);
  console.log("your name in channels.js: " + yourName);

  message = {
      "messageUser": yourName, //"Test-User-Name", //userName, //userName,
      "messageText": inputText //textElement
  }

  //sendDataToServer(message);
  //fetchDataFromServer(message)
  //setInterval(getAllMessages, 1000);
  postData(message);

}

//getAllMessages();

setInterval(getAllMessages, 1000);
//setInterval(getAllMessages, 1000);
