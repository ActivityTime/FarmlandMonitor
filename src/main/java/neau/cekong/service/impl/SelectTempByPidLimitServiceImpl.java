package neau.cekong.service.impl;

import neau.cekong.mapper.TbTemperatureMapper;
import neau.cekong.pojo.Result;
import neau.cekong.pojo.TbTemperature;
import neau.cekong.service.SelectTempByPidLimitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SelectTempByPidLimitServiceImpl implements SelectTempByPidLimitService {
    @Resource
    TbTemperatureMapper tbTemperatureMapper;


    @Override
    public Result doService(int product_id, int limit) {
        List<TbTemperature> list = tbTemperatureMapper.selectTempByProductIDLimit(product_id, limit);
        Result result = new Result(list,"查询成功",200);

        return result;
    }
}
