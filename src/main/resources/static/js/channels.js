const inputElement = document.getElementById("myInput");
const containerElement = document.getElementById("data-container");
const postUrl = `http://localhost:8080/postDataToServer/${channel}`;
const fetchMessagesUrl = `http://localhost:8080/returnAllMessages/${channel}`;
const FETCH_INTERVAL = 2000; // Adjust to avoid excessive polling

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

async function getAllMessages() {
  try {
    const response = await fetch(fetchMessagesUrl);
    if (!response.ok) {
      throw new Error(`Failed to fetch messages: ${response.statusText}`);
    }
    const data = await response.json();
    populateChatBox(data);
  } catch (error) {
    console.error("Error fetching messages:", error);
  }
}

function populateChatBox(messages) {
  containerElement.innerHTML = "";
  messages.forEach(({ messageUser, messageText }) => {
    const messageDiv = document.createElement("div");
    messageDiv.className = "data-item";
    messageDiv.innerHTML = `<strong>${messageUser}:</strong> ${messageText}`;
    containerElement.appendChild(messageDiv);
  });
}

inputElement.addEventListener("keydown", (event) => {
  if (event.key === "Enter") {
    const enteredText = inputElement.value.trim();
    if (!enteredText) return;

    const message = { messageUser: yourName, messageText: enteredText };
    postData(message);
    inputElement.value = "";
  }
});

setInterval(getAllMessages, FETCH_INTERVAL);
