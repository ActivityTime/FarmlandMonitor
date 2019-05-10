package neau.cekong.mapper;

import java.time.LocalDateTime;
import neau.cekong.pojo.DatWeather;
import neau.cekong.pojo.DatWeatherExample;
import org.springframework.stereotype.Repository;

/**
 * DatWeatherMapper继承基类
 */
@Repository
public interface DatWeatherMapper extends MyBatisBaseDao<DatWeather, LocalDateTime, DatWeatherExample> {
}