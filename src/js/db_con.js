var mysql = require('mysql');
var config = require('../js/db_info').local;

module.exports = function() {
    return {
        init: function() {
            return mysql.createConnection({
                host: config.host,
                port: config.port,
                user: config.user,
                password: config.password,
                database: config.database
            })
        },

        test_open: function(con) {
            con.connect(function (err) {
                if (err) {
                    console.error('데이터베이스 연결 실패 : '+ err);
                } else {
                    console.info('데이터베이스 연결 : 성공');
                }
            })
        }
    }
};