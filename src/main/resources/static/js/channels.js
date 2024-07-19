function getText() {
  const inputElement = document.getElementById("myInput"); // input
  const textElement = document.getElementById("messages"); // output
  const inputText = inputElement.value;
  textElement.value = inputText;
  console.log(inputText); // Prints the entered text to the console
}

