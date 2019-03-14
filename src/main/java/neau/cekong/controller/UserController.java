package neau.cekong.controller;

import neau.cekong.pojo.Result;
import neau.cekong.pojo.TbUser;
import neau.cekong.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    LoginService loginService;

    @RequestMapping("check")
    @ResponseBody
    public Result loginCheck(String LOGSESSION){
        return loginService.checkLog(LOGSESSION);
    }

    @RequestMapping("login")
    @ResponseBody
    public Result login(TbUser tbUser){
        return loginService.login(tbUser);
    }

    @RequestMapping("regist")
    @ResponseBody
    public Result regist(TbUser tbUser){
        return loginService.insUser(tbUser);
    }

}
