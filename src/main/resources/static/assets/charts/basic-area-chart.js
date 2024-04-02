let areaDom = document.getElementById('areaChart');
let areaChart = echarts.init(areaDom);
var option;

option = {
    title: {
        text: '净收入趋势',
        left: 'center'
    },
    tooltip: {
        trigger: 'axis'
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: []
        // data: ["January", "February", "March", "April", "May", "June"]
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            data: [],
            // data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line',
            areaStyle: {}
        }
    ]
};
areaChart.setOption(option);

fetch('/areaChartData')
    .then(response => response.json())
    .then(responseData => {
        const xAxisData = responseData.map(data => data.date);
        const netIncomeData = responseData.map(data => data.netIncome);

        // 更新图表的x轴数据和系列数据
        areaChart.setOption({
            xAxis: {
                data: xAxisData
            },
            series: [
                {
                    data: netIncomeData
                }
            ]
        });
    })
    .catch(error => {
        console.error('Error fetching data:', error);
    });