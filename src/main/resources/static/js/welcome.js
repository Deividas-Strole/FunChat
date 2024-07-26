const name = prompt("Hello! :) What is your name?");
console.log("Name entered: " + name);

const link = document.getElementById('myLink');

link.addEventListener("click", (event) => {
    event.preventDefault(); // Prevent default link behavior

    fetch("http://localhost:8080/channels", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ "name": name })
    })
    .then(res => {
        console.log('Response status:', res.status);
        console.log('Response headers:', [...res.headers]);

        if (!res.ok) {
            throw new Error("Network response was not ok");
        }

        const contentType = res.headers.get('content-type');
        if (contentType && contentType.includes('application/json')) {
            return res.json();
        } else {
            return res.text().then(text => {
                throw new Error("Expected JSON, but received " + contentType + ": " + text);
            });
        }
    })
    .then(data => {
        // Handle successful response
        console.log(data);
    })
    .catch(error => {
        // Handle any errors during the fetch
        console.error("Fetch error:", error);
    });
});


// ************ chat corrected code
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
//        .then(res => {
//            if (!res.ok) {
//                throw new Error("Network response was not ok");
//            }
//            return res.json();
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





// ************************ my code **************************
//const name = prompt("Hello! :) What is you name?")
//console.log("Name entered: " + name)
//
//const link = document.getElementById('myLink')
//
//link.addEventListener("click", (event) => {
//
//    event.preventDefault(); // Prevent default link behavior
//
//    fetch("http://localhost:8080/channels", {
//        method: "POST",
//        headers: {
//                    "Content-Type": "application/json"
//        },
//        body: JSON.stringify({"name": name})
//     })
//        .then(res => {
//            if (!res.ok) {
//            throw new Error("Network response was not ok")
//            }
//            return res.json()
//        })
//        .then(data => {
//            // Handle successful response
//            console.log(data)
//        })
//        .catch(error => { //console.log("ErroR")) //window.location.href = "http://localhost:8080/channels") // error => console.log("ErroR"))
//            // Handle any errors during the fetch
//            console.error("Fetch error:", error)
//        })
//})