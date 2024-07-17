let name = prompt("Hello! :) What is you name?")
console.log("name: " + name)

fetch("http://localhost:8080/channels", {
    method: "POST",
    headers: {
                "Content-Type": "application/json"
    },

//    body: JSON.stringify({
//        name: name
//    })

    body: JSON.stringify(name)

 }).then(res => {
        return res.json()
    })
    .then(data => console.log(data))
    .catch(error => console.log("ErroR"))