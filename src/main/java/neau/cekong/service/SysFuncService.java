package neau.cekong.service;

import neau.cekong.pojo.SysFunc;
import neau.cekong.pojo.SysRole;

import java.util.List;
import java.util.Set;

public interface SysFuncService {
    List<SysFunc> findFuncesByRoleName(String roleName);
    Set<SysFunc> findFuncesByRoles(List<SysRole> roles);
    Set<SysFunc> findFuncesByUserName(String userName);
}
