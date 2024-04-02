let barDom = document.getElementById('barChart');
let barChart = echarts.init(barDom);
var option;

option = {
    title: {
        text: '会员缴费金额',
        left: 'center'
    },
    xAxis: {
        type: 'category',
        data: []
        // data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            data: [],
            // data: [120, 200, 150, 80, 70, 110],
            type: 'bar'
        }
    ]
};
barChart.setOption(option);

fetch('/barChartData')
    .then(response => response.json())
    .then(responseData => {
        const xAxisData = responseData.map(data => data.date);
        const incomeData = responseData.map(data => data.income);

        // 更新图表的x轴数据和系列数据
        barChart.setOption({
            xAxis: {
                data: xAxisData
            },
            series: [
                {
                    data: incomeData
                }
            ]
        });

        // stackedLineChart.resize();
    })
    .catch(error => {
        console.error('Error fetching data:', error);
    });
