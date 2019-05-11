package neau.cekong.service.impl;

import neau.cekong.mapper.DatWeatherMapper;
import neau.cekong.pojo.DatWeather;
import neau.cekong.pojo.DatWeatherExample;
import neau.cekong.service.DatWeatherService;
import neau.cekong.util.LocalDateTimeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DatWeatherServiceImpl implements DatWeatherService {

    @Resource
    DatWeatherMapper datWeatherMapper;


    @Override
    public List<DatWeather> findTops(Integer num) {
        /*前n条数据*/
        DatWeatherExample topX = new DatWeatherExample();
        topX.setOrderByClause("retime DESC");
        if(num == null) num = 48;
        topX.setLimit(num);

        return datWeatherMapper.selectByExample(topX);
    }

    @Override
    public List<DatWeather> findBetDates(LocalDateTime start, LocalDateTime end) {
        /*按日期查询*/
        DatWeatherExample btwXaX = new DatWeatherExample();
        btwXaX.setOrderByClause("retime DESC");
        if(start == null || end == null)
            btwXaX.createCriteria().andRetimeBetween(LocalDateTimeUtils.plus(LocalDateTime.now(), 1, ChronoUnit.WEEKS), LocalDateTime.now());
        else
            btwXaX.createCriteria().andRetimeBetween(start, end);
        return datWeatherMapper.selectByExample(btwXaX);
    }

}

