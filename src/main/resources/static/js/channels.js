var inputElement;
var textElement;
var massage;

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
    populateChatBox (result);

  } catch (error) {
    console.error('Error:', error);
  }
}

function getAllMessages() {
             fetch('http://localhost:8080/channels')
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok ' + response.statusText);
                    }
                    return response.json();
                })
                .then(data => {
                    populateChatBox (data);
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

const input = document.getElementById('myInput');

input.addEventListener('keydown', (event) => {
  if (event.key === 'Enter') {
        const enteredText = input.value;

    message = {
          "messageUser": yourName,
          "messageText": enteredText
      }

    postData(message);

    input.value = '';
  }
});

setInterval(getAllMessages, 1000);