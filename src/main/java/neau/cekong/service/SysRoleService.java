package neau.cekong.service;

import neau.cekong.pojo.SysRole;

import java.util.List;

public interface SysRoleService {
    List<SysRole> findRolesByUserName(String username);
}
