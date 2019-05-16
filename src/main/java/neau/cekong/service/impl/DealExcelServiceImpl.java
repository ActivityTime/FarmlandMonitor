package neau.cekong.service.impl;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import neau.cekong.mapper.DatWeatherMapper;
import neau.cekong.pojo.DatWeather;
import neau.cekong.pojo.DatWeatherExample;
import neau.cekong.service.DealExcelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class DealExcelServiceImpl implements DealExcelService {

    @Resource
    DatWeatherMapper datWeatherMapper;

    Long limit = 1000L;// 分页查询宽度

    Map<String, String> title = new LinkedHashMap<>();// 表头

    DateTimeFormatter df0 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    {
//        TA(℃)	 RH(%)	 PPM(ppm)	 WD(Deg)	 PRESS(hPa)	 DEPTH(mm)	 PAR(umol/㎡·S)	 RA(W/㎡)	 UV3(W/㎡)	 NET_R(W/㎡)	 TS1(℃)	 TS2(℃)	 TS3(℃)	 TS4(℃)	 TS5(℃)	 MS1(%)	 MS2(%)	 MS3(%)	 MS4(%)	 MS5(%)	 WS(m/s)	 RAIN(mm)

        title.put("retime", "时间日期");
        title.put("TA", "TA(℃)");
        title.put("RH", "RH(%)");
        title.put("PPM", "PPM(ppm)");
        title.put("WD", "WD(Deg)");
        title.put("PRESS", "PRESS(hPa)");
        title.put("DEPTH", "DEPTH(mm)");
        title.put("PAR", "PAR(umol/㎡·S)");
        title.put("RA", "RA(W/㎡)");
        title.put("UV3", "UV3(W/㎡)");
        title.put("NET_R", "NET_R(W/㎡)");
        title.put("TS1", "TS1(℃)");
        title.put("TS2", "TS2(℃)");
        title.put("TS3", "TS3(℃)");
        title.put("TS4", "TS4(℃)");
        title.put("TS5", "TS5(℃)");
        title.put("MS1", "MS1(%)");
        title.put("MS2", "MS2(%)");
        title.put("MS3", "MS3(%)");
        title.put("MS4", "MS4(%)");
        title.put("MS5", "MS5(%)");
        title.put("WS", "WS(m/s)");
        title.put("RAIN", "RAIN(mm)");
    }

    @Override
    public Boolean exportExcelDatWeather(LocalDateTime start, LocalDateTime end, OutputStream outputStream) throws IOException {

        /* 初始化查询条件 */
        DatWeatherExample btwXaX = new DatWeatherExample();
        btwXaX.setOrderByClause("retime DESC");
        btwXaX.createCriteria().andRetimeBetween(start, end);

        /* 查询条数 */
        long count = datWeatherMapper.countByExample(btwXaX);

        /* 初始化页数 */
        long page = 1;
        long pageMax = count / limit;
        if (count % limit > 0) {
            pageMax++;
        }

        /* 设置每次查询的limit */
        btwXaX.setLimit(limit.intValue());

        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter(true);

        /* 设定表头 */
        writer.setHeaderAlias(title);
        writer.setOnlyAlias(false);

        for (; page <= pageMax; page++) {
            /* 查询数据 */
            btwXaX.setOffset((page - 1) * limit);
            List<DatWeather> datWeathers = datWeatherMapper.selectByExample(btwXaX);

            /* 写入 */
            writer.write(datWeathers);
            for (int i = 0; i<datWeathers.size(); i++) {
                writer.writeCellValue(0, writer.getCurrentRow() - datWeathers.size() + i, df0.format(datWeathers.get(i).getRetime()));
            }
        }

        // 写出文件
        writer.autoSizeColumnAll();
        writer.flush(outputStream);
        // 关闭writer，释放内存
        writer.close();
        outputStream.close();

        return true;
    }
}
