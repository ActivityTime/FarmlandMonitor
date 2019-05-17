package neau.cekong.shiro;

import neau.cekong.mapper.SysUserMapper;
import neau.cekong.pojo.SysUser;
import neau.cekong.pojo.SysUserExample;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;


public class UserRealm extends AuthorizingRealm {

    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public String getName() {
        return "UserRealm";
    }

    //用于认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //从 token 中获取身份信息
        String username = (String) token.getPrincipal();
        String password = null;//从数据库中获取密码

        if(username == null){
            throw new  NoAccountInputException("NoAccountInputException");
        }// 没用

        //根据用户名到数据库中取出用户信息 如果查询不到 返回 null
        SysUserExample condition = new SysUserExample();
        condition.createCriteria().andUsernameEqualTo(username);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(condition);
        if (sysUsers != null && sysUsers.size() > 0) {
            password = sysUsers.get(0).getPassword();
        }else{
            throw new  UnknownAccountException();
        }

//        System.out.println(username + password);

        //返回认证信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, this.getName());
        return simpleAuthenticationInfo;
    }

    //用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}


