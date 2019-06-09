package neau.cekong.mapper;

import neau.cekong.pojo.RecColVal;
import neau.cekong.pojo.RecColValExample;
import org.springframework.stereotype.Repository;

/**
 * RecColValMapper继承基类
 */
@Repository
public interface RecColValMapper extends MyBatisBaseDao<RecColVal, Integer, RecColValExample> {
}