const name = prompt("Hello! :) What is your name?");
//const link = document.getElementById('myLink');
const channel = document.getElementById('channel1');


function submitUser() {
    const data = { name: name };

    fetch('http://localhost:8080/channels', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
    .then(response => {
        if (response.redirected) {
            window.location.href = response.url;
        } else {
            console.error('Unexpected response:', response);
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

channel.addEventListener('click', function()  
 {
  //const valueToPass = 'some_value'; // Replace with your desired value

 console.log("Received value:" + this.value);
});

//link.addEventListener("click", () => {
//    event.preventDefault(); // Prevent default link behavior
//    submitUser();
//});
