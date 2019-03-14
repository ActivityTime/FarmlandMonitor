package neau.cekong.service;

import neau.cekong.pojo.Result;

public interface SelectTempByPidLimitService {
    Result doService(int product_id, int limit);
}
