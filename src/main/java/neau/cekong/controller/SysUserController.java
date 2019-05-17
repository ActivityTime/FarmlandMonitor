package neau.cekong.controller;

import neau.cekong.pojo.Result;
import neau.cekong.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class SysUserController {

    @Resource
    SysUserService sysUserService;

    @Autowired
    HttpServletRequest request;

    @RequestMapping("login")
    @ResponseBody
    Result loginFail(String username, String password) {

        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");

        String error = null;
        if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "登陆失败：用户名不存在";
        } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "登陆失败：密码错误";
        } else if (exceptionClassName != null) {
            error = "登陆失败：其他错误：" + exceptionClassName;
        } else {
            if(username == null || password == null){
                return new Result(null, "未输入账户信息", 500);
            }else {
                return new Result(null, "登录失败：当前已登录", 200);
            }
        }

        return new Result(null, error, 500);
    }

    @RequestMapping("loginSuccess")
    @ResponseBody
    Result loginSuccess(String username) {

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(false);
        session.setAttribute("username", username);

        return new Result(session.getId(), "登陆成功", 200);
    }

    @RequestMapping("logcheck")
    @ResponseBody
    Result loginCheck(String logSession) {
        return sysUserService.checkLog(logSession);
    }

    @RequestMapping("logoutInfo")
    @ResponseBody
    Result logout(String logSession) {
        return sysUserService.logOut(logSession);
    }
}
