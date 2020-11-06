const assert = require("assert").strict;
const greet = require("./greet");

greet.api = async function apiMock(name) {
    return `Hello ${name}`;
}

const input = { value: "Pablo" }
const h1 = { innerHTML: "" }

greet(input, h1).then(() => {
    assert.strictEqual(h1.innerHTML, "Hello Pablo");
});
