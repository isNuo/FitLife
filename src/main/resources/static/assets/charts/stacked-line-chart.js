let stackedLineDom = document.getElementById('stackedLineChart');
let stackedLineChart = echarts.init(stackedLineDom);
var option;

option = {
    title: {
        text: '收入与支出对比',
        left: 'center'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        // data: ['会员缴费收入', '器材购买支出'],
        orient: 'vertical',
        left: 'left'
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
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
        // data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat','Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name: '会员缴费收入',
            type: 'line',
            // stack: 'Total',
            data: []
            // data: [420, 532, 301, 434, 690, 430, 420, 532, 301, 434, 690, 430]
        },
        {
            name: '器材购买支出',
            type: 'line',
            // stack: 'Total',
            data: []
            // data: [220, 182, 191, 234, 290, 330, 220, 182, 191, 234, 290, 330]
        }
    ]
};
stackedLineChart.setOption(option);

// 使用Fetch API从后端获取数据
// fetch('/payment/lineChartData')
//     .then(response => response.json())
//     .then(responseData => {
//         // 更新图表的x轴数据和系列数据
//         stackedLineChart.setOption({
//             xAxis: {
//                 data: responseData.date
//             },
//             series: [
//                 {
//                     name: '会员缴费收入',
//                     data: responseData.income
//                 },
//                 {
//                     name: '器材购买支出',
//                     data: responseData.expense
//                 }
//             ]
//         });
//
//         // stackedLineChart.resize();
//     })
//     .catch(error => {
//         console.error('Error fetching data:', error);
//     });

fetch('/payment/lineChartData')
    .then(response => response.json())
    .then(responseData => {
        const xAxisData = responseData.map(data => data.date);
        const incomeData = responseData.map(data => data.income);
        const expenseData = responseData.map(data => data.expense);

        // 更新图表的x轴数据和系列数据
        stackedLineChart.setOption({
            xAxis: {
                data: xAxisData
            },
            series: [
                {
                    name: '会员缴费收入',
                    data: incomeData
                },
                {
                    name: '器材购买支出',
                    data: expenseData
                }
            ]
        });

        // stackedLineChart.resize();
    })
    .catch(error => {
        console.error('Error fetching data:', error);
    });
