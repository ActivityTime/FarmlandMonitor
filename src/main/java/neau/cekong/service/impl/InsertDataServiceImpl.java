package neau.cekong.service.impl;

import neau.cekong.mapper.DataMapper;
import neau.cekong.pojo.Result;
import neau.cekong.service.InsertDataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class InsertDataServiceImpl implements InsertDataService {
    @Resource
    DataMapper dataMapper;

    @Override
    public Result insData(int productId, Date time, Object data, String viewName) {

        if(time == null){
            time = new Date();
        }

        int num = dataMapper.insByPid(productId, time, data, viewName);

        return new Result(num, "插入成功", 200);
    }
}
