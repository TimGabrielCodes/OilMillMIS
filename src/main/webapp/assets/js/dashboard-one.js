$(function () {

    'use strict'

    var ctxLabel = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    var ctxData1 = [20, 60, 50, 45, 50, 60, 70, 40, 45, 35, 25, 30];
    var ctxData2 = [10, 40, 30, 40, 60, 55, 45, 35, 30, 20, 15, 20];
    var ctxColor1 = '#59a7fe';
    var ctxColor2 = '#6beaa6';

    // Bar chart
    var ctx1 = document.getElementById('chartBar1').getContext('2d');
    new Chart(ctx1, {
        type: 'bar',
        data: {
            labels: ctxLabel,
            datasets: [{
                data: ctxData1,
                backgroundColor: ctxColor1
            }, {
                data: ctxData2,
                backgroundColor: ctxColor2
            }]
        },
        options: {
            tooltips: {enabled: false},
            hover: {mode: null},
            maintainAspectRatio: false,
            responsive: true,
            legend: {
                display: false,
                labels: {
                    display: false
                }
            },
            scales: {
                yAxes: [{
                    gridLines: {
                        color: '#f4f4f8'
                    },
                    ticks: {
                        beginAtZero: true,
                        fontSize: 9,
                        fontColor: '#87889a',
                        max: 80
                    }
                }],
                xAxes: [{
                    gridLines: {
                        display: false
                    },
                    barPercentage: 0.6,
                    ticks: {
                        beginAtZero: true,
                        fontSize: 10,
                        fontColor: '#87889a'
                    }
                }]
            }
        }
    });

    var ctx2 = document.getElementById('chartBar2').getContext('2d');
    new Chart(ctx2, {
        type: 'horizontalBar',
        data: {
            labels: ['Facebook', 'Google', 'Twitter', 'Instagram', 'Email', 'Other'],
            datasets: [{
                data: [90, 60, 50, 65, 50, 60],
                backgroundColor: ['#22d273', '#64ccfa', '#fc7090', '#5b8ef9', '#fca665', '#a490f9']
            }, {
                data: [60, 50, 70, 45, 70, 30],
                backgroundColor: '#e5e9f2'
            }]
        },
        options: {
            tooltips: {enabled: false},
            hover: {mode: null},
            maintainAspectRatio: false,
            responsive: true,
            legend: {
                display: false,
                labels: {
                    display: false
                }
            },
            layout: {
                padding: {
                    left: 5
                }
            },
            scales: {
                yAxes: [{
                    gridLines: {
                        display: false
                    },
                    barPercentage: 0.5,
                    ticks: {
                        beginAtZero: true,
                        fontSize: 13,
                        fontColor: '#182b49',
                        fontFamily: 'Roboto'
                    }
                }],
                xAxes: [{
                    gridLines: {
                        color: '#e5e9f2'
                    },
                    ticks: {
                        beginAtZero: true,
                        fontSize: 10,
                        fontColor: '#182b49',
                        max: 100
                    }
                }]
            }
        }
    });


    var fcData1 = [[0, 5], [1, 3], [2, 1], [3, 4], [4, 6], [5, 5], [6, 8], [7, 10], [8, 9], [9, 11], [10, 15], [11, 17], [12, 14], [13, 13], [14, 15], [15, 13], [16, 12], [17, 10], [18, 11], [19, 8], [20, 5], [21, 3], [22, 5], [23, 6], [24, 5], [25, 6], [26, 8], [27, 10], [28, 9], [29, 8], [30, 5]];

    var fcData2 = [[0, .3], [1, .3], [2, .3], [3, .3], [4, .3], [5, .3], [6, .3], [7, .3], [8, .3], [9, .3], [10, .3], [11, .3], [12, .3], [13, .3], [14, .3], [15, .3], [16, .3], [17, .3], [18, .3], [19, .3], [20, .3], [21, .3], [22, .3], [23, .3], [24, .3], [25, .3], [26, .3], [27, .3], [28, .3], [29, .3], [30, .3]];


    $.plot('#flotChart', [{
        data: fcData1,
        color: '#7c7dfe'
    }, {
        data: fcData2,
        color: '#fff'
    }, {
        data: fcData1,
        color: '#4bdedb'
    }], {
        series: {
            stack: 0,
            bars: {
                show: true,
                align: 'center',
                lineWidth: 0,
                barWidth: .4,
                fill: 1
            }
        },
        grid: {
            borderWidth: 0,
            borderColor: '#ededf4',
            labelMargin: 10
        },
        yaxis: {
            show: true,
            color: 'rgba(6,7,45, .05)',
            max: 50,
            ticks: [[0, '$100K'], [10, '$200K'], [20, '$200K'], [30, '$300K'], [40, '$400K'], [50, '$500K']]
        },
        xaxis: {
            show: true,
            color: '#fff'
        }
    });

    $.plot('#flotChart1', [{
        data: [[0, 1], [1, 1], [2, 3], [3, 1], [4, 5], [5, 25], [6, 60], [7, 30], [8, 5]],
        color: '#fc68ab'
    }, {
        data: [[0, 30], [1, 10], [2, 20], [3, 10], [4, 50], [5, 30], [6, 15], [7, 15], [8, 10]],
        color: '#fcebf3'
    }], {
        series: {
            stack: 0,
            bars: {
                show: true,
                lineWidth: 0,
                barWidth: .6,
                fill: 1
            }
        },
        grid: {
            borderWidth: 0,
            borderColor: '#edeff6'
        },
        yaxis: {
            show: false,
            max: 80
        },
        xaxis: {
            show: false,
            color: '#fff',
        }
    });

    $.plot('#flotChart2', [{
        data: [[0, 1], [1, 1], [2, 30], [3, 70], [4, 10], [5, 3], [6, 1], [7, 1], [8, 0]],
        color: '#9596fc'
    }, {
        data: [[0, 30], [1, 10], [2, 20], [3, 10], [4, 50], [5, 30], [6, 20], [7, 50], [8, 10]],
        color: '#ededfd'
    }], {
        series: {
            stack: 0,
            bars: {
                show: true,
                lineWidth: 0,
                barWidth: .6,
                fill: 1
            }
        },
        grid: {
            borderWidth: 0,
            borderColor: '#edeff6'
        },
        yaxis: {
            show: false,
            max: 80
        },
        xaxis: {
            show: false,
            color: '#fff'
        }
    });

    $.plot('#flotChart3', [{
        data: [[0, 1], [1, 1], [2, 20], [3, 40], [4, 70], [5, 10], [6, 1], [7, 5], [8, 1]],
        color: '#59a7fe'
    }, {
        data: [[0, 40], [1, 10], [2, 40], [3, 10], [4, 20], [5, 40], [6, 20], [7, 50], [8, 10]],
        color: '#e9f3ff'
    }], {
        series: {
            stack: 0,
            bars: {
                show: true,
                lineWidth: 0,
                barWidth: .6,
                fill: 1
            }
        },
        grid: {
            borderWidth: 0,
            borderColor: '#edeff6'
        },
        yaxis: {
            show: false,
            max: 80
        },
        xaxis: {
            show: false,
            ticks: [[0, 'Jan'], [4, 'Feb'], [8, 'Mar'], [12, 'Apr'], [16, 'May'], [19, 'Jun']],
            color: '#fff',
        }
    });

    $.plot('#flotChart4', [{
        data: df1,
        color: '#5556fd',
        curvedLines: {apply: true}
    }], {
        series: {
            shadowSize: 0,
            lines: {
                show: true,
                lineWidth: 1.7,
                fill: .05
            }
        },
        grid: {
            borderWidth: 0,
            labelMargin: 0
        },
        yaxis: {
            show: false,
            max: 80
        },
        xaxis: {
            show: true,
            color: 'rgba(30, 26, 112, .08)',
            min: 5,
            max: 65,
            tickSize: 6
        }
    });

    $.plot('#flotChart5', [{
        data: [[0, 0], [1, 0], [2, 0], [3, 65], [4, 0], [5, 80], [6, 0], [7, 0], [8, 0]],
        color: '#5556fd'
    }, {
        data: [[0, 10], [1, 20], [2, 55], [3, 0], [4, 50], [5, 0], [6, 25], [7, 40], [8, 55]],
        color: '#e6e7fd'
    }], {
        series: {
            stack: 0,
            bars: {
                show: true,
                align: 'center',
                lineWidth: 0,
                barWidth: .3,
                fill: 1
            }
        },
        grid: {
            borderWidth: 0,
            borderColor: '#ededf4'
        },
        yaxis: {
            show: true,
            color: '#f4f4f8',
            max: 80
        },
        xaxis: {
            show: true,
            color: '#fff',
            ticks: [[0, 'Sat'], [1, 'Sun'], [2, 'Mon'], [3, 'Tue'], [4, 'Wed'], [5, 'Thu'], [6, 'Fri'], [7, 'Sat'], [8, 'Sun']],
        }
    });

    $.plot('#flotChart6', [{
        data: [[0, 0], [1, 0], [2, 0], [3, 0], [4, 0], [5, 0], [6, 80], [7, 65], [8, 0]],
        color: '#4bdedb'
    }, {
        data: [[0, 10], [1, 20], [2, 55], [3, 25], [4, 50], [5, 40], [6, 0], [7, 0], [8, 55]],
        color: '#fff',
        bars: {fill: .15}
    }], {
        series: {
            stack: 0,
            bars: {
                show: true,
                align: 'center',
                lineWidth: 0,
                barWidth: .3,
                fill: 1
            }
        },
        grid: {
            borderWidth: 0,
            borderColor: '#ededf4'
        },
        yaxis: {
            show: true,
            color: 'rgba(255,255,255,0.1)',
            max: 80
        },
        xaxis: {
            show: true,
            color: 'rgba(255,255,255,0)',
            ticks: [[0, 'Sat'], [1, 'Sun'], [2, 'Mon'], [3, 'Tue'], [4, 'Wed'], [5, 'Thu'], [6, 'Fri'], [7, 'Sat'], [8, 'Sun']],
        }
    });


    var randomData = getRandomData();
    console.log(randomData);
    $.plot('#flotChart7', [{
        data: df1,
        color: '#38c4fa'
    }, {
        data: df2,
        color: '#22d273'
    }], {
        series: {
            stack: 0,
            shadowSize: 0,
            lines: {
                show: true,
                lineWidth: 1.5,
                fill: true,
                fillColor: {colors: [{opacity: 0.1}, {opacity: 0.3}]}
            }
        },
        grid: {
            borderWidth: 0,
            labelMargin: 15
        },
        yaxis: {
            show: true,
            max: 150,
            color: '#eeeef5',
            ticks: [[0, ''], [30, '$30,000'], [60, '$60,000'], [90, '$90,000'], [120, '$120,000'], [150, '$150,000']]
        },
        xaxis: {
            show: true,
            max: 50,
            color: 'rgba(255, 255, 255, 0)',
            ticks: [[0, 'Jan'], [10, 'Feb'], [20, 'Mar'], [30, 'Apr'], [40, 'May'], [50, 'Jun']]
        }
    });

    $.plot('#flotChart8', [{
        data: [[0, 10], [1, 20], [2, 30], [3, 40], [4, 10], [5, 20], [6, 30], [7, 15], [8, 30], [9, 40], [10, 20], [11, 30]],
        color: '#6f42c1'
    }, {
        data: [[0, 10], [1, 20], [2, 30], [3, 40], [4, 50], [5, 10], [6, 30], [7, 50], [8, 40], [9, 10], [10, 60], [11, 20]],
        color: '#38c4fa'
    }], {
        series: {
            stack: 0,
            bars: {
                show: true,
                lineWidth: 0,
                barWidth: .4,
                fill: 1
            }
        },
        grid: {
            borderWidth: 0,
            borderColor: '#edeff6'
        },
        yaxis: {
            show: true,
            color: '#f4f4f8',
            ticks: [[0, '1000'], [25, '3000'], [50, '5000'], [75, '8000']],
            max: 80
        },
        xaxis: {
            show: true,
            ticks: [[0, 'Sun'], [4, 'Mon'], [8, 'Tue'], [12, 'Wed']],
            max: 12,
            color: '#fff'
        }
    });

    $.plot('#flotChart9', [{
        data: [[0, 10], [1, 20], [2, 30], [3, 40], [4, 10], [5, 20], [6, 30], [7, 15], [8, 30], [9, 40], [10, 20], [11, 30]],
        color: '#5556fd'
    }, {
        data: [[0, 10], [1, 20], [2, 30], [3, 40], [4, 50], [5, 10], [6, 30], [7, 50], [8, 40], [9, 10], [10, 60], [11, 20]],
        color: '#e83e8c'
    }], {
        series: {
            stack: 0,
            shadowSize: 0,
            lines: {
                show: true,
                lineWidth: 1,
                fill: 0.2
            }
        },
        grid: {
            borderWidth: 0,
            borderColor: '#edeff6'
        },
        yaxis: {
            show: true,
            color: '#f4f4f8',
            ticks: [[0, '1000'], [25, '3000'], [50, '5000'], [75, '8000']],
            max: 80
        },
        xaxis: {
            show: true,
            ticks: [[0, ''], [2.5, 'Sun'], [5, 'Mon'], [7.5, 'Tue'], [10, 'Wed']],
            color: '#fff'
        }
    });

    $.plot('#flotChart10', [{
        data: [[0, 20], [1, 10], [2, 30], [3, 50], [4, 25], [5, 35], [6, 30], [7, 35], [8, 15]],
        color: '#d9dfe7'
    }, {
        data: [[0, 20], [1, 10], [2, 30], [3, 50], [4, 25], [5, 35]],
        color: '#e83e8c'
    }], {
        series: {
            shadowSize: 0,
            lines: {
                show: true,
                lineWidth: 2,
                fill: true,
                fillColor: {colors: [{opacity: 0}, {opacity: .5}]}
            }
        },
        grid: {borderWidth: 0},
        yaxis: {show: false},
        xaxis: {show: false}
    });

    $.plot('#flotChart11', [{
        data: [[0, 10], [1, 5], [2, 25], [3, 15], [4, 25], [5, 20], [6, 25], [7, 15], [8, 35]],
        color: '#d9dfe7'
    }, {
        data: [[0, 10], [1, 5], [2, 25], [3, 15], [4, 25], [5, 20]],
        color: '#fd7e14'
    }], {
        series: {
            shadowSize: 0,
            lines: {
                show: true,
                lineWidth: 2,
                fill: true,
                fillColor: {colors: [{opacity: 0}, {opacity: .5}]}
            }
        },
        grid: {borderWidth: 0},
        yaxis: {show: false},
        xaxis: {show: false}
    });

    $.plot('#flotChart12', [{
        data: [[0, 50], [1, 75], [2, 65], [3, 15], [4, 25], [5, 20], [6, 25], [7, 15], [8, 35], [9, 50], [10, 75], [11, 65], [12, 45], [13, 65], [14, 30], [15, 45]],
        color: '#22d273'
    }, {
        data: [[0, -20], [1, -25], [2, -35], [3, -15], [4, -25], [5, -20], [6, -25], [7, -15], [8, -35], [9, -20], [10, -25], [11, -35], [12, -15], [13, -25], [14, -20], [15, -25]]
    }], {
        series: {
            threshold: {
                below: 0,
                color: '#e83e8c'
            },
            shadowSize: 0,
            bars: {
                show: true,
                lineWidth: 0,
                barWidth: .3,
                fill: 1
            }
        },
        grid: {
            borderWidth: 0,
            labelMargin: 15
        },
        yaxis: {
            show: true,
            min: -40,
            max: 80,
            color: '#f4f4f8',
            ticks: [[-25, '-$500K'], [0, '$0'], [25, '$500K'], [50, '$1M'], [75, '$10M']]
        },
        xaxis: {
            show: true,
            color: '#fff',
            ticks: [[0, 'Jan'], [2.5, 'Feb'], [5, 'Mar'], [7.5, 'Apr'], [10, 'May'], [12.5, 'Jun'], [15, 'Jul']]
        }
    });


    $('#vmap').vectorMap({
        map: 'world_en',
        backgroundColor: '#fff',
        borderColor: '#fff',
        color: '#e6e7fd',
        colors: {
            'us': '#8788fd',
            'in': '#62d9b6',
            'gb': '#ffd350',
            'br': '#ef77ae',
            'fr': '#9a7ad3',
            'nl': '#68c17c'
        },
        hoverColor: null,
        hoverOpacity: 0.8,
        enableZoom: false,
        showTooltip: false,
        multiSelectRegion: true
    });

    /** PIE CHART **/
    var datapie = {
        labels: ['Organic Search', 'Email', 'Referral', 'Social Media'],
        datasets: [{
            data: [20, 20, 30, 25],
            backgroundColor: ['#5556fd', '#38c4fa', '#22d273', '#e83e8c']
        }]
    };

    var optionpie = {
        maintainAspectRatio: false,
        responsive: true,
        legend: {
            display: false,
        },
        animation: {
            animateScale: true,
            animateRotate: true
        }
    };

    // For a pie chart
    var ctx3 = document.getElementById('chartDonut');
    var myDonutChart = new Chart(ctx3, {
        type: 'doughnut',
        data: datapie,
        options: optionpie
    });

    var datapie2 = {
        labels: ['Personal', 'Medical', 'Other'],
        datasets: [{
            data: [20, 40, 35],
            backgroundColor: ['#38c4fa', '#22d273', '#6f42c1']
        }]
    };

    // For a pie chart
    var ctx4 = document.getElementById('chartDonut2');
    var myDonutChart = new Chart(ctx4, {
        type: 'doughnut',
        data: datapie2,
        options: optionpie
    });


})
