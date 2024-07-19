let name = prompt("Hello! :) What is you name?")
console.log("Name entered: " + name)
var user = {
    "name": name
}

const link = document.getElementById('myLink');
//const form = document.getElementById('myForm');

link.addEventListener("click", (event) => {

    event.preventDefault(); // Prevent default link behavior

    fetch("http://localhost:8080/channels", {

        method: "POST",
        headers: {
                    "Content-Type": "application/json"
        },


//        body: JSON.stringify({
//                   name: name
//                })

        body: JSON.stringify(user)

     }).then(res => {
            return res.json()
        })
        .then(data => console.log(data))
        .catch(error => window.location.href = "http://localhost:8080/channels") //console.log("ErroR"))

        //form.submit()
})