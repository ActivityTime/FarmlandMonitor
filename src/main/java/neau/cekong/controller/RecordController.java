package neau.cekong.controller;

import neau.cekong.pojo.RecRecord;
import neau.cekong.pojo.RecRemark;
import neau.cekong.pojo.Result;
import neau.cekong.service.RecordService;
import neau.cekong.util.JsonTranstor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("record")
public class RecordController {
    @Resource
    RecordService recordService;

    DateTimeFormatter df0 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @RequestMapping("ins")
    @ResponseBody
    Result insRec(String name, String character, String start, String end, String remarks){

        RecRecord recRecord = new RecRecord();
        recRecord.setRec_name(name);
        recRecord.setRec_character_name(character);
        recRecord.setRec_time_start(LocalDateTime.parse(start, df0));
        recRecord.setRec_time_end(LocalDateTime.parse(end, df0));

        Map<String, String> maps = JsonTranstor.transToMap(remarks);

        List<RecRemark> remarkList = new LinkedList<>();
        for (Map.Entry<String, String> entry : maps.entrySet()) {
            RecRemark recRemark = new RecRemark();
            recRemark.setRec_remark_key(entry.getKey());
            recRemark.setRec_remark_value(entry.getValue());
            remarkList.add(recRemark);
        }

        Boolean b = recordService.insRecord(recRecord, remarkList);

        if(b){
            return new Result(true, "创建成功", 200);
        }
        return new Result(b, "创建失败", 500);
    }
}
