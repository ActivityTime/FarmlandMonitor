package neau.cekong.service;

import neau.cekong.pojo.Result;

public interface SelectHumidByPidLimitService {
    Result doService(Integer productId, Integer limit);
}
