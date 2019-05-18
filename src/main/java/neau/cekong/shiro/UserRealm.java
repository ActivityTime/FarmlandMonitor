package neau.cekong.shiro;

import neau.cekong.aop.annotation.NullPointerReturnNull;
import neau.cekong.mapper.SysUserMapper;
import neau.cekong.pojo.SysFunc;
import neau.cekong.pojo.SysRole;
import neau.cekong.pojo.SysUser;
import neau.cekong.pojo.SysUserExample;
import neau.cekong.service.SysFuncService;
import neau.cekong.service.SysRoleService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    SysRoleService sysRoleService;

    @Resource
    SysFuncService sysFuncService;

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

        if (username == null) {
            throw new NoAccountInputException("NoAccountInputException");
        }// 没用

        //根据用户名到数据库中取出用户信息 如果查询不到 返回 null
        SysUserExample condition = new SysUserExample();
        condition.createCriteria().andUsernameEqualTo(username);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(condition);
        if (sysUsers != null && sysUsers.size() > 0) {
            password = sysUsers.get(0).getPassword();
        } else {
            throw new UnknownAccountException();
        }

//        System.out.println(username + password);

        //返回认证信息
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password, this.getName());
        return simpleAuthenticationInfo;
    }

    // 用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 获取身份信息
        String username = (String) principals.getPrimaryPrincipal();

        // 获取角色信息
        Set<String> roles = new HashSet<>();
        List<SysRole> rolesByUserName = sysRoleService.findRolesByUserName(username);
        for (SysRole role : rolesByUserName == null ? new ArrayList<SysRole>() : rolesByUserName) {
            roles.add(role.getRole_name());
        }

        // 根据身份信息获取权限数据
        Set<String> permissions = new HashSet<>();
        Set<SysFunc> funces = sysFuncService.findFuncesByRoles(rolesByUserName);
        for (SysFunc func : funces == null ? new ArrayList<SysFunc>() : funces) {
            permissions.add(func.getFunc_code());
        }
//        permissions.add("user:save");
//        permissions.add("user:delete");

        // 将权限信息保存到 AuthorizationInfo  中
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    @NullPointerReturnNull
    public void test(int i){
        System.out.println(i);
    }
}


