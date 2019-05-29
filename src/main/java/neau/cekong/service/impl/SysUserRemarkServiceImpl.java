package neau.cekong.service.impl;

import neau.cekong.mapper.SysUserMapper;
import neau.cekong.mapper.SysUserRemarkMapper;
import neau.cekong.pojo.*;
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

    @Override
    public Result addRemarkByUsername(String username, String remarkname, String remark) {

        if (username == null) return null;

        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);

        if (sysUsers != null && sysUsers.size() > 0) {
            Long user_id = sysUsers.get(0).getId();

            SysUserRemarkExample example = new SysUserRemarkExample();
            example.createCriteria().andMarknameEqualTo(remarkname).andUser_idEqualTo(user_id);
            List<SysUserRemark> sysUserRemarks = sysUserRemarkMapper.selectByExample(example);
            if (sysUserRemarks != null && sysUserRemarks.size() > 0) {
                return new Result(null, "备注名已存在", 500);
            } else {
                SysUserRemark sysUserRemark = new SysUserRemark();
                sysUserRemark.setMarkname(remarkname);
                sysUserRemark.setRemarks(remark);
                sysUserRemark.setUser_id(user_id);
                sysUserRemarkMapper.insertSelective(sysUserRemark);
                return new Result(null, "备注创建成功", 200);
            }

        } else


            return new Result(null, "用户不存在", 500);
    }

    @Override
    public Result altRemarkByUsername(String username, String remarkname, String newMarkname, String remark) {
        if (username == null) return null;

        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria;
        criteria = sysUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);

        if (sysUsers != null && sysUsers.size() > 0) {
            Long user_id = sysUsers.get(0).getId();

            SysUserRemarkExample example = new SysUserRemarkExample();
            SysUserRemarkExample.Criteria criteria1 = example.createCriteria().andMarknameEqualTo(remarkname);
            criteria1.andUser_idEqualTo(user_id);
            List<SysUserRemark> sysUserRemarks = sysUserRemarkMapper.selectByExample(example);
            if (sysUserRemarks != null && sysUserRemarks.size() > 0) {

                Integer mark_id = sysUserRemarks.get(0).getId();

                SysUserRemark sysUserRemark = new SysUserRemark();
                sysUserRemark.setId(mark_id);
                if (newMarkname != null && !newMarkname.equals("")) {

                    if (!newMarkname.equals(remarkname)) {

                        SysUserRemarkExample example2 = new SysUserRemarkExample();
                        example2.createCriteria().andUser_idEqualTo(user_id).andMarknameEqualTo(newMarkname);
                        List<SysUserRemark> sysUserRemarks2 = sysUserRemarkMapper.selectByExample(example2);
                        if (sysUserRemarks2 != null && sysUserRemarks2.size() > 0) {
                            return new Result(null, "备注修改失败：备注名已存在", 500);
                        } else {
                            sysUserRemark.setMarkname(newMarkname);
                        }
                    } else {
                        sysUserRemark.setMarkname(newMarkname);
                    }
                }
                sysUserRemark.setRemarks(remark);

                sysUserRemarkMapper.updateByPrimaryKeySelective(sysUserRemark);

                return new Result(null, "备注修改成功", 200);
            } else {

                return new Result(null, "备注修改失败：备注名不存在", 500);
            }

        } else


            return new Result(null, "用户不存在", 500);
    }

    @Override
    public Result delRemarkByUsername(String username, String remarkname) {
        if (username == null) return new Result(null, "用户名为空", 500);
        ;

        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        System.out.print("");
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);

        if (sysUsers != null && sysUsers.size() > 0) {
            Long user_id = sysUsers.get(0).getId();

            SysUserRemarkExample example = new SysUserRemarkExample();
            example.createCriteria().andMarknameEqualTo(remarkname).andUser_idEqualTo(user_id);
            System.out.print("");
            List<SysUserRemark> sysUserRemarks = sysUserRemarkMapper.selectByExample(example);
            if (sysUserRemarks != null && sysUserRemarks.size() > 0) {
                sysUserRemarkMapper.deleteByPrimaryKey(sysUserRemarks.get(0).getId());
                return new Result(null, "备注删除成功", 200);
            } else {
                return new Result(null, "备注名不存在", 500);
            }

        } else


            return new Result(null, "用户不存在", 500);
    }
}
