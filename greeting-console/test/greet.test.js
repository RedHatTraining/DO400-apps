const assert = require("assert");
const greet = require("../greet");


describe("greet", () =>{

    it("greets in english", () => {
        assert.strictEqual("Hello Guy!", greet("Guy"));
    });

});
