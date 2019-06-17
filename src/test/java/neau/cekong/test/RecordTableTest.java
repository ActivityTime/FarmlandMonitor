package neau.cekong.test;

import neau.cekong.pojo.PageInfoVO;
import neau.cekong.pojo.RecordTable;
import neau.cekong.service.RecordTableService;

import javax.annotation.Resource;
import java.util.HashMap;

public class RecordTableTest extends BaseJunit4Test {

    @Resource
    RecordTableService recordTableService;

    @Override
    public void test() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("种类", "地瓜");
        map.put("品种", "地瓜1号");
  //      recordTableService.update(5, LocalDateTime.now(), LocalDateTime.now(), map);

        PageInfoVO<RecordTable> recordTablePageInfoVO = recordTableService.selCuYearWithPage((long) 1, 10);
        System.out.println(recordTablePageInfoVO);
    }

}
