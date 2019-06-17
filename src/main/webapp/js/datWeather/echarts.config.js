//接收时间	 TA(℃)	 RH(%)	 PPM(ppm)	 WD(Deg)	 PRESS(hPa)	 DEPTH(mm)	 PAR(umol/㎡·S)	 RA(W/㎡)	 UV3(W/㎡)	 NET_R(W/㎡)	 TS1(℃)	 TS2(℃)	 TS3(℃)	 TS4(℃)	 TS5(℃)	 MS1(%)	 MS2(%)	 MS3(%)	 MS4(%)	 MS5(%)	 WS(m/s)	 RAIN(mm)
//接收时间, TA(℃)空气温度, RH(%)空气湿度, PPM(ppm), WD(Deg)风向, PRESS(hPa)大气压, DEPTH(mm)水井深度变化, PAR(umol/㎡·S)光合有效辐射, RA(W/㎡)太阳总辐射, UV3(W/㎡)紫外辐射, NET_R(W/㎡)净辐射, TS1(℃), TS2(℃), TS3(℃), TS4(℃), TS5(℃), MS1(%)土壤含水量, MS2(%), MS3(%), MS4(%), MS5(%), WS(m/s)风速, RAIN(mm)降雨量,
    datWeather.echarts.config = {
    chartsFormatJson : [{
        nick:"TA(℃)空气温度",
        unit:"℃",
        dv:["ta"]
    },{
        nick:"RH(%)空气湿度",
        unit:"%",
        dv:["rh"]
    },{
        nick:"PPM",
        unit:"ppm",
        dv:["ppm"]
    },{
        nick:"WD(Deg)风向",
        unit:"Deg",
        dv:["wd"]
    },{
        nick:"PRESS(hPa)大气压",
        unit:"hPa",
        dv:["press"]
    },{
        nick:"DEPTH(mm)水井深度变化",
        unit:"mm",
        dv:["depth"]
    },{
        nick:"PAR(umol/㎡·S)光合有效辐射",
        unit:"umol/㎡·S",
        dv:["par"]
    },{
        nick:"RA(W/㎡)太阳总辐射 UV3(W/㎡)紫外辐射 NET_R(W/㎡)净辐射",
        unit:"W/㎡",
        dv:["ra", "uv3", "net_R"]
    },{
        nick:"TS",
        unit:"℃",
        dv:["ts1", "ts2", "ts3", "ts4", "ts5",]
    },{
        nick:"MS(%)土壤含水量",
        unit:"%",
        dv:["ms1", "ms2", "ms3", "ms4", "ms5",]
    },{
        nick:"WS(m/s)风速",
        unit:"m/s",
        dv:["ws"]
    },{
        nick:"RAIN(mm)降雨量",
        unit:"mm",
        dv:["rain"]
    },
    ]
};