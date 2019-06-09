package neau.cekong.service;

import neau.cekong.pojo.PageInfoVO;
import neau.cekong.pojo.RecordVO;

import java.util.List;

public interface RecordPageService {
    PageInfoVO<List<RecordVO>> selAllWithPage(Long page, Integer limit);
}
