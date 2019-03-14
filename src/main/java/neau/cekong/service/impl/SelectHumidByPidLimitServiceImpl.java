package neau.cekong.service.impl;

import neau.cekong.mapper.TbHumidityMapper;
import neau.cekong.pojo.Result;
import neau.cekong.service.SelectHumidByPidLimitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SelectHumidByPidLimitServiceImpl implements SelectHumidByPidLimitService {
    @Resource
    TbHumidityMapper tbHumidityMapper;

    @Override
    public Result doService(Integer productId, Integer limit) {
        return new Result(tbHumidityMapper.selectHumidByProductIDLimit(productId, limit), "查询成功", 200);
    }
}
