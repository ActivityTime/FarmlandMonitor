package neau.cekong.service;

import neau.cekong.pojo.DatWeather;

import java.time.LocalDateTime;
import java.util.List;

public interface DatWeatherService {

    List<DatWeather> findTops(Integer num);

    List<DatWeather> findBetDates(LocalDateTime start, LocalDateTime end);

}
