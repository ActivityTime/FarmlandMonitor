package neau.cekong.mapper;

import neau.cekong.pojo.SysUserRemark;
import neau.cekong.pojo.SysUserRemarkExample;
import org.springframework.stereotype.Repository;

/**
 * SysUserRemarkMapper继承基类
 */
@Repository
public interface SysUserRemarkMapper extends MyBatisBaseDao<SysUserRemark, Integer, SysUserRemarkExample> {
}