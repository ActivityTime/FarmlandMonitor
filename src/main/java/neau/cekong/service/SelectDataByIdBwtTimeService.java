package neau.cekong.service;

import neau.cekong.pojo.Result;
import java.util.Date;


public interface SelectDataByIdBwtTimeService {
    Result selData(int productId, Date start, Date end, String view);
}
