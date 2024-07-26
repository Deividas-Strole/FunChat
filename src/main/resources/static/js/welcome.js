const name = prompt("Hello! :) What is your name?");
console.log("Name entered: " + name);

const link = document.getElementById('myLink');

const sendData = async () => {

  const data = {name: name};

  try {

    const response = await fetch('http://localhost:8080/channels', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data)
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

link.addEventListener("click", () => {
    event.preventDefault(); // Prevent default link behavior
    sendData();
});



//// ************ chat corrected code
//const name = prompt("Hello! :) What is your name?");
//console.log("Name entered: " + name);
//
//const link = document.getElementById('myLink');
//
//link.addEventListener("click", (event) => {
//    event.preventDefault(); // Prevent default link behavior
//
//    fetch("http://localhost:8080/channels", {
//        method: "POST",
//        headers: {
//            "Content-Type": "application/json"
//        },
//        body: JSON.stringify({ "name": name })
//    })
//        .then(response => {
//            if (!response.ok) {
//                throw new Error("Network response was not ok");
//            }
//
//            return res.json();
//
////
//
//
//        })
//        .then(data => {
//            // Handle successful response
//            console.log(data);
//        })
//        .catch(error => {
//            // Handle any errors during the fetch
//            console.error("Fetch error:", error);
//        });
//});
//
//
//
//
//
