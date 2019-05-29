datWeather.data.loader = {
    topX: function (num0, success, before) {
        if (before != null)
            before();
        return $.post(datWeather.url + "datWeather/load/top", {
            num: num0,
        }, function (result) {
            // console.log(result);
            if (result["status"] == 500){
                alert(result.msg)
            }
            if (success != null)
                success(result);
        }, "json")
    },
    btwX: function (start, end, success, before) {
        if (before != null)
            before();
        return $.post(datWeather.url + "datWeather/load/date", {
            start: start,
            end: end,
        }, function (result) {
            // console.log(result);
            if (result["status"] == 500){
                alert(result.msg)
            }
            if (success != null)
                success(result);
        }, "json")
    }
};