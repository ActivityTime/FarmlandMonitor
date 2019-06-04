package neau.cekong.mapper;

import neau.cekong.pojo.RecRemark;
import neau.cekong.pojo.RecRemarkExample;
import org.springframework.stereotype.Repository;

/**
 * RecRemarkMapper继承基类
 */
@Repository
public interface RecRemarkMapper extends MyBatisBaseDao<RecRemark, Integer, RecRemarkExample> {
}