package neau.cekong.mapper;

import neau.cekong.pojo.SysUser;
import neau.cekong.pojo.SysUserExample;
import org.springframework.stereotype.Repository;

/**
 * SysUserMapper继承基类
 */
@Repository
public interface SysUserMapper extends MyBatisBaseDao<SysUser, Long, SysUserExample> {
}