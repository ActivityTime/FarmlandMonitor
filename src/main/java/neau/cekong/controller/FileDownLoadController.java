package neau.cekong.controller;

import neau.cekong.pojo.Result;
import neau.cekong.service.DealExcelService;
import neau.cekong.util.MyExcelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("file")
public class FileDownLoadController {

    @Resource
    DealExcelService dealExcelService;

    DateTimeFormatter df0 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH：mm：ss");

    // http://localhost:8080/file/datWeather?start=2016-05-05 00:00:00&end=2016-06-05 00:00:00
    @RequestMapping("datWeather/direct")
    void downloadDatWeatherExcel(String start, String end, HttpServletResponse response) throws IOException {
        LocalDateTime start0 = LocalDateTime.parse(start, df0);
        LocalDateTime end0 = LocalDateTime.parse(end, df0);

        // 设置下载头
        MyExcelUtils.setDownloadExcelHeader(response, "气象数据：" + start0.format(df1) + "到" + end0.format(df1) + ".xlsx");

        // 写出文件
        ServletOutputStream outputStream = response.getOutputStream();
        dealExcelService.exportExcelDatWeather(start0, end0, outputStream);

    }

    @RequestMapping("datWeather")
    @ResponseBody
    public Result makeDatWeatherExcel(String start, String end) {

        LocalDateTime start0 = LocalDateTime.parse(start, df0);
        LocalDateTime end0 = LocalDateTime.parse(end, df0);

        return dealExcelService.makeExcelDatWeather(start0, end0);
    }

    @RequestMapping("datWeather/check")
    @ResponseBody
    public Result checkDatWeatherExcel(String uuid) {
        return dealExcelService.checkExcelDatWeather(uuid);
    }

    @RequestMapping("datWeather/download")
    @ResponseBody
    public Object downDatWeatherExcel(String uuid, HttpServletResponse response) throws IOException {
        Result<File> result = dealExcelService.exportExcelDatWeather(uuid);
        ServletOutputStream outputStream = response.getOutputStream();
        if (result.getStatus() == 200) {
            // 设置下载头
            MyExcelUtils.setDownloadExcelHeader(response, result.getData().getName());
            Files.copy(result.getData().toPath(), outputStream);
            outputStream.close();
        } else {
            System.out.println(result.getMsg());
            return result.getMsg();
        }
        return null;
    }

}
