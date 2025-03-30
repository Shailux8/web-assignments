// 1. Declare and use variables
var name = "John";
let age = 25;
const country = "USA";
console.log(`Name: ${name}, Age: ${age}, Country: ${country}`);

// 2. JavaScript Functions
// BMI Calculator
function calculateBMI(weight, height) {
    return weight / (height * height);
}
console.log("BMI: ", calculateBMI(70, 1.75));

// Temperature Converter (Celsius to Fahrenheit)
function celsiusToFahrenheit(celsius) {
    return (celsius * 9/5) + 32;
}
console.log("Temperature in Fahrenheit: ", celsiusToFahrenheit(25));

// 3. Implementing Conditions
function checkAge(userAge) {
    if (userAge >= 18) {
        console.log("You are an adult.");
    } else {
        console.log("You are a minor.");
    }
}
checkAge(20);

function getDayMessage(day) {
    switch(day) {
        case "Monday":
            console.log("Start of the work week.");
            break;
        case "Friday":
            console.log("Weekend is near!");
            break;
        default:
            console.log("Have a great day!");
    }
}
getDayMessage("Friday");

// 4. Using Loops
// Generate a list of users dynamically
let users = ["Alice", "Bob", "Charlie"];
console.log("User List:");
for (let i = 0; i < users.length; i++) {
    console.log(`${i + 1}. ${users[i]}`);
}

// While loop example
let counter = 5;
while (counter > 0) {
    console.log("Countdown: ", counter);
    counter--;
}

// Do-while loop example
let number = 1;
do {
    console.log("Number: ", number);
    number++;
} while (number <= 5);
