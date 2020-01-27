// Global Variable
var chartname = "Chart Name";
const colors = ['red', 'yellow', 'blue'];


// Chart Data
var data = {
    labels:['10', '20', '30', '40', '50'],
    datasets:[
    {
    label: 'Chart 1',
    backgroundColor: 'transparent',
    borderColor: 'red',
    data: [10, 10, 2, 4, 8],
    },

    {
    label: 'Chart 2',
    backgroundColor: 'transparent',
    borderColor: 'blue',
    data:[9, 7, 4, 6, 4],
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

// Data Reload Button
var button = document.getElementById("sendAjax")

button.addEventListener("click", function() {
    sendAjax('http://localhost:5500/');
})

function sendAjax(url) {
    var oReq = new XMLHttpRequest();

    oReq.open('POST', url);
    oReq.setRequestHeader('Content-Type', "application/json")
    oReq.send();

    oReq.addEventListener('load', function() {
        var result = JSON.parse(oReq.responseText);
        var score = result.score;
        var comp_data = data.datasets[0].data;

        for (var i = 0; i < comp_data.length; i++) {
            comp_data[i] = score[i];
        }

        data.datasets[0].data = comp_data;
        myLineChart.update();
    })
}
