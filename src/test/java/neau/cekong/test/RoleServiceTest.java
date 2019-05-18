package neau.cekong.test;

import neau.cekong.pojo.SysFunc;
import neau.cekong.pojo.SysRole;
import neau.cekong.service.SysFuncService;
import neau.cekong.service.SysRoleService;
import neau.cekong.shiro.UserRealm;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class RoleServiceTest extends BaseJunit4Test {

    @Resource
    SysRoleService sysRoleService;

    @Resource
    SysFuncService sysFuncService;

    @Test
    public void test() {
        List<SysRole> neau = sysRoleService.findRolesByUserName("neau");

        System.out.println(neau);

        Set<SysFunc> sysFuncs = new HashSet<>();
        for (SysRole sysRole : neau) {
            List<SysFunc> funcesByRoleName = sysFuncService.findFuncesByRoleName(sysRole.getRole_name());
            for (SysFunc sf : funcesByRoleName) {
                sysFuncs.add(sf);
            }
        }

        System.out.println(sysFuncs);
    }

    Scanner scanner = new Scanner(System.in);

    @Test
    public void test0() throws InterruptedException {
        int i = 10;
        while ((i--) > 0) {
            Set<SysFunc> neau = sysFuncService.findFuncesByUserName("neau");
            System.out.println(neau);

            Thread.sleep(1000);
        }
    }

    @Resource
    UserRealm test;

    @Test
    public void test1(){

        test.test(100);

    }
}

