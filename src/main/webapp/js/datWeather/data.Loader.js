datWeather.data.loader = {
    topX:function (num0, success) {
        return $.post(datWeather.url+"datWeather/load/top", {
            num:num0,
        },function(result) {
            console.log(result);
            if (success != null)
                success(result);
        },"json")
    }
};