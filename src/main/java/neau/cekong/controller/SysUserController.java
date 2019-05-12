package neau.cekong.controller;

import neau.cekong.pojo.Result;
import neau.cekong.pojo.SysUser;
import neau.cekong.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("user")
public class SysUserController {

    @Resource
    SysUserService sysUserService;

    @RequestMapping("login")
    @ResponseBody
    Result login(String username, String password){
        SysUser user = new SysUser();
        user.setUsername(username);
        user.setPassword(password);
        return sysUserService.login(user);
    }

    @RequestMapping("logcheck")
    @ResponseBody
    Result loginCheck(String logSession){
        return sysUserService.checkLog(logSession);
    }

    @RequestMapping("logout")
    @ResponseBody
    Result logout(String logSession){
        return sysUserService.logOut(logSession);
    }
}
