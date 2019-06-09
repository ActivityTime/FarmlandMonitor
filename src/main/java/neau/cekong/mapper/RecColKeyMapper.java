package neau.cekong.mapper;

import neau.cekong.pojo.RecColKey;
import neau.cekong.pojo.RecColKeyExample;
import org.springframework.stereotype.Repository;

/**
 * RecColKeyMapper继承基类
 */
@Repository
public interface RecColKeyMapper extends MyBatisBaseDao<RecColKey, Integer, RecColKeyExample> {
}