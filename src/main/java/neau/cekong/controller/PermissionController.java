package neau.cekong.controller;

import neau.cekong.pojo.Result;
import neau.cekong.pojo.UserListItemVO;
import neau.cekong.service.PermissionManaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("permission")
public class PermissionController {

    @Resource
    PermissionManaService permissionManaService;

    @RequestMapping("refuse")
    @ResponseBody
    Result noPermission(){
        return new Result(null, "访问拒绝：您没有权限", 500);
    }

    @RequestMapping("userlist")
    @ResponseBody
    Result userList(){

        List<UserListItemVO> usersList = permissionManaService.findUsersList();

        return new Result(usersList, "查询成功",200);
    }

}
