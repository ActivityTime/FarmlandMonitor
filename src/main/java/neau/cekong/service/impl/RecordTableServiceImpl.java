package neau.cekong.service.impl;

import neau.cekong.mapper.RecColKeyMapper;
import neau.cekong.mapper.RecColValMapper;
import neau.cekong.mapper.RecRecordMapper;
import neau.cekong.pojo.*;
import neau.cekong.service.RecordTableService;
import neau.cekong.util.LocalDateTimeUtils;
import neau.cekong.util.UUIDUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class RecordTableServiceImpl implements RecordTableService {

    @Resource
    RecRecordMapper recRecordMapper;

    @Resource
    RecColKeyMapper recColKeyMapper;

    @Resource
    RecColValMapper recColValMapper;

    @Override
    public Set<String> selTableTitle() {

        LinkedHashSet<String> keySet = new LinkedHashSet<>();

        List<RecColKey> recColKeys = recColKeyMapper.selectByExample(new RecColKeyExample());
        if (recColKeys != null)
            for (RecColKey recColKey : recColKeys) {
                keySet.add(recColKey.getName());
            }

        return keySet;
    }

    @Override
    public PageInfoVO<RecordTable> selAllWithPage(Long page, Integer limit) {

        long l = recRecordMapper.countByExample(new RecRecordExample());
        List<RecRecord> recRecords = recRecordMapper.selectByExample(buildRecRecordExamplePage(page, limit));

        RecordTable recordTable = buildRecordTable(recRecords);

        return new PageInfoVO<>(l, recordTable);
    }

    @Override
    public PageInfoVO<RecordTable> selTimeWithPage(LocalDateTime start, LocalDateTime end, Long page, Integer limit) {

        RecRecordExample recRecordExample = new RecRecordExample();
        recRecordExample.or().andRec_time_startBetween(start, end);
        recRecordExample.or().andRec_time_endBetween(start, end);
        long l = recRecordMapper.countByExample(recRecordExample);

        addRecRecordExamplePage(recRecordExample, page, limit);
        List<RecRecord> recRecords = recRecordMapper.selectByExample(recRecordExample);

        RecordTable recordTable = buildRecordTable(recRecords);

        return new PageInfoVO<>(l, recordTable);
    }

    @Override
    public PageInfoVO<RecordTable> selCuYearWithPage(Long page, Integer limit) {

        return selTimeWithPage(
                LocalDateTimeUtils.getYearStart(LocalDateTime.now()),
                LocalDateTimeUtils.getYearEnd(LocalDateTime.now()),
                page,
                limit
        );

    }

    @Override
    public RecordTableRow selById(Integer recId) {
        RecRecord recRecord = recRecordMapper.selectByPrimaryKey(recId);
        return buildRecordTableRow(recRecord);
    }

    @Override
    public boolean insert(LocalDateTime start, LocalDateTime end, Map<String, String> cols) {

        // 插入记录
        RecRecord recRecord = new RecRecord();
        recRecord.setRec_time_start(start);
        recRecord.setRec_time_end(end);
        recRecord.setRec_name(UUIDUtils.getUUID());
        int i = recRecordMapper.insertSelective(recRecord);
        if (i == 0) return false;
        RecRecordExample recRecordExample = new RecRecordExample();
        recRecordExample.createCriteria().andRec_nameEqualTo(recRecord.getRec_name());
        List<RecRecord> recRecords = recRecordMapper.selectByExample(recRecordExample);
        Integer rec_id = null;
        if (recRecords != null && recRecords.size() > 0) {
            rec_id = recRecords.get(0).getRec_id();
        } else {
            return false;
        }

        // 获取列名
        Map<String, Integer> colKeysNameIdMap = getColKeysNameIdMap();

        // 插入列值
        for (Map.Entry<String, String> entry : cols.entrySet()) {
            RecColVal recColVal = new RecColVal();
            recColVal.setKey_id(colKeysNameIdMap.get(entry.getKey()));
            if (recColVal.getKey_id() == null) continue;
            recColVal.setRec_id(rec_id);
            recColVal.setValue(entry.getValue().toString());
            recColValMapper.insertSelective(recColVal);
        }

        return true;
    }

    Map<String, Integer> getColKeysNameIdMap() {
        LinkedHashMap<String, Integer> colKeysNameIdMap = new LinkedHashMap<>();
        List<RecColKey> recColKeys = recColKeyMapper.selectByExample(new RecColKeyExample());
        if (recColKeys != null)
            for (RecColKey recColKey : recColKeys) {
                colKeysNameIdMap.put(recColKey.getName(), recColKey.getId());
            }

        return colKeysNameIdMap;
    }

    @Override
    public boolean delete(String recName) {
        RecRecordExample recRecordExample = new RecRecordExample();
        recRecordExample.createCriteria().andRec_nameEqualTo(recName);

        int i = recRecordMapper.deleteByExample(recRecordExample);

        if (i > 0) return true;
        else return false;
    }

    @Override
    public boolean delete(Integer recId) {
        int i = recRecordMapper.deleteByPrimaryKey(recId);

        if (i > 0) return true;
        else return false;
    }

    @Override
    public boolean update(String recName, LocalDateTime start, LocalDateTime end, Map<String, String> cols) {

        RecRecordExample example = new RecRecordExample();
        example.createCriteria().andRec_nameEqualTo(recName);
        List<RecRecord> recRecords = recRecordMapper.selectByExample(example);
        if (recRecords != null && recRecords.size() > 0) {
            return update(recRecords.get(0).getRec_id(), start, end, cols);
        }

        return false;
    }

    @Override
    public boolean update(Integer recId, LocalDateTime start, LocalDateTime end, Map<String, String> cols) {

        if (recId == null || recRecordMapper.selectByPrimaryKey(recId) == null) return false;

        // 修改日期
        RecRecord recRecord = new RecRecord();
        recRecord.setRec_id(recId);
        recRecord.setRec_time_start(start);
        recRecord.setRec_time_end(end);
        recRecordMapper.updateByPrimaryKeySelective(recRecord);

        // 获取列名
        Map<String, Integer> colKeysNameIdMap = getColKeysNameIdMap();

        // 修改列值
        if (cols != null)
            for (Map.Entry<String, String> entry : cols.entrySet()) {

                Integer key_id = colKeysNameIdMap.get(entry.getKey());
                if (key_id == null) continue;

                RecColVal recColVal = new RecColVal();
                recColVal.setValue(entry.getValue().toString());

                RecColValExample recColValExample = new RecColValExample();
                recColValExample.createCriteria().andRec_idEqualTo(recId).andKey_idEqualTo(key_id);
                List<RecColVal> recColVals = recColValMapper.selectByExample(recColValExample);
                if (recColVals != null && recColVals.size() > 0) {
                    recColValMapper.updateByExampleSelective(recColVal, recColValExample);
                } else {
                    recColVal.setRec_id(recId);
                    recColVal.setKey_id(key_id);
                    recColValMapper.insertSelective(recColVal);
                }


            }

        return true;
    }

    //----------------------------------------------------
    RecRecordExample addRecRecordExamplePage(RecRecordExample recRecordExample, Long page, Integer limit) {
        recRecordExample.setLimit(limit);
        recRecordExample.setOffset((page - 1) * limit);
        recRecordExample.setOrderByClause("rec_time_start");
        return recRecordExample;
    }

    RecRecordExample buildRecRecordExamplePage(Long page, Integer limit) {
        RecRecordExample recRecordExample = new RecRecordExample();
        addRecRecordExamplePage(recRecordExample, page, limit);
        return recRecordExample;
    }

    //----------------------------------------------------
    RecordTable buildRecordTable(List<RecRecord> recRecords) {
        return buildRecordTable(recRecords, null);
    }

    RecordTable buildRecordTable(List<RecRecord> recRecords, List<RecColKey> recColKeys) {
        RecordTable recordTable = new RecordTable();

        if (recColKeys == null) recColKeys = recColKeyMapper.selectByExample(new RecColKeyExample());

        for (RecRecord recRecord : recRecords) {
            recordTable.add(buildRecordTableRow(recRecord, recColKeys));
        }

        return recordTable;
    }

    RecordTableRow buildRecordTableRow(RecRecord recRecord, List<RecColKey> recColKeys) {
        if (recColKeys == null) recColKeys = recColKeyMapper.selectByExample(new RecColKeyExample());
        Map<String, Object> cols = selColsByRecId(recRecord.getRec_id(), recColKeys);
        return new RecordTableRow(recRecord.getRec_id(), recRecord.getRec_name(), recRecord.getRec_time_start(), recRecord.getRec_time_end(), cols.keySet(), cols);
    }

    RecordTableRow buildRecordTableRow(RecRecord recRecord) {
        return buildRecordTableRow(recRecord, null);
    }

    //----------------------------------------------------
    Map<String, Object> selColsByRecId(Integer recId) {
        return selColsByRecId(recId, null);
    }

    Map<String, Object> selColsByRecId(Integer recId, List<RecColKey> recColKeys) {

        Map<String, Object> cols = new LinkedHashMap<>();
        if (recId == null) return cols;

        RecColValExample recColValExample = new RecColValExample();
        recColValExample.createCriteria().andRec_idEqualTo(recId);
        List<RecColVal> recColVals = recColValMapper.selectByExample(recColValExample);
        if (recColKeys == null) recColKeys = recColKeyMapper.selectByExample(new RecColKeyExample());
        if (recColKeys != null)
            for (RecColKey recColKey : recColKeys) {
                cols.put(recColKey.getName(), null);
                for (RecColVal recColVal : recColVals) {
                    if (recColVal.getKey_id() == recColKey.getId()) {
                        cols.put(recColKey.getName(), recColVal.getValue());
                    }
                }
            }

        return cols;
    }


}
