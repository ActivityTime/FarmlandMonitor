package neau.cekong.service.impl;

import neau.cekong.mapper.DataMapper;
import neau.cekong.pojo.Result;
import neau.cekong.service.SelectDataByIdBwtTimeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;


@Service
public class SelectDataByIdBwtTimeServiceImp implements SelectDataByIdBwtTimeService {
    @Resource
    DataMapper dataMapper;

    @Override
    public Result selData(int productId, Date start, Date end, String view) {
        return new Result(dataMapper.selByPidBwtTime(productId, start, end, view),"查询成功", 200);
    }
}
