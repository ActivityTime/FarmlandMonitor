package neau.cekong.service.impl;

import neau.cekong.mapper.SysRoleMapper;
import neau.cekong.mapper.SysUserMapper;
import neau.cekong.mapper.SysUserRoleRMapper;
import neau.cekong.pojo.*;
import neau.cekong.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    SysUserRoleRMapper sysUserRoleRMapper;

    @Resource
    SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> findRolesByUserName(String username) {

        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUsernameEqualTo(username);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        if (sysUsers == null || sysUsers.size() < 1) {
            return null;
        }
        Long userId = sysUsers.get(0).getId();

        SysUserRoleRExample sysUserRoleRExample = new SysUserRoleRExample();
        sysUserRoleRExample.createCriteria().andUser_idEqualTo(userId);
        List<SysUserRoleR> sysUserRoleRS = sysUserRoleRMapper.selectByExample(sysUserRoleRExample);
        if (sysUserRoleRS == null || sysUserRoleRS.size() < 1) {
            return null;
        }
        List<Integer> roleIdes = new LinkedList<>();
        for (SysUserRoleR urs : sysUserRoleRS) {
            Integer roleId = urs.getRole_id();
            roleIdes.add(roleId);
        }

        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andRole_idIn(roleIdes);
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);

        return sysRoles;
    }

    @Override
    public Result addRole(String roleName) {
        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andRole_nameEqualTo(roleName);
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(sysRoleExample);

        if (sysRoles == null || sysRoles.size() == 0) {
            SysRole sysRole = new SysRole();
            sysRole.setRole_name(roleName);
            sysRoleMapper.insertSelective(sysRole);
            return new Result(false, "创建成功", 200);
        } else {
            return new Result(false, "创建失败：角色名已存在", 500);
        }

    }

}
