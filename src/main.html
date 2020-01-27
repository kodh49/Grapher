<?php
// Database Connection Settings
    $host = 'localhost';
    $user = 'root';
    $pass = '';
    $db = 'grapher';
    $mysqli = new mysqli($host, $user, $pass, $db) or die($mysqli->error);

    $data1 = '';
    $data2 = '';

    // Query to get data from the table
    $sql = "SELECT * FROM 'chart'";
    $result = mysqli_query($mysqli, $sql);

    // Loop through the returned data
    while ($row = mysqli_fetch_array($result)) {
        $data1 = $data1 . '"' . $row['xval'].'",';
        $data2 = $data2 . '"' . $row['yval'].'",';
    }

    $data1 = trim($data1, ",");
    $data2 = trim($data2, ",");
?>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Grapher</title>
</head>
<body>
    <canvas id="myChart"></canvas>
    <script>
    // Global Variable
var chartname = "This is a chart";
const colors = ['red', 'yellow', 'blue'];


// Chart Data
var data = {
    labels:[<?php echo $data1; ?>],
    datasets:[
    {
    label: 'Chart 1',
    backgroundColor: 'transparent',
    borderColor: colors[0],
    borderWidth: 3,
    data: [<?php echo $data2; ?>],
    }
    ]
};


// Chart Style
var options = {
    title: {
        display:true,
        text: chartname,
       fontSize : 25
    },
    legend: {
        display:true,
        position:'right',
        labels:{
        fontColor:"#000"
        }
    },
    layout: {
        padding: {
        left : 50,
        right : 50,
        bottom: 0,
        top: 0
        }
    },
    tooltips: {
        enabled:true
    }
};


// Chart Construction
var myChart = document.getElementById('myChart').getContext('2d');
var myLineChart = new Chart(myChart, {
    type: 'line', //bar, horizontalBar, pie, line, doughnut, radar, polarArea
    data: data,
    options: options
});
    </script>
</body>
</html>