package neau.cekong.service;

import neau.cekong.pojo.PageInfoVO;
import neau.cekong.pojo.RecordTable;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

public interface RecordTableService {
    Set<String> selTableTitle();

    PageInfoVO<RecordTable> selAllWithPage(Long page, Integer limit);

    PageInfoVO<RecordTable> selTimeWithPage(LocalDateTime start, LocalDateTime end, Long page, Integer limit);

    PageInfoVO<RecordTable> selCuYearWithPage(Long page, Integer limit);

    boolean insert(LocalDateTime start, LocalDateTime end, Map<String,String> cols);

    boolean delete(String recName);

    boolean delete(Integer recId);

    boolean update(String recName, LocalDateTime start, LocalDateTime end, Map<String,String> cols);

    boolean update(Integer recId, LocalDateTime start, LocalDateTime end, Map<String,String> cols);
}
