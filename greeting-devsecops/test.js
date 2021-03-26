const assert = require("assert").strict;
const greet = require("./greet");

assert.strictEqual(greet(), "Hello student");
assert.strictEqual(greet("Guy"), "Hello Guy");
