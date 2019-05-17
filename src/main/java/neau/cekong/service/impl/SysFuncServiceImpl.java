package neau.cekong.service.impl;

import neau.cekong.mapper.SysFuncMapper;
import neau.cekong.mapper.SysFuncRoleRMapper;
import neau.cekong.mapper.SysRoleMapper;
import neau.cekong.pojo.*;
import neau.cekong.service.SysFuncService;
import neau.cekong.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SysFuncServiceImpl implements SysFuncService {

    @Resource
    SysFuncMapper sysFuncMapper;

    @Resource
    SysRoleMapper sysRoleMapper;

    @Resource
    SysFuncRoleRMapper sysFuncRoleRMapper;

    @Override
    public List<SysFunc> findFuncesByRoleName(String roleName) {


        SysRoleExample sysRoleExample = new SysRoleExample();
        sysRoleExample.createCriteria().andRole_nameEqualTo(roleName);
        List<SysRole> sysRole = sysRoleMapper.selectByExample(sysRoleExample);
        if (sysRole == null || sysRole.size() < 1) {
            return null;
        }
        Integer roleId = sysRole.get(0).getRole_id();

        SysFuncRoleRExample sysFuncRoleRExample = new SysFuncRoleRExample();
        sysFuncRoleRExample.createCriteria().andRole_idEqualTo(roleId);
        List<SysFuncRoleR> sysFuncRoleR = sysFuncRoleRMapper.selectByExample(sysFuncRoleRExample);
        if (sysFuncRoleR == null || sysFuncRoleR.size() == 0) {
            return null;
        }
        List<Integer> funcIdes = new LinkedList<>();
        for (SysFuncRoleR frs : sysFuncRoleR) {
            Integer funcId = frs.getFunc_id();
            funcIdes.add(funcId);
        }

        SysFuncExample sysFuncExample = new SysFuncExample();
        sysFuncExample.createCriteria().andFunc_idIn(funcIdes);
        List<SysFunc> sysFuncs = sysFuncMapper.selectByExample(sysFuncExample);


        return sysFuncs;
    }

    @Resource
    SysRoleService sysRoleService;

    @Override
    public Set<SysFunc> findFuncesByUserName(String userName) {
        List<SysRole> neau = sysRoleService.findRolesByUserName(userName);

        Set<SysFunc> sysFuncs = new HashSet<>();
        for (SysRole sysRole : neau) {
            List<SysFunc> funcesByRoleName = this.findFuncesByRoleName(sysRole.getRole_name());
            for (SysFunc sf:funcesByRoleName) {
                sysFuncs.add(sf);
            }
        }

        return sysFuncs;
    }
}
