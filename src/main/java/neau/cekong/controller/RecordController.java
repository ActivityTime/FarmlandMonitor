package neau.cekong.controller;

import neau.cekong.pojo.*;
import neau.cekong.service.RecordPageService;
import neau.cekong.service.RecordService;
import neau.cekong.service.RecordTableService;
import neau.cekong.service.RecordViewService;
import neau.cekong.util.JsonTranstor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("record")
public class RecordController {
    @Resource
    RecordService recordService;

    @Resource
    RecordPageService recordPageService;

    @Resource
    RecordViewService recordViewService;

    @Resource
    RecordTableService recordTableService;

    DateTimeFormatter df0 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Record ------------------------------------------------------------------------------------
    @RequestMapping("ins")
    @ResponseBody
    Result insRec(String name, String character, String start, String end, String remarks) {

        Map<String, String> maps = JsonTranstor.transToMap(remarks);

        return recordViewService.insRecordWithRemarks(name, character, start, end, maps);
    }

    @RequestMapping("sel/all")
    @ResponseBody
    Result selAll() {
        return new Result(recordService.selAllRecord(), "查询成功", 200);
    }

    @RequestMapping("sel/all/page")
    @ResponseBody
    Result selAllWithPage(Long page, Integer limit) {
        return new Result(recordPageService.selAllWithPage(page, limit), "查询成功", 200);
    }

    @RequestMapping("sel")
    @ResponseBody
    Result selRecord(String recName) {

        RecRecord recordByName = recordService.findRecordByName(recName);
        if (recordByName != null)
            return new Result(recordByName, "查询成功", 200);
        else
            return new Result(false, "查询失败", 500);
    }

    @RequestMapping("alt")
    @ResponseBody
    Result altRecord(String name, String character, String start, String end, String newName) {

        Result result = recordViewService.updRecord(name, character, start, end, newName);

        return result;
    }

    // Remark -----------------------------------------------------------------------
    @RequestMapping("remark/sel")
    @ResponseBody
    Result selRemark(String recName) {

        List<RecRemark> remarks = recordService.selRemarkByRecName(recName);
        return new Result(remarks, "查询成功", 200);
    }

    @RequestMapping("remark/add")
    @ResponseBody
    Result addRemark(String recName, String key, String value) {
        Boolean b = recordService.addRemarkByRecName(key, value, recName);
        if (b)
            return new Result(true, "添加成功", 200);
        else
            return new Result(false, "添加失败", 500);
    }

    @RequestMapping("remark/alt")
    @ResponseBody
    Result altRemark(String recName, String key, String value, String newKey) {

        return recordViewService.updRemarkByRecName(key, value, newKey, recName);
    }

    @RequestMapping("remark/del")
    @ResponseBody
    Result delRemark(String recName, String key) {

        Boolean b = recordService.delRemarkByRecName(key, recName);
        if (b)
            return new Result(true, "删除成功", 200);
        else
            return new Result(false, "删除失败", 500);
    }

    // Table ----------------------------------------------------------------------
    @RequestMapping("table/ins")
    @ResponseBody
    Result insRecTab(String start, String end, String cols) {

        Map<String, String> maps = JsonTranstor.transToMap(cols);

        boolean b = recordTableService.insert(LocalDateTime.parse(start, df0), LocalDateTime.parse(end, df0), maps);
        if (b)
            return new Result(true, "创建成功", 200);
        else
            return new Result(false, "创建失败", 500);
    }

    @RequestMapping("table/del")
    @ResponseBody
    Result delRecTab(Integer recId) {

        boolean b = recordTableService.delete(recId);
        if (b)
            return new Result(true, "删除成功", 200);
        else
            return new Result(false, "删除失败", 500);
    }

    @RequestMapping("table/alt")
    @ResponseBody
    Result altRecTab(Integer recId, String start, String end, String cols) {

        Map<String, String> maps = JsonTranstor.transToMap(cols);

        LocalDateTime timeStart = start == null ? null : LocalDateTime.parse(start, df0);
        LocalDateTime timeEnd = end == null ? null : LocalDateTime.parse(end, df0);
        boolean b = recordTableService.update(recId, timeStart, timeEnd, maps);
        if (b)
            return new Result(true, "修改成功", 200);
        else
            return new Result(false, "修改失败", 500);
    }

    @RequestMapping("table/sel/page/all")
    @ResponseBody
    Result selAllTablePage(Long page, Integer limit) {

        PageInfoVO<RecordTable> recordTablePageInfoVO = recordTableService.selAllWithPage(page, limit);

        return new Result(recordTablePageInfoVO, "查询成功", 200);
    }

    @RequestMapping("table/sel/page/time")
    @ResponseBody
    Result selTimeTablePage(String start, String end, Long page, Integer limit) {

        LocalDateTime timeEnd = end == null ? null : LocalDateTime.parse(end, df0);
        LocalDateTime timeStart = (start == null) ? null : LocalDateTime.parse(start, df0);
        PageInfoVO<RecordTable> recordTablePageInfoVO = recordTableService.selTimeWithPage(timeStart, timeEnd, page, limit);

        return new Result(recordTablePageInfoVO, "查询成功", 200);
    }

    @RequestMapping("table/sel/page/cuYear")
    @ResponseBody
    Result selCuYearTablePage(Long page, Integer limit) {

        PageInfoVO<RecordTable> recordTablePageInfoVO = recordTableService.selCuYearWithPage(page, limit);

        return new Result(recordTablePageInfoVO, "查询成功", 200);
    }

    @RequestMapping("table/title")
    @ResponseBody
    Result getTitle() {

        Set<String> title = recordTableService.selTableTitle();

        return new Result(title, "查询成功", 200);
    }

    @RequestMapping("table/row")
    @ResponseBody
    Result selRecTabRow(Integer recId) {

        RecordTableRow recordTableRow = recordTableService.selById(recId);
        if (recordTableRow != null)
            return new Result(recordTableRow, "查询成功", 200);
        else
            return new Result(false, "查询失败", 500);
    }
}
