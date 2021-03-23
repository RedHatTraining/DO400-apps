const greet = require("./greet");

if (process.argv.length < 3) {
    console.error("Please specify the name paremeter");
    process.exit(1);
}

const name = process.argv[2];
console.log(greet(name));
