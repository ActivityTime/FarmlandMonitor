package neau.cekong.service.impl;

import neau.cekong.mapper.RecRecordMapper;
import neau.cekong.mapper.RecRemarkMapper;
import neau.cekong.pojo.*;
import neau.cekong.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Resource
    RecRecordMapper recRecordMapper;

    @Resource
    RecRemarkMapper recRemarkMapper;

    @Override
    public List<RecordVO> selAllRecord() {

        List<RecRecord> recRecords = recRecordMapper.selectByExample(new RecRecordExample());

        List<RecordVO> records = new LinkedList<>();
        for (RecRecord recRecord : recRecords) {
            RecordVO recordVO = new RecordVO();
            recordVO.setRecord(recRecord);

            RecRemarkExample recRemarkExample = new RecRemarkExample();
            recRemarkExample.createCriteria().andRec_idEqualTo(recRecord.getRec_id());
            List<RecRemark> recRemarks = recRemarkMapper.selectByExample(recRemarkExample);
            recordVO.setRemarks(recRemarks);
        }

        return records;
    }

    @Override
    public Boolean insRecord(RecRecord record, List<RecRemark> remarks) {

        RecRecordExample recRecordExample = new RecRecordExample();
        recRecordExample.createCriteria().andRec_nameEqualTo(record.getRec_name());
        List<RecRecord> recRecords = recRecordMapper.selectByExample(recRecordExample);
        if (recRecords != null && recRecords.size() > 0) {
            return false;
        } else {
            int i = recRecordMapper.insertSelective(record);
            if (i == 0) {
                return false;
            }
        }

        recRecords = recRecordMapper.selectByExample(recRecordExample);
        int rec_id = recRecords.get(0).getRec_id();

        for (RecRemark remark : remarks) {
            remark.setRec_id(rec_id);
            recRemarkMapper.insertSelective(remark);
        }

        return true;
    }

    @Override
    public Boolean updRecordByName(RecRecord record, String name) {

        RecRecordExample recRecordExample = new RecRecordExample();
        recRecordExample.createCriteria().andRec_nameEqualTo(name);
        int i = recRecordMapper.updateByExampleSelective(record, recRecordExample);

        if (i > 0) return true;
        else return false;
    }

    @Override
    public Boolean delRecordByName(String name) {

        RecRecordExample recRecordExample = new RecRecordExample();
        recRecordExample.createCriteria().andRec_nameEqualTo(name);

        int i = recRecordMapper.deleteByExample(recRecordExample);

        if (i > 0) return true;
        else return false;
    }

    @Override
    public List<RecRemark> selRemarkByRecName(String recName) {

        RecRecordExample recRecordExample = new RecRecordExample();
        recRecordExample.createCriteria().andRec_nameEqualTo(recName);
        List<RecRecord> recRecords = recRecordMapper.selectByExample(recRecordExample);
        if (recRecords != null && recRecords.size() > 0) {

            RecRemarkExample recRemarkExample = new RecRemarkExample();
            recRemarkExample.createCriteria().andRec_idEqualTo(recRecords.get(0).getRec_id());
            List<RecRemark> recRemarks = recRemarkMapper.selectByExample(recRemarkExample);

            return recRemarks;

        } else {
            return null;
        }
    }

    @Override
    public Boolean addRemarkByRecName(String key, String value, String recName) {

        RecRecord recordByName = findRecordByName(recName);
        RecRemark remarkByRecNameAndKey = findRemarkByRecNameAndKey(recName, key);
        if (remarkByRecNameAndKey == null)
            if (recordByName != null) {
                RecRemark recRemark = new RecRemark();
                recRemark.setRec_id(recordByName.getRec_id());
                recRemark.setRec_remark_key(key);
                recRemark.setRec_remark_value(value);
                int i = recRemarkMapper.insertSelective(recRemark);
                if (i > 0)
                    return true;
            }

        return false;
    }

    @Override
    public Boolean updRemarkByRecName(String key, String value, String recName) {
        RecRemark remark = findRemarkByRecNameAndKey(recName, key);
        remark.setRec_remark_value(value);
        int i = recRemarkMapper.updateByPrimaryKeySelective(remark);

        if (i > 0) return true;
        else return false;
    }

    @Override
    public Boolean updRemarkNameByRecName(String key, String newKey, String recName) {
        RecRemark remark = findRemarkByRecNameAndKey(recName, key);
        remark.setRec_remark_key(newKey);
        int i = recRemarkMapper.updateByPrimaryKeySelective(remark);

        if (i > 0) return true;
        else return false;
    }

    @Override
    public Boolean delRemarkByRecName(String key, String recName) {
        RecRecord recordByName = findRecordByName(recName);
        if (recordByName != null) {

            RecRemarkExample recRemarkExample = new RecRemarkExample();
            recRemarkExample.createCriteria().andRec_remark_keyEqualTo(key).andRec_idEqualTo(recordByName.getRec_id());
            int i = recRemarkMapper.deleteByExample(recRemarkExample);

            if (i > 0)
                return true;
        }

        return null;
    }

    RecRecord findRecordByName(String name) {
        RecRecordExample recRecordExample = new RecRecordExample();
        recRecordExample.createCriteria().andRec_nameEqualTo(name);
        List<RecRecord> recRecords = recRecordMapper.selectByExample(recRecordExample);
        if (recRecords != null && recRecords.size() > 0) {
            return recRecords.get(0);
        } else {
            return null;
        }
    }

    RecRemark findRemarkByRecNameAndKey(String name, String key) {
        RecRecord recordByName = findRecordByName(name);
        if (recordByName != null) {
            int rec_id = recordByName.getRec_id();

            RecRemarkExample recRemarkExample = new RecRemarkExample();
            recRemarkExample.createCriteria().andRec_idEqualTo(rec_id).andRec_remark_keyEqualTo(key);
            List<RecRemark> recRemarks = recRemarkMapper.selectByExample(recRemarkExample);
            if (recRemarks != null && recRemarks.size() > 0) {
                return recRemarks.get(0);
            }
        }

        return null;
    }


}
