package neau.cekong.service.impl;

import neau.cekong.mapper.SysUserMapper;
import neau.cekong.pojo.Result;
import neau.cekong.pojo.SysUser;
import neau.cekong.pojo.SysUserExample;
import neau.cekong.pojo.UserLoginStatus;
import neau.cekong.service.SysUserService;
import neau.cekong.util.LocalDateTimeUtils;
import neau.cekong.util.UUIDUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    LogdUsersMap logdUsersMap;

    @Override
    public Result login(SysUser user) {
        if (user != null && user.getUsername() != null) {
            SysUserExample condition = new SysUserExample();
            condition.createCriteria().andUsernameEqualTo(user.getUsername());
            List<SysUser> sysUsers = sysUserMapper.selectByExample(condition);
            if (sysUsers != null && !sysUsers.isEmpty()) {
                if (sysUsers.get(0).getPassword().equals(user.getPassword())) {
                    class LogSession{
                        String key = "logSession";
                        String val = logdUsersMap.usrLog(user);
                    }// 无意义
                    return new Result(new LogSession().val, "登陆成功", 200);
                } else {
                    return new Result(null, "登陆失败：密码错误", 500);
                }
            } else {
                return new Result(null, "登陆失败：用户名不存在", 500);
            }
        }
        return new Result(null, "登陆失败：用户名为空", 500);
    }

    @Override
    public Result addUser(SysUser user) {
        int i = sysUserMapper.insertSelective(user);
        if (i > 0) {
            return new Result(null, "注册成功", 200);
        }
        return new Result(null, "注册失败：用户名已存在", 500);
    }

    @Override
    public Result delUser(SysUser user) {
        String username = user.getUsername();
        String password = user.getPassword();
        SysUserExample condition = new SysUserExample();
        condition.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        int i = sysUserMapper.deleteByExample(condition);
        if (i > 0) {
            return new Result(null, "删除成功", 200);
        }
        return new Result(null, "删除失败", 500);
    }

    @Override
    public Result updPassword(SysUser user, String nwePassword) {
        SysUserExample condition = new SysUserExample();
        condition.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
        SysUser sysUser = new SysUser();
        sysUser.setPassword(nwePassword);
        int i = sysUserMapper.updateByExampleSelective(sysUser, condition);
        if (i > 0) {
            return new Result(null, "修改成功", 200);
        }
        return new Result(null, "修改失败", 500);
    }


    @Override
    public Result checkLog(String logSession) {
        if (logdUsersMap.checkLog(logSession)) {
            return new Result(logdUsersMap.getLogUser(logSession), "用户已登陆", 200);
        } else {
            return new Result("未登陆", "用户未登陆", 500);
        }
    }

    @Override
    public Result logOut(String logSession) {
        if (logdUsersMap.checkLog(logSession)) {
            logdUsersMap.usrOut(logSession);
            return new Result(true, "用户已注销", 200);
        } else {
            return new Result(true, "用户未登陆", 500);
        }
    }
}

@Component
class LogdUsersMap {

    private Long timeOut = 10L;//分钟 ：登录超时时间

    private Map<String, UserLoginStatus> loginedUsers = new HashMap<>();

    public void setTimeOut(Long timeOut) {
        this.timeOut = timeOut;
    }

    String getLogUser(String logSession) {
        return loginedUsers.get(logSession).getUsername();
    }

    boolean checkLog(String logSession) {
        return loginedUsers.containsKey(logSession);
    }

    String usrLog(SysUser user) {
        String logSession = UUIDUtils.getUUID();
        loginedUsers.put(logSession, new UserLoginStatus(user));
        return logSession;
    }

    boolean usrOut(String logSession) {
        loginedUsers.remove(logSession);
        return true;
    }

    void checkTime() {
        LocalDateTime last = null;
        LocalDateTime now = null;
        for (String session : loginedUsers.keySet()) {
            last = loginedUsers.get(session).getLastCheckTime();
            now = LocalDateTime.now();
            Long far = LocalDateTimeUtils.betweenTwoTime(last, now, ChronoUnit.MINUTES);

            if (far > timeOut) {
                loginedUsers.remove(session);
            }

            loginedUsers.get(session).setLastCheckTime(now);
        }
    }

    { // 登录状态过期检测线程启动
        new Thread(() -> {
            while(true)
            try {
                checkTime();
                Thread.sleep(timeOut / 2);
            } catch (Exception e) {
                checkTime();
            }
        }).start();
    }
}
