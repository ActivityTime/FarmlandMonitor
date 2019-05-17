package neau.cekong.mapper;

import neau.cekong.pojo.SysRole;
import neau.cekong.pojo.SysRoleExample;
import org.springframework.stereotype.Repository;

/**
 * SysRoleMapper继承基类
 */
@Repository
public interface SysRoleMapper extends MyBatisBaseDao<SysRole, Integer, SysRoleExample> {
}