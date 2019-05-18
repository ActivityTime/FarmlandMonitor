package neau.cekong.controller;

import neau.cekong.pojo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("permission")
public class PermissionController {


    @RequestMapping("refuse")
    @ResponseBody
    Result noPermission(){
        return new Result(null, "访问拒绝：您没有权限", 500);
    }

}
