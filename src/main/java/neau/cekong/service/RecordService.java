package neau.cekong.service;

import neau.cekong.pojo.RecRecord;
import neau.cekong.pojo.RecRemark;
import neau.cekong.pojo.RecordVO;

import java.util.List;

public interface RecordService {
    List<RecordVO> selAllRecord();

    RecRecord findRecordByName(String name);

    Boolean insRecord(RecRecord record, List<RecRemark> remarks);

    Boolean updRecordByName(RecRecord record, String name);

    Boolean delRecordByName(String name);

    List<RecRemark> selRemarkByRecName(String recName);

    Boolean addRemarkByRecName(String key, String value,String recName);

    Boolean updRemarkByRecName(String key, String value,String recName);

    Boolean updRemarkNameByRecName(String key, String newKey,String recName);

    Boolean delRemarkByRecName(String key,String recName);
}
