const name = prompt("Hello! :) What is your name?");

const link = document.getElementById('myLink');

//const sendData = async () => {
//
//  const data = {name: name};
//
//  try {
//
//    const response = await fetch('http://localhost:8080/channels', {
//      method: 'POST',
//      headers: { 'Content-Type': 'application/json' },
//      body: JSON.stringify(data)
//    });
//
//    if (!response.ok) {
//      throw new Error('Network response was not ok');
//    }
//
//    // The response is now HTML, so we'll load it into the document
//    const htmlContent = await response.text();
//    document.open();
//    document.write(htmlContent);
//    document.close();
//  }
//
//    catch (error) {
//    console.error('Error:', error);
//  }
//
//};

function submitUser() {

    const data = {name: name};
    
    fetch('http://localhost:8080/channels', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name: document.getElementById('nameInput').value }),
    })
    .then(response => response.json())
    .then(data => {
        // Assuming the server returns some data to confirm success
        window.location.href = '/channels';
    });
}

link.addEventListener("click", () => {
    event.preventDefault(); // Prevent default link behavior
//    sendData();
    submitUser();
});
