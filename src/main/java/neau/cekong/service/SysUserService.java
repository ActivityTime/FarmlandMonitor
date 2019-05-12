package neau.cekong.service;

import neau.cekong.pojo.Result;
import neau.cekong.pojo.SysUser;

import java.util.HashMap;
import java.util.Map;

public interface SysUserService {
    Map<String, SysUser> loginedUsers = new HashMap<>();

    Result login(SysUser user);
    Result insUser(SysUser user);
    Result checkLog(String logSession);
    Result logOut(String logSession);
}
