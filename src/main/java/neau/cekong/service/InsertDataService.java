package neau.cekong.service;

import neau.cekong.pojo.Result;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface InsertDataService {
    Result insData(int productId, Date time, Object data, String viewName);
}
