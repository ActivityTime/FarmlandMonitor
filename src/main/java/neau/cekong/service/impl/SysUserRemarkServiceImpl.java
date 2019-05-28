package neau.cekong.service.impl;

import neau.cekong.mapper.SysUserMapper;
import neau.cekong.mapper.SysUserRemarkMapper;
import neau.cekong.pojo.SysUser;
import neau.cekong.pojo.SysUserExample;
import neau.cekong.pojo.SysUserRemark;
import neau.cekong.pojo.SysUserRemarkExample;
import neau.cekong.service.SysUserRemarkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysUserRemarkServiceImpl implements SysUserRemarkService {

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    SysUserRemarkMapper sysUserRemarkMapper;

    @Override
    public List<SysUserRemark> findRemarksByUsername(String username) {

        if (username == null) return null;

        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUsernameEqualTo(username);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);

        if (sysUsers != null && sysUsers.size() > 0) {
            Long user_id = sysUsers.get(0).getId();

            SysUserRemarkExample example = new SysUserRemarkExample();
            example.createCriteria().andUser_idEqualTo(user_id);
            List<SysUserRemark> sysUserRemarks = sysUserRemarkMapper.selectByExample(example);

            return sysUserRemarks;

        }


        return null;
    }
}
