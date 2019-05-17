package neau.cekong.mapper;

import neau.cekong.pojo.SysUserRoleR;
import neau.cekong.pojo.SysUserRoleRExample;
import org.springframework.stereotype.Repository;

/**
 * SysUserRoleRMapper继承基类
 */
@Repository
public interface SysUserRoleRMapper extends MyBatisBaseDao<SysUserRoleR, Integer, SysUserRoleRExample> {
}