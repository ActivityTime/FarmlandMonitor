;(function () {

    var doc = document, LandRecord = function () {
        this.v = '1.0'; //版本号
    };

    LandRecord.prototype.url = urlGlobalConfig.landRecord();

    LandRecord.prototype.getRecordWithPageUrl = function () {
        return LandRecord.prototype.url + "record/sel/all/page";
    };

    LandRecord.prototype.getCuRecordWithPage = function (success, limit, page) {
        var url = LandRecord.prototype.url + "record/sel/all/page";

        $.post(url, {
            limit: limit,
            page: page
        }, function (result) {
            if (result.status == 200) {

            } else {
                alert(result.msg);
            }

            success(result);
        }, "json");
    };

    LandRecord.prototype.selRecord = function (success, recName) {
        var url = LandRecord.prototype.url + "record/sel";

        $.post(url, {
            recName: recName
        }, function (result) {
            if (result.status == 200) {

            } else {
                alert(result.msg);
            }

            success(result);
        }, "json");
    };

    LandRecord.prototype.addRecord = function (success, name, character, start, end, remarks) {
        var url = LandRecord.prototype.url + "record/ins";
        // String name, String character, String start, String end, String remarks
        $.post(url, {
            name: name, character: character, start: start, end: end, remarks: remarks
        }, function (result) {
            if (result.status == 200) {

            } else {
                alert(result.msg);
            }

            success(result);
        }, "json");
    };

    LandRecord.prototype.altRecord = function (success, name, character, start, end, newName) {
        var url = LandRecord.prototype.url + "record/alt";

        var ele = {name: name};
        if (character != null) ele.character = character;
        if (start != null) ele.start = start;
        if (end != null) ele.end = end;
        if (newName != null) ele.newName = newName;
        $.post(url, ele, function (result) {
            if (result.status == 200) {

            } else {
                alert(result.msg);
            }

            success(result);
        }, "json");
    };

    LandRecord.prototype.selRemark = function (success, recName) {
        var url = LandRecord.prototype.url + "record/remark/sel";

        $.post(url, {
            recName: recName,
        }, function (result) {
            if (result.status == 200) {

            } else {
                alert(result.msg);
            }

            success(result);
        }, "json");
    };

    LandRecord.prototype.addRemark = function (success, key, value, recName) {
        var url = LandRecord.prototype.url + "record/remark/add";

        $.post(url, {
            recName: recName,
            key: key,
            value: value,
        }, function (result) {
            if (result.status == 200) {

            } else {
                alert(result.msg);
            }

            success(result);
        }, "json");
    };

    LandRecord.prototype.altRemark = function (success, key, value, recName, newKey) {
        var url = LandRecord.prototype.url + "record/remark/alt";

        var ele = {
            recName: recName,
            key: key,
        }

        if (newKey != null) ele.newKey = newKey;
        if (value != null) ele.value = value;

        $.post(url, ele, function (result) {
            if (result.status == 200) {

            } else {
                alert(result.msg);
            }

            success(result);
        }, "json");
    };

    LandRecord.prototype.delRemark = function (success, key, recName) {
        var url = LandRecord.prototype.url + "record/remark/del";

        $.post(url, {
            recName: recName,
            key: key,
        }, function (result) {
            if (result.status == 200) {

            } else {
                alert(result.msg);
            }

            success(result);
        }, "json");
    };

    window.landRecord = new LandRecord();
}());