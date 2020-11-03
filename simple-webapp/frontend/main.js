
document.addEventListener("DOMContentLoaded", () => {
    const input = document.getElementById("username");
    const greeting = document.getElementById("greeting");
    input.addEventListener("keyup", () => greet(input, greeting));
});
