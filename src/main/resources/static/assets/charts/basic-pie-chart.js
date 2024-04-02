let pieDom = document.getElementById('pieChart');
let pieChart = echarts.init(pieDom);
var option;

// option = {
//     title: {
//         text: '器材类型数量统计',
//         left: 'center'
//     },
//     tooltip: {
//         trigger: 'item'
//     },
//     legend: {
//         orient: 'vertical',
//         left: 'left'
//     },
//     toolbox: {
//         feature: {
//             saveAsImage: {}
//         }
//     },
//     series: [
//         {
//             name: 'Access From',
//             type: 'pie',
//             // center: ['50%', '60%'],
//             radius: '60%',
//             // data: [
//             //     { value: 10, name: '哑铃' },
//             //     { value: 5, name: '杠铃' },
//             //     { value: 15, name: '跑步机' }
//             // ],
//             data: [],
//             emphasis: {
//                 itemStyle: {
//                     shadowBlur: 10,
//                     shadowOffsetX: 0,
//                     shadowColor: 'rgba(0, 0, 0, 0.5)'
//                 }
//             }
//         }
//     ]
// };
// pieChart.setOption(option);

// 使用Fetch API从后端获取数据
fetch('/payment/pieChartData')
    .then(response => response.json())
    .then(responseData => {
        // 更新饼图的系列数据
        option = {
            title: {
                text: '器材类型数量统计',
                left: 'center'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                orient: 'vertical',
                left: 'left'
            },
            toolbox: {
                feature: {
                    saveAsImage: {}
                }
            },
            series: [
                {
                    name: 'Access From',
                    type: 'pie',
                    radius: '60%',
                    data: responseData,
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };

        pieChart.setOption(option);
    })
    .catch(error => {
        console.error('Error fetching data:', error);
    });