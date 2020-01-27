var mysql_dbc = require('../js/db_con')();
var connection = mysql_dbc.init();
mysql_dbc.test_open(connection);