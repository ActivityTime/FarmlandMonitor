package neau.cekong.controller;

import neau.cekong.pojo.*;
import neau.cekong.service.PermissionManaService;
import neau.cekong.service.SysFuncService;
import neau.cekong.service.SysRoleService;
import neau.cekong.service.SysUserRemarkService;
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

    @Resource
    SysRoleService sysRoleService;

    @Resource
    SysFuncService sysFuncService;

    @Resource
    SysUserRemarkService sysUserRemarkService;

    @RequestMapping("refuse")
    @ResponseBody
    Result noPermission() {
        return new Result(null, "访问拒绝：您没有权限", 500);
    }

    // user
    @RequestMapping("user/list")
    @ResponseBody
    Result userList() {

        List<UserListItemVO> usersList = permissionManaService.findUsersList();

        return new Result(usersList, "查询成功", 200);
    }

    @RequestMapping("user/remark")
    @ResponseBody
    Result userRemark(String username) {

        List<SysUserRemark> remarks = sysUserRemarkService.findRemarksByUsername(username);

        if(remarks == null){
            return new Result(null, "未查询到数据", 500);
        }

        return new Result(remarks, "查询成功", 200);
    }

    // role
    @RequestMapping("role/list")
    @ResponseBody
    Result listRole() {

        List<SysRole> allRoles = sysRoleService.findAllRoles();

        return new Result(allRoles, "查询成功", 200);
    }

    @RequestMapping("role/add")
    @ResponseBody
    Result addRole(String rolename) {

        Result result = sysRoleService.addRole(rolename);

        return result;
    }

    @RequestMapping("role/del")
    @ResponseBody
    Result delRole(String rolename) {

        Result result = sysRoleService.delRole(rolename);

        return result;
    }

    @RequestMapping("role/bind")
    @ResponseBody
    Result bindRoleToUser(String rolename, String username) {

        Result result = permissionManaService.addRoleToUser(rolename, username);

        return result;
    }

    @RequestMapping("role/unbind")
    @ResponseBody
    Result unbindRoleToUser(String rolename, String username) {

        Result result = permissionManaService.delRoleToUser(rolename, username);

        return result;
    }

    @RequestMapping("role/func")
    @ResponseBody
    Result findFuncesByRole(String rolename) {

        List<SysFunc> funcesByRoleName = sysFuncService.findFuncesByRoleName(rolename);

        return new Result(funcesByRoleName, "查询成功", 200);
    }

    // func
    @RequestMapping("func/list")
    @ResponseBody
    Result listFunc() {

        List<SysFunc> allFunces = sysFuncService.findAllFunces();

        return new Result(allFunces, "查询成功", 200);
    }

    @RequestMapping("func/bind")
    @ResponseBody
    Result bindFuncToRole(String rolename, String funccode) {

        Result result = permissionManaService.addFuncesToRole(funccode, rolename);

        return result;
    }

    @RequestMapping("func/unbind")
    @ResponseBody
    Result unbindFuncToRole(String rolename, String funccode) {

        Result result = permissionManaService.delFuncesToRole(funccode, rolename);

        return result;
    }
}
