package neau.cekong.controller;

import neau.cekong.pojo.DatWeather;
import neau.cekong.service.DatWeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("datWeather")
public class DatWeatherController {

    @Resource
    DatWeatherService datWeatherService;

    DateTimeFormatter df0 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    @RequestMapping("load/top")
    @ResponseBody
    List<DatWeather> loadTops(int num) {
        return datWeatherService.findTops(num);
    }

    @RequestMapping("load/date")
    @ResponseBody
    List<DatWeather> loadBtwDate(String start, String end) {
        if (start == null || end == null)
            return datWeatherService.findBetDates(null, null);
        else
            return datWeatherService.findBetDates(LocalDateTime.parse(start, df0), LocalDateTime.parse(end, df0));
    }
}
