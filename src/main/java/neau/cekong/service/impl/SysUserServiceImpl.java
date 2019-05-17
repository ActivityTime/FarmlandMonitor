package neau.cekong.service.impl;

import neau.cekong.mapper.SysUserMapper;
import neau.cekong.pojo.Result;
import neau.cekong.pojo.SysUser;
import neau.cekong.pojo.SysUserExample;
import neau.cekong.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    @Override
    @Deprecated
    public Result login(SysUser user) {
        return null;
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

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(false);

        if (session != null) {
            session.touch();
            return new Result(subject.getPrincipal(), "用户已登陆 : check", 200);
        } else {
            return new Result("未登陆", "用户未登陆 : check", 500);
        }
    }

    @Override
    public Result logOut(String logSession) {
            return new Result(true, "用户已注销", 200);
    }
}
