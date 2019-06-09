package neau.cekong.service;

import neau.cekong.pojo.Result;

import java.util.Map;

public interface RecordViewService {
    Result insRecordWithRemarks(String name, String character, String start, String end, Map<String, String> remarks);

    Result updRecord(String name, String character, String start, String end, String newName);

    Result updRemarkByRecName(String key, String value, String newKey, String recName);
}
