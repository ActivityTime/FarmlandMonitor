package neau.cekong.service.impl;

import neau.cekong.mapper.SysUserMapper;
import neau.cekong.mapper.SysUserRemarkMapper;
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
    public List<SysRole> findAllRoles() {
        return null;
    }

    @Override
    public Result addRoleToUser(String roleName, String username) {
        return null;
    }

    @Override
    public Result delRoleToUser(String roleName, String username) {
        return null;
    }

    @Override
    public Result addFuncesToRole(String funcCode, String roleName) {
        return null;
    }

    @Override
    public Result delFuncesToRole(String funcCode, String roleName) {
        return null;
    }
}
