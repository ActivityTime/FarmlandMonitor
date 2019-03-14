package neau.cekong.service.impl;

import neau.cekong.mapper.TbUserMapper;
import neau.cekong.pojo.Result;
import neau.cekong.pojo.TbUser;
import neau.cekong.service.LoginService;
import neau.cekong.util.UUIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
                loginedUsers.put(logSession, tb);
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
        TbUser user;
        if (logSession != null) {
            user = loginedUsers.get(logSession);
            if (user != null)
                return new Result(user.getUsername(), "已登录", 200);
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
}
