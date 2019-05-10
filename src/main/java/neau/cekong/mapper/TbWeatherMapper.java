package neau.cekong.mapper;

import java.time.LocalDateTime;
import neau.cekong.pojo.TbWeather;
import neau.cekong.pojo.TbWeatherExample;
import org.springframework.stereotype.Repository;

/**
 * TbWeatherMapper继承基类
 */
@Repository
public interface TbWeatherMapper extends MyBatisBaseDao<TbWeather, LocalDateTime, TbWeatherExample> {
}