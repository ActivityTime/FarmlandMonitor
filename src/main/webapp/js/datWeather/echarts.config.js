//接收时间	 TA(℃)	 RH(%)	 PPM(ppm)	 WD(Deg)	 PRESS(hPa)	 DEPTH(mm)	 PAR(umol/㎡·S)	 RA(W/㎡)	 UV3(W/㎡)	 NET_R(W/㎡)	 TS1(℃)	 TS2(℃)	 TS3(℃)	 TS4(℃)	 TS5(℃)	 MS1(%)	 MS2(%)	 MS3(%)	 MS4(%)	 MS5(%)	 WS(m/s)	 RAIN(mm)

    datWeather.echarts.config = {
    chartsFormatJson : [{
        nick:"TA",
        unit:"℃",
        dv:["ta"]
    },{
        nick:"RH",
        unit:"%",
        dv:["rh"]
    },{
        nick:"PPM",
        unit:"ppm",
        dv:["ppm"]
    },{
        nick:"WD",
        unit:"Deg",
        dv:["wd"]
    },{
        nick:"PRESS",
        unit:"hPa",
        dv:["press"]
    },{
        nick:"DEPTH",
        unit:"mm",
        dv:["depth"]
    },{
        nick:"PAR",
        unit:"umol/㎡·S",
        dv:["par"]
    },{
        nick:"RA UV3 NET_R",
        unit:"W/㎡",
        dv:["ra", "uv3", "net_R"]
    },{
        nick:"TS",
        unit:"℃",
        dv:["ts1", "ts2", "ts3", "ts4", "ts5",]
    },{
        nick:"MS",
        unit:"%",
        dv:["ms1", "ms2", "ms3", "ms4", "ms5",]
    },{
        nick:"WS",
        unit:"m/s",
        dv:["ws"]
    },{
        nick:"RAIN",
        unit:"mm",
        dv:["rain"]
    },
    ]
};