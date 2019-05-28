package neau.cekong.service.impl;

import neau.cekong.mapper.*;
import neau.cekong.pojo.*;
import neau.cekong.service.PermissionManaService;
import neau.cekong.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class PerssionManaServiceImpl implements PermissionManaService {

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    SysRoleService sysRoleService;

    @Resource
    SysUserRemarkMapper sysUserRemarkMapper;

    @Resource
    SysRoleMapper sysRoleMapper;

    @Resource
    SysUserRoleRMapper sysUserRoleRMapper;

    @Resource
    SysFuncMapper sysFuncMapper;

    @Resource
    SysFuncRoleRMapper sysFuncRoleRMapper;

    @Override
    public List<UserListItemVO> findUsersList() {

        // 查询所有用户
        List<SysUser> sysUsers = sysUserMapper.selectByExample(new SysUserExample());

        // 表
        LinkedList<UserListItemVO> userList = new LinkedList<>();

        // 查询记录
        if (sysUsers != null)
            for (SysUser user : sysUsers) {
                // 创建一条记录
                UserListItemVO userItem = new UserListItemVO();
                userItem.setId(user.getId());
                userItem.setName(user.getUsername());
                userItem.setRoles(new LinkedList<>());
                userItem.setRemarks(new HashMap<>());

                // 查角色
                List<SysRole> rolesByUserName = sysRoleService.findRolesByUserName(user.getUsername());
                if (rolesByUserName != null) {
                    List<String> roles = userItem.getRoles();
                    for (SysRole sysRole : rolesByUserName) {
                        roles.add(sysRole.getRole_name());
                    }
                }

                // 查备注
                SysUserRemarkExample example = new SysUserRemarkExample();
                example.createCriteria().andUser_idEqualTo(user.getId());
                List<SysUserRemark> sysUserRemarks = sysUserRemarkMapper.selectByExample(example);
                if (sysUserRemarks != null) {
                    Map<String, String> remarks = userItem.getRemarks();
                    for (SysUserRemark sysUserRemark : sysUserRemarks) {
                        remarks.put(sysUserRemark.getMarkname(), sysUserRemark.getRemarks());
                    }
                }

                userList.add(userItem);
            }

        return userList;
    }


    @Override
    public Result addRoleToUser(String roleName, String username) {

        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andRole_nameEqualTo(roleName);
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);
        if (sysRoles != null && sysRoles.size() > 0) {
            Integer role_id = sysRoles.get(0).getRole_id();

            SysUserExample sysUserExample = new SysUserExample();
            sysUserExample.createCriteria().andUsernameEqualTo(username);
            List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);

            if (sysUsers != null && sysUsers.size() > 0) {
                Long user_id = sysUsers.get(0).getId();

                SysUserRoleR sysUserRoleR = new SysUserRoleR();
                sysUserRoleR.setRole_id(role_id);
                sysUserRoleR.setUser_id(user_id);

                sysUserRoleRMapper.insertSelective(sysUserRoleR);

                return new Result(true, "用户角色设置成功", 200);
            } else {
                return new Result(false, "用户角色设置失败：用户不存在", 500);
            }
        } else {
            return new Result(false, "用户角色设置失败：角色不存在", 500);
        }
    }

    @Override
    public Result delRoleToUser(String roleName, String username) {
        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andRole_nameEqualTo(roleName);
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);
        if (sysRoles != null && sysRoles.size() > 0) {
            Integer role_id = sysRoles.get(0).getRole_id();
            System.out.print("");// 本行没用
            SysUserExample sysUserExample = new SysUserExample();
            sysUserExample.createCriteria().andUsernameEqualTo(username);
            List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);

            if (sysUsers != null && sysUsers.size() > 0) {
                Long user_id = sysUsers.get(0).getId();

                SysUserRoleRExample sysUserRoleRExample = new SysUserRoleRExample();
                sysUserRoleRExample.createCriteria().andUser_idEqualTo(user_id).andRole_idEqualTo(role_id);
                List<SysUserRoleR> sysUserRoleRS = sysUserRoleRMapper.selectByExample(sysUserRoleRExample);
                if (sysUserRoleRS != null && sysUserRoleRS.size() > 0) {
                    sysUserRoleRMapper.deleteByExample(sysUserRoleRExample);
                    return new Result(true, "用户角色删除成功", 200);
                } else {
                    return new Result(false, "用户角色删除失败：用户不持有该角色", 500);
                }


            } else {
                return new Result(false, "用户角色删除失败：用户不存在", 500);
            }
        } else {
            return new Result(false, "用户角色删除失败：角色不存在", 500);
        }
    }

    @Override
    public Result addFuncesToRole(String funcCode, String roleName) {

        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andRole_nameEqualTo(roleName);
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);
        if (sysRoles != null && sysRoles.size() > 0) {
            Integer role_id = sysRoles.get(0).getRole_id();

            SysFuncExample sysFuncExample = new SysFuncExample();
            sysFuncExample.createCriteria().andFunc_codeEqualTo(funcCode);
            List<SysFunc> sysFuncs = sysFuncMapper.selectByExample(sysFuncExample);

            if (sysFuncs != null && sysFuncs.size() > 0) {
                Integer func_id = sysFuncs.get(0).getFunc_id();

                SysFuncRoleR sysFuncRoleR = new SysFuncRoleR();
                sysFuncRoleR.setFunc_id(func_id);
                sysFuncRoleR.setRole_id(role_id);

                sysFuncRoleRMapper.insertSelective(sysFuncRoleR);

                return new Result(true, "角色权限设置成功", 200);
            } else {
                return new Result(false, "角色权限设置失败：权限码不存在", 500);
            }
        } else {
            return new Result(false, "角色权限设置失败：角色不存在", 500);
        }
    }

    @Override
    public Result delFuncesToRole(String funcCode, String roleName) {
        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andRole_nameEqualTo(roleName);
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);
        if (sysRoles != null && sysRoles.size() > 0) {
            Integer role_id = sysRoles.get(0).getRole_id();
            System.out.print("");// 本行没用
            SysFuncExample sysFuncExample = new SysFuncExample();
            sysFuncExample.createCriteria().andFunc_codeEqualTo(funcCode);
            List<SysFunc> sysFuncs = sysFuncMapper.selectByExample(sysFuncExample);

            if (sysFuncs != null && sysFuncs.size() > 0) {
                Integer func_id = sysFuncs.get(0).getFunc_id();

                SysFuncRoleRExample sysFuncRoleRExample = new SysFuncRoleRExample();
                sysFuncRoleRExample.createCriteria().andFunc_idEqualTo(func_id).andRole_idEqualTo(role_id);
                List<SysFuncRoleR> sysFuncRoleRS = sysFuncRoleRMapper.selectByExample(sysFuncRoleRExample);
                if (sysFuncRoleRS != null && sysFuncRoleRS.size() > 0) {
                    sysFuncRoleRMapper.deleteByExample(sysFuncRoleRExample);
                    return new Result(true, "角色权限删除成功", 200);
                } else {
                    return new Result(false, "角色权限删除失败：角色不持有该权限", 500);
                }
            } else {
                return new Result(false, "角色权限设置失败：权限码不存在", 500);
            }
        } else {
            return new Result(false, "角色权限设置失败：角色不存在", 500);
        }
    }
}
