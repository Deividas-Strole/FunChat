const name = prompt("Hello! :) What is your name?");
const link = document.getElementById('myLink');

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

link.addEventListener("click", () => {
    event.preventDefault(); // Prevent default link behavior
    submitUser();
});
