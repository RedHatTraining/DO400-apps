function greet(domInput, domElement) {
    const api = greet.api || getGreeting;
    return api(domInput.value).then(text => {
        domElement.innerHTML = text;
    });
}

function getGreeting(name) {
    const url = "http://localhost:3000?name=" + name
    return fetch(url)
        .then(response => response.text());
}

if (typeof module !== "undefined") {
    module.exports = greet;
}
