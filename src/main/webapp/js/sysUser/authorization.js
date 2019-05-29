(function (win) {

    var doc = document, Authorization = function () {
        this.v = '1.0'; //版本号
    };

    Authorization.prototype.url = urlGlobalConfig.sysUser();

    Authorization.prototype.getFuncList = function (success) {
        var url = Authorization.prototype.url + "permission/func/list";

        $.post(url, {}, function (result) {
            if (result.status == 200) {
                success(result);
            } else {
                alert(result.msg);
            }
        }, "json");

    };

    Authorization.prototype.getRoleFunces = function (success, rolename) {
        var url = Authorization.prototype.url + "permission/role/func";

        $.post(url, {
            rolename: rolename
        }, function (result) {
            if (result.status == 200) {
                success(result);
            } else {
                alert(result.msg);
            }
        }, "json");

    };

    Authorization.prototype.getRoleList = function (success) {
        var url = Authorization.prototype.url + "permission/role/list";

        $.post(url, {}, function (result) {
            if (result.status == 200) {
                success(result);
            } else {
                alert(result.msg);
            }
        }, "json");

    };

    Authorization.prototype.getUserRoles = function (success, username) {
        var url = Authorization.prototype.url + "permission/user/role";

        $.post(url, {
            username: username
        }, function (result) {
            if (result.status == 200) {
                success(result);
            } else {
                alert(result.msg);
            }
        }, "json");

    };

    Authorization.prototype.getUserList = function (success) {
        var url = Authorization.prototype.url + "permission/user/list";

        $.post(url, {}, function (result) {
            if (result.status == 200) {
                success(result);
            } else {
                alert(result.msg);
            }
        }, "json");

    };

    Authorization.prototype.getUserRemarks = function (success, username) {
        var url = Authorization.prototype.url + "permission/user/remark";

        $.post(url, {
            username: username
        }, function (result) {
            if (result.status == 200) {
                success(result);
            } else {
                alert(result.msg);
            }
        }, "json");

    };

    Authorization.prototype.addUserRemark = function (success, username, markname) {
        var url = Authorization.prototype.url + "permission/user/remark/add";

        $.post(url, {
                username: username,
                markname: markname,
                remark: "空",
            }, function (result) {
                if (result.status == 200) {
                    success(result);
                } else {
                    alert(result.msg);
                }
            }, "json"
        );

    };

    Authorization.prototype.altUserRemark = function (success, username, markname, remark, newMarkName) {
        var url = Authorization.prototype.url + "permission/user/remark/alt";

        $.post(url, {
                username: username,
                markname: markname,
                remark: remark,
                newname: newMarkName
            }, function (result) {
                if (result.status == 200) {
                    success(result);
                } else {
                    alert(result.msg);
                }
            }, "json"
        );
    };

    Authorization.prototype.delUserRemark = function (success, username, markname) {
        var url = Authorization.prototype.url + "permission/user/remark/del";

        $.post(url, {
                username: username,
                markname: markname,
            }, function (result) {
                if (result.status == 200) {
                    success(result);
                } else {
                    alert(result.msg);
                }
            }, "json"
        );
    }

    Authorization.prototype.delUser = function (success, username) {
        var url = Authorization.prototype.url + "user/del";

        $.post(url, {
            username: username
        }, function (result) {
            if (result.status == 200) {
                success(result);
            } else {
                alert(result.msg);
            }
        }, "json");

    };

    Authorization.prototype.getUserPassword = function (success, username) {
        var url = Authorization.prototype.url + "user/password";

        $.post(url, {
            username: username
        }, function (result) {
            if (result.status == 200) {
                success(result);
            } else {
                alert(result.msg);
            }
        }, "json");

    };

    Authorization.prototype.altUserPassword = function (success, username, password) {
        var url = Authorization.prototype.url + "user/alt";

        $.post(url, {
            username: username,
            password: password
        }, function (result) {
            if (result.status == 200) {
                success(result);
            } else {
                alert(result.msg);
            }
        }, "json");

    };

    Authorization.prototype.addUser = function (success, username, password) {
        var url = Authorization.prototype.url + "user/add";

        $.post(url, {
            username: username,
            password: password
        }, function (result) {
            if (result.status == 200) {
                success(result);
            } else {
                alert(result.msg);
            }
        }, "json");

    };

    Authorization.prototype.bindUserRole = function (success, username, rolename) {
        var url = Authorization.prototype.url + "permission/role/bind";

        $.post(url, {
            username: username,
            rolename: rolename
        }, function (result) {
                success(result);
        }, "json");

    };

    Authorization.prototype.unbindUserRole = function (success, username, rolename) {
        var url = Authorization.prototype.url + "permission/role/unbind";

        $.post(url, {
            username: username,
            rolename: rolename
        }, function (result) {
                success(result);
        }, "json");

    };

    win.authorization = new Authorization();

}(window))