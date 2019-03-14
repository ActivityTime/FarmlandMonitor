package neau.cekong.service.impl;

import neau.cekong.mapper.TbHumidityMapper;
import neau.cekong.mapper.TbProductMapper;
import neau.cekong.mapper.TbTemperatureMapper;
import neau.cekong.pojo.Result;
import neau.cekong.pojo.TbHumidity;
import neau.cekong.pojo.TbProduct;
import neau.cekong.pojo.TbTemperature;
import neau.cekong.service.SelProductStatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class SelProductStatusServiceImpl implements SelProductStatService {
    @Resource
    TbProductMapper tbProductMapper;
    @Resource
    TbTemperatureMapper tbTemperatureMapper;
    @Resource
    TbHumidityMapper tbHumidityMapper;

    @Override
    public Result doService() {
        List<Map<String, String>> list = new LinkedList<>();
        List<TbProduct> lp = tbProductMapper.selAll();
        for (TbProduct tp : lp) {
            Map<String, String> map = new HashMap<>();
            map.put("pid", tp.getId().toString());
            map.put("productName", tp.getProductName());
            try {
                map.put("temperature", tbTemperatureMapper.selectTempByProductIDLimit(tp.getId(), 1).get(0).getTemperature().toString());
                map.put("humidity", tbHumidityMapper.selectHumidByProductIDLimit(tp.getId(), 1).get(0).getHumidity().toString());
            } catch (Exception e) {
                map.put("temperature", null);
                map.put("humidity", null);
            }
            list.add(map);
        }

        return new Result(list, "查询成功", 200);
    }
}
