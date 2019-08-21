!(function () {
    var doc = document, downloading = function () {
        this.v = '1.0'; //版本号
    };

    downloading.prototype.url = urlGlobalConfig.downloading();// 起始地址

    downloading.prototype.make = function (start, end, success) {
        var url = downloading.prototype.url + "file/datWeather";

        $.post(url, {start: start, end: end}, function (result) {
            if (result.status == 200) {
                success(result);
            } else {
                alert(result.msg);
            }
        }, "json");
    };

    downloading.prototype.check = function (uuid, success) {
        var url = downloading.prototype.url + "file/datWeather/check";

        $.post(url, {uuid: uuid}, function (result) {
            if (result.status == 200) {
                success(result);
            } else {
                alert(result.msg);
            }
        }, "json");
    };

    downloading.prototype.downFileUrl = downloading.prototype.url+ "file/datWeather/download";

    window.downloading = new downloading();

})();