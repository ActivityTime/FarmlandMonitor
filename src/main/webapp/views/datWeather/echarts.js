datWeather.echarts.builder = {
    /* 图表默认设置 */
    option: {
        title: {
            text: ''
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross'
            }
        },
        legend: {
            data: ['温度', '湿度']
        },

        dataZoom: [/*{
            type: 'slider',
            xAxisIndex: 0,
            filterMode: 'none'
        },*/
            {
                type: 'inside',
                yAxisIndex: 0,
                filterMode: 'none',
                zoomLock: true,
                zoomOnMouseWheel: false,
            },
            {
                type: 'inside',
                xAxisIndex: 0,
                filterMode: 'none'
            },
            //			{
            //				type: 'inside',
            //				yAxisIndex: [0, 1],
            //				filterMode: 'empty'
            //			}
        ],
        toolbox: {
            show: true,
            feature: {
                dataZoom: {},
                dataView: {
                    readOnly: true,
                    /*数据图表*/
                    optionToContent: function (opt) {
                        var series = opt.series;
                        var style = '<style>.dataView-table{width:100%;text-align:center;border-collapse:collapse;border-spacing:0px;border:1px solid black;} .dataView-table td{border:1px solid black;}</style>';
                        var table = '<table contenteditable="true" class="dataView-table"><tbody><tr>'
                            + '<td>时间</td>'
                            + '<td>' + series[0].name + '</td>'
                            + '</tr>';
                        for (var i = 0, l = series[0].data.length; i < l; i++) {
                            table += '<tr>'
                                + '<td>' + series[0].data[i][0] + '</td>'
                                + '<td>' + series[0].data[i][1] + '</td>'
                                + '</tr>';
                        }
                        table += '</tbody></table>';
                        return style + table;
                    }
                },
                magicType: {
                    type: ['line', 'bar']
                },
                restore: {},
                saveAsImage: {}
            }
        },
        //		dataset: {
        //			// 这里指定了维度名的顺序，从而可以利用默认的维度到坐标轴的映射。
        //			// 如果不指定 dimensions，也可以通过指定 series.encode 完成映射，参见后文。
        //			dimensions: ['温度', '湿度'],
        //			source: []
        //		},
        xAxis: {
            type: 'time',
        },
        yAxis: [{
            name: '',
            axisLabel: {
                formatter: '{value} °C'
            },
            max: function (value) {
                return (value.max + (value.max - value.min) / 3).toFixed(2);
            },
            min: function (value) {
                return (value.min - (value.max - value.min) / 3).toFixed(2);
            }
        }],

        series: [{
            name: '温度',
            type: 'line',
            yAxisIndex: 0,
            connectNulls: true, //连接断点
            smooth: true,
            symbol: "none",
            data: []
        },]
    },
    /* y轴对象默认设置 unused */
    yAxisOb: {
        name: '温度',
        axisLabel: {
            formatter: '{value} °C'
        },
        max: function (value) {
            return (value.max + (value.max - value.min) / 3).toFixed(2);
        },
        min: function (value) {
            return (value.min - (value.max - value.min) / 3).toFixed(2);
        }
    },
    /* 数据系列默认设置 unused */
    seriesOb: {
        name: '温度',
        type: 'line',
        yAxisIndex: 0,
        connectNulls: true, //连接断点
        smooth: true,
        symbol: "none",
        data: [
            ["2019-05-11 13:00:32", 36.8123], ["2019-05-11 13:15:32", 32.8456], ["2019-05-11 13:30:32", 34.8564], ["2019-05-11 13:45:32", 38.8645],
        ]
    },
    /* 图表元素目标模版 */
    modle: "<div class=\"layui-col-sm12 layui-col-md6\">\n" +
        "                    <div class=\"layui-card\">\n" +
        "                        <div class=\"layui-card-header\">#{title}</div>\n" +
        "                        <div class=\"layui-card-body\" style=\"min-height: 280px;\">\n" +
        "                            <div id=\"#{id}\" class=\"layui-col-sm12\" style=\"height: 300px;\"></div>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                </div>"
    ,
    /* 新增图表目标元素 */
    newChart: function (title, id) {
        var domStr = datWeather.echarts.builder.modle.replace("#{title}", title).replace("#{id}", id);
        $(".echarts-list").append($(domStr));
        return echarts.init(document.getElementById(id));
    },
    /* 加载图表列表 */
    loadChartList: function (formatJson) {
        if (formatJson == null)
            formatJson = datWeather.echarts.config.chartsFormatJson;
        var newChart = datWeather.echarts.builder.newChart;
        var count = 0;
        datWeather.echarts.list = [];
        formatJson.forEach(function (v) {
            datWeather.echarts.list[count] = newChart(v.nick, "chart" + count);
            datWeather.echarts.list[count].showLoading();
            datWeather.echarts.list[count].setOption(datWeather.echarts.builder.option);
            count++;
        });
    },
    /* 获取气象数据 */
    getData: function () {

    },
    /* 刷新数据图表数据 */
    reFresh: function (result, formatJson) {
        if (formatJson == null)
            formatJson = datWeather.echarts.config.chartsFormatJson;
        var chartList = datWeather.echarts.list;
        var count = 0;

        formatJson.forEach(function (c) {
            chartList[count].setOption({
                legend: {
                    data: c.dv,
                },
                series: function () {
                    var series = [];
                    c.dv.forEach(function (dv) {
                        series.push({
                            name: dv,
                            data: function () {
                                var data = [];

                                result.forEach(function (v) {
                                    data.push([v.retime, v[dv]]);
                                });

                                return data;
                            }(),
                            type: 'line',
                            yAxisIndex: 0,
                            connectNulls: true, //连接断点
                            smooth: true,
                            symbol: "none",
                        });
                    });
                    // console.log(series);
                    return series;
                }(),
                yAxis: [{
                    name: '',
                    axisLabel: {
                        formatter: '{value}' + c.unit,
                    },
                }],
            });
            count++;
        });

        datWeather.echarts.builder.hideLoading(400);
    },
    /* 加载动画 */
    showLoading:function(){
        datWeather.echarts.list.forEach(function (c) {
            c.showLoading();
        });
    },
    hideLoading:function(timeout){
        setTimeout(function () {
            datWeather.echarts.list.forEach(function (c) {
                c.hideLoading();
            });
        }, timeout);
    },
    /* 日期选择事件注册 */
    setDateCheck: function () {
        /* 加载日期组件 */
        layui.use('laydate', function () {
            var laydate = layui.laydate;

            //执行一个laydate实例
            laydate.render({
                elem: $('.date-check-start').get(0),
                type: 'datetime',
                range: false,
                format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
            });
            laydate.render({
                elem: $('.date-check-end').get(0),
                type: 'datetime',
                range: false,
                format: 'yyyy-MM-dd HH:mm:ss' //可任意组合
            });

            // 添加提换所有函数
            String.prototype.replaceAll = function (AFindText, ARepText) {
                raRegExp = new RegExp(AFindText, "g");
                return this.replace(raRegExp, ARepText);
            };
        });
        /* 设置点击事件 */
        $(".date-check-do").click(function () {
            datWeather.echarts.builder.showLoading();
            var start = $(".date-check-start").val().replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "");
            var end = $(".date-check-end").val().replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "");
            datWeather.data.loader.btwX(start, end, datWeather.echarts.builder.reFresh);
        });
    }
};

//加载图表列表
datWeather.echarts.builder.loadChartList();

// 获取前n条数据 初始化
datWeather.data.loader.topX(1000, datWeather.echarts.builder.reFresh, datWeather.echarts.builder.showLoading);

// 注册日期选择事件
datWeather.echarts.builder.setDateCheck();