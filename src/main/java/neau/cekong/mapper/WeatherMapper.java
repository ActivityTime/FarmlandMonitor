package neau.cekong.mapper;

import java.time.LocalDateTime;
import neau.cekong.pojo.Weather;
import neau.cekong.pojo.WeatherExample;
import org.springframework.stereotype.Repository;

/**
 * WeatherMapper继承基类
 */
@Repository
public interface WeatherMapper extends MyBatisBaseDao<Weather, LocalDateTime, WeatherExample> {
}