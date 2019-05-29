(function () {
    /**
     * [open 打开弹出层]
     * @param  {[type]}  title [弹出层标题]
     * @param  {[type]}  url   [弹出层地址]
     * @param  {[object]}  end     [layer参数对象]
     * @return {[type]}        [description]
     */
    xadmin.openEx = function (title, url, extend) {

        var w = null, h = null, full = null;

        if (title == null || title == '') {
            var title = false;
        }
        ;
        if (url == null || url == '') {
            var url = "404.html";
        }
        ;
        if (w == null || w == '') {
            var w = ($(window).width() * 0.8);
        }
        ;
        if (h == null || h == '') {
            var h = ($(window).height() - 100);
        }
        ;

        var settings = {
            type: 2,
            area: [w + 'px', h + 'px'],
            fix: false, //不固定
            maxmin: true,
            shadeClose: true,
            shade: 0.4,
            title: title,
            content: url,
        }

        for (var k in extend) {
            settings[k] = extend[k];
        }

        var index = layer.open(settings);
        if (full) {
            layer.full(index);
        }
    }
}())