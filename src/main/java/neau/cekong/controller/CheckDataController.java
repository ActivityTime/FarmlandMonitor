package neau.cekong.controller;

import neau.cekong.pojo.Result;
import neau.cekong.service.SelProductStatService;
import neau.cekong.service.SelectDataByIdBwtTimeService;
import neau.cekong.service.SelectHumidByPidLimitService;
import neau.cekong.service.SelectTempByPidLimitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("data/getter")
public class CheckDataController {
    @Resource
    SelectTempByPidLimitService selectTempByPidLimitService;
    @Resource
    SelectHumidByPidLimitService selectHumidByPidLimitService;
    @Resource
    SelProductStatService selProductStatService;
    @Resource
    SelectDataByIdBwtTimeService selectDataByIdBwtTimeService;

    @RequestMapping("temp/{productId}/{limit}")
    @ResponseBody
    public Result selectTemp(@PathVariable int productId, @PathVariable int limit) {
        return selectTempByPidLimitService.doService(productId, limit);
    }

    @RequestMapping("humid/{productId}/{limit}")
    @ResponseBody
    public Result selectHumid(@PathVariable int productId, @PathVariable int limit) {
        return selectHumidByPidLimitService.doService(productId, limit);
    }

    @RequestMapping("product/all")
    @ResponseBody
    public Result selectProSAll() {
        return selProductStatService.doService();
    }

    @RequestMapping("{view}/{productId}")
    @ResponseBody
    public Result selectData(@PathVariable String view,@PathVariable  int productId, Date start, Date end) {
        return selectDataByIdBwtTimeService.selData(productId, start, end, view);
    }

}
