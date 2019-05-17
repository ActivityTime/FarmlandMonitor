package neau.cekong.service;

import neau.cekong.pojo.Result;
import neau.cekong.pojo.SysUser;

public interface SysUserService {
//    Map<String, UserLoginStatus> loginedUsers = new HashMap<>();

    @Deprecated
    Result login(SysUser user);
    Result addUser(SysUser user);
    Result delUser(SysUser user);
    Result updPassword(SysUser user, String newPassword);
    Result checkLog(String logSession);
    Result logOut(String logSession);
}
