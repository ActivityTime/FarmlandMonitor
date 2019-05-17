package neau.cekong.mapper;

import neau.cekong.pojo.SysFunc;
import neau.cekong.pojo.SysFuncExample;
import org.springframework.stereotype.Repository;

/**
 * SysFuncMapper继承基类
 */
@Repository
public interface SysFuncMapper extends MyBatisBaseDao<SysFunc, Integer, SysFuncExample> {
}