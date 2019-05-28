package neau.cekong.service;

import neau.cekong.pojo.Result;
import neau.cekong.pojo.SysRole;

import java.util.List;

public interface SysRoleService {
    List<SysRole> findRolesByUserName(String username);
    Result addRole(String roleName);
    Result delRole(String roleName);
    List<SysRole> findAllRoles();
}
