package neau.cekong.controller;

import neau.cekong.service.DealExcelService;
import neau.cekong.util.MyExcelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("file")
public class FileDownLoadController {

    @Resource
    DealExcelService dealExcelService;

    DateTimeFormatter df0 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // http://localhost:8080/file/datWeather?start=2016-05-05 00:00:00&end=2016-06-05 00:00:00
    @RequestMapping("datWeather")
    void downloadDatWeatherExcel(String start, String end, HttpServletResponse response) throws IOException {
        LocalDateTime start0 = LocalDateTime.parse(start, df0);
        LocalDateTime end0 = LocalDateTime.parse(end, df0);

        // 设置下载头
        MyExcelUtils.setDownloadExcelHeader(response, start + "到" + end + ".xlsx");

        // 写出文件
        ServletOutputStream outputStream = response.getOutputStream();
        dealExcelService.exportExcelDatWeather(start0, end0, outputStream);

    }

}
