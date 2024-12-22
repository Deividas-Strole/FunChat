const inputElement = document.getElementById("myInput");
const containerElement = document.getElementById("data-container");
const postUrl = `http://localhost:8080/postDataToServer`;
const fetchMessagesUrl = `http://localhost:8080/returnAllMessages`;
const FETCH_INTERVAL = 1000;

async function postData(data) {
  try {
    const response = await fetch(postUrl, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data),
    });

    if (!response.ok) {
      throw new Error(`Failed to post data: ${response.statusText}`);
    }
  } catch (error) {
    console.error("Error posting data:", error);
  }
}

async function getAllMessages(channel) {

    // console.log("channel: " + channel); channel is here
  try {
    const response = await fetch(fetchMessagesUrl, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ channel }),
    });
    if (!response.ok) {
      throw new Error(`Failed to fetch messages: ${response.statusText}`);
    }
    const data = await response.json();
    populateChatBox(data);
  } catch (error) {
    console.error("Error fetching messages:", error);
  }
}

//async function getAllMessages() {
//  try {
//    const response = await fetch(fetchMessagesUrl);
//    if (!response.ok) {
//      throw new Error(`Failed to fetch messages: ${response.statusText}`);
//    }
//    const data = await response.json();
//    populateChatBox(data);
//  } catch (error) {
//    console.error("Error fetching messages:", error);
//  }
//}

function populateChatBox(messages) {
  containerElement.innerHTML = "";
  messages.forEach(({ messageUser, messageText }) => {
    const messageDiv = document.createElement("div");
    messageDiv.className = "data-item";
    messageDiv.innerHTML = `<p><strong>${messageUser}:</strong> ${messageText}</p>`;
    containerElement.appendChild(messageDiv);
  });
}

inputElement.addEventListener("keydown", (event) => {
  if (event.key === "Enter") {
    const enteredText = inputElement.value.trim();

    //console.log("name + text + chennel in input: " + yourName + enteredText + channel);

    if (!enteredText) return;

    const message = { name: yourName, messageText: enteredText, channel: channel };
    postData(message);
    inputElement.value = "";
  }
});

setInterval(() => getAllMessages(channel), FETCH_INTERVAL);

//setInterval(getAllMessages(channel), FETCH_INTERVAL);