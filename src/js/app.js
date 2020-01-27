var express = require('express');
var app = express();

var options = require('../js/src/option');

var loginData = {
    host: options.storageConfig.HOST,
    user: options.storageConfig.user,
    password: options.storageConfig.password
};

var mysql = require('mysql');
var connection = mysql.createConnection({
    host: loginData.host,
    port: 3306,
    user: loginData.user,
    password: loginData.password,
    database: 'grapher'
})
connection.connect();

app.use(express.static('public'));

app.listen(5500, function() {
    console.log("Port "+5500+"에서 서버 동작");
})

app.get('/', function(req, res) {
    res.sendFile(__dirname+'/public/graphing.html');
});

app.post('/', function(req, res) {
    var responseData = {};

    var query = connection.query('select * from chart', function(err, rows) {
        responseData.value = [];
        if (err) throw err;
        if (rows[0]) {
            responseData.result = "OK";
            rows.forEach(function(val) {
                responseData.value.push(val.value);
            })
        }
        else {
            responseData.result = "None";
            responseData.value = "";
        }
        res.json(responseData);
    });
});