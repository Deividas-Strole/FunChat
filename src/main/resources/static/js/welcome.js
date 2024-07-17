let name = prompt("Hello! :) What is you name?")
console.log("name: " + name)

const link = document.getElementById('myLink');
const form = document.getElementById('myForm');
const data1Input = document.getElementById('data1');

link.addEventListener("click", (event) => {

    event.preventDefault(); // Prevent default link behavior

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

        data1Input.value = name

        form.submit()
}