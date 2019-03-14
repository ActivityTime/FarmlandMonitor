$.post("/user/check", {
    "LOGSESSION": $.cookie("LOGSESSION")
}, function (result) {
    if (result && result.status == "200") {
        $("#UserLog").text(result.data);
    } else {
        location.href = "/login.html";
        alert("您尚未登录");
    }
}, "json").error(function () {
    alert("error");
    location.href = "/login.html";
});
