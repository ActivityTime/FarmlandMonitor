package neau.cekong.service;

import neau.cekong.pojo.SysFunc;

import java.util.List;
import java.util.Set;

public interface SysFuncService {
    List<SysFunc> findFuncesByRoleName(String roleName);
    Set<SysFunc> findFuncesByUserName(String userName);
}
