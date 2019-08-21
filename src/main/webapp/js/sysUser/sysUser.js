;!function (win) {
    "use strict";
    var doc = document, SysUser = function () {
        this.v = '1.0'; //版本号
    };

    win.sysUser = new SysUser();

    SysUser.prototype.url = urlGlobalConfig.sysUser();

    SysUser.prototype.loginCheck = function (eleLoginUname, logSession) {
        var url = sysUser.url + "user/logcheck";

        if (eleLoginUname == null) eleLoginUname = $(".login-uname");
        if (logSession == null) logSession = $.cookie("LOGSESSION");

        $.post(url, {
            logSession: logSession
        }, function (result) {
            if (result.status == 200) {
                eleLoginUname.html(result.data);
            } else {
                location.href = sysUser.url + "login.html";
            }
        }, "json")
    };

    SysUser.prototype.login = function (username, password) {
        var url = sysUser.url + "user/login";
        $.post(url, {
            username: username,
            password: password,
        }, function (result) {
            if (result.status == 200) {
                $.cookie("LOGSESSION", result.data);
                layer.msg(result.msg, function () {
                    location.href = urlGlobalConfig.global + 'index.html';
                });
                location.href = urlGlobalConfig.global + 'index.html';
            } else {
                layer.msg(result.msg, function () {

                });
            }
        }, "json")
    }

    SysUser.prototype.logout = function () {
        var url = sysUser.url + "user/logout";
        $.post(url, {
            logSession: $.cookie("LOGSESSION")
        }, function (result) {
            if (result.status == 200) {
                layer.msg(result.msg, function () {
                    location.href = sysUser.url + 'login.html';
                });
            } else {
                layer.msg(result.msg, function () {
                    location.href = sysUser.url + 'login.html';
                });
            }
        }, "json")
        location.href = sysUser.url + 'login.html';
    }
}(window);

