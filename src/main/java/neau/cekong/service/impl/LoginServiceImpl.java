package neau.cekong.service.impl;

import neau.cekong.mapper.TbUserMapper;
import neau.cekong.pojo.Result;
import neau.cekong.pojo.TbUser;
import neau.cekong.pojo.UserLogStat;
import neau.cekong.service.LoginService;
import neau.cekong.util.UUIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    TbUserMapper tbUserMapper;

    @Override
    public Result login(TbUser user) {

        TbUser tb = tbUserMapper.selByName(user.getUsername());

        if (user != null && tb != null) {
            if (user.getPassword().equals(tb.getPassword())) {
                String logSession = UUIDUtils.getUUID();
                loginedUsers.put(logSession, new UserLogStat(tb));
                return new Result(logSession, "登录成功", 200);
            } else {
                return new Result(null, "登录失败:密码错误", 500);
            }
        } else {
            return new Result(null, "登录失败:用户不存在", 500);
        }

    }

    @Override
    public Result checkLog(String logSession) {
        UserLogStat user;
        if (logSession != null) {
            user = loginedUsers.get(logSession);
            if (user != null) {
                user.setLastTime(new Date());
                return new Result(user.getUsername(), "已登录", 200);
            }
        }
        return new Result(null, "未登录", 500);
    }

    @Override
    public Result logOut(String logSession) {
        UserLogStat user;
        if (logSession != null) {
            user = loginedUsers.get(logSession);
            if (user != null) {
                loginedUsers.remove(logSession);
                return new Result(null, "已退出", 200);
            }
        }
        return new Result(null, "未登录", 500);
    }

    @Override
    public Result insUser(TbUser user) {
        TbUser tb = tbUserMapper.selByName(user.getUsername());
        if (user != null && tb == null) {
            int num = tbUserMapper.insertSelective(user);
            if (num > 0)
                return new Result(null, "注册成功", 200);
        }
        return new Result(null, "注册失败：用户已存在", 500);
    }

    // 登录状态过期检测
    {
        new Thread(new Runnable() {
            Map<String, UserLogStat> users = LoginService.loginedUsers;
            Set<String> keys;
            Long lastTime;
            Long now;
            Long overTime = 1000 * 60 * 10L;

            @Override
            public void run() {
                keys = LoginService.loginedUsers.keySet();
                for (String key : keys) {
                    lastTime = users.get(key).getLastTime().getTime();
                    now = System.currentTimeMillis();
                    if (now - lastTime > overTime) {
                        users.remove(key);
                    }
                }
                try {
                    Thread.sleep(overTime / 2);
                } catch (Exception e) {

                }
            }
        }).start();
    }

}
