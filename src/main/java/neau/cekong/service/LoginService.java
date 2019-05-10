package neau.cekong.service;

import neau.cekong.pojo.Result;
import neau.cekong.pojo.TbUser;
import neau.cekong.pojo.UserLogStat;

import java.util.HashMap;
import java.util.Map;

public interface LoginService {
    Map<String, UserLogStat> loginedUsers = new HashMap<>();

    Result login(TbUser user);
    Result insUser(TbUser user);
    Result checkLog(String logSession);
    Result logOut(String logSession);
}
