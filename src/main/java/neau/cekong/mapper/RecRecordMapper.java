package neau.cekong.mapper;

import neau.cekong.pojo.RecRecord;
import neau.cekong.pojo.RecRecordExample;
import org.springframework.stereotype.Repository;

/**
 * RecRecordMapper继承基类
 */
@Repository
public interface RecRecordMapper extends MyBatisBaseDao<RecRecord, Integer, RecRecordExample> {
}