const http = require("http");
const url = require("url");
const greet = require("./greet");

const server = http.createServer((req, res) => {
    const { name } = url.parse(req.url, true).query;
    res.statusCode = 200;
    res.setHeader("Content-Type", "text/plain");
    res.setHeader("Access-Control-Allow-Origin", "*");
    res.end(greet(name));
});

const port = 3000;
server.listen(port, () => {
    console.log(`Server listening on ${port}`);
});
