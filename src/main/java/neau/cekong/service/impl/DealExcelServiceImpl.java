package neau.cekong.service.impl;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import neau.cekong.mapper.DatWeatherMapper;
import neau.cekong.pojo.DatWeather;
import neau.cekong.pojo.DatWeatherExample;
import neau.cekong.pojo.DatWeatherVO;
import neau.cekong.pojo.Result;
import neau.cekong.service.DealExcelService;
import neau.cekong.service.business.DownloadManager;
import neau.cekong.service.business.FileDealingStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class DealExcelServiceImpl implements DealExcelService {

    @Resource
    DatWeatherMapper datWeatherMapper;

    @Autowired
    DownloadManager downloadManager;

    Long limit = 500L;// 分页查询宽度

    Map<String, String> title = new LinkedHashMap<>();// 表头

    DateTimeFormatter df0 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    int firstColumnWidth = 19;
    int otherColumnWidth = 14;

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

    /**
     * 获取ExcelWtiter
     *
     * @param start
     * @param end
     * @return ExcelWriter
     */
    private ExcelWriter getExcelWriter(LocalDateTime start, LocalDateTime end) {
        return getExcelWriter(start, end, new FileDealingStat());
    }

    /**
     * 获取ExcelWtiter，记录生成状态
     *
     * @param start
     * @param end
     * @param fileDealingStat
     * @return ExcelWriter
     */
    private ExcelWriter getExcelWriter(LocalDateTime start, LocalDateTime end, FileDealingStat fileDealingStat) {

        /* 初始化查询条件 */
        DatWeatherExample btwXaX = new DatWeatherExample();
        btwXaX.setOrderByClause("retime DESC");
        btwXaX.createCriteria().andRetimeBetween(start, end);

        /* 查询条数 */
        long count = datWeatherMapper.countByExample(btwXaX);
        fileDealingStat.setNum((int) count);

        /* 初始化页数 */
        long page = 1;
        long pageMax = count / limit;
        if (count % limit > 0) {
            pageMax++;
        }

        /* 设置每次查询的limit */
        btwXaX.setLimit(limit.intValue());

        //通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getBigWriter();

        /* 设定表头 */
        writer.setHeaderAlias(title);
        writer.setOnlyAlias(false);
        writer.setColumnWidth(0, firstColumnWidth);
        IntStream.range(1, title.size()).forEach(i -> writer.setColumnWidth(i, otherColumnWidth));

        /* 写数据 */
        for (; page <= pageMax; page++) {
            /* 查询数据 */
            btwXaX.setOffset((page - 1) * limit);
            List<DatWeather> datWeathers = datWeatherMapper.selectByExample(btwXaX);
            fileDealingStat.addNow(limit.intValue(), false);// 无法到达 100% 未写出

            /* 整理内容 */
            List<DatWeatherVO> collect = datWeathers.stream().map(DatWeatherVO::new).collect(Collectors.toList());

            /* 写入 */
            writer.write(collect);
        }

        // 返回
        fileDealingStat.finish();
        return writer;
    }

    @Override
    public Boolean exportExcelDatWeather(LocalDateTime start, LocalDateTime end, OutputStream outputStream) throws IOException {

        // 获取excel
        ExcelWriter writer = getExcelWriter(start, end);

        // 写出文件
        writer.flush(outputStream);


        // 关闭writer，释放内存
        writer.close();
        outputStream.close();

        return true;
    }

    @Override
    public Result exportExcelDatWeather(String uuid) {

        Result result = new Result();
        FileDealingStat fileDealingStat = downloadManager.getFileDealingStat(uuid);

        if (fileDealingStat != null && fileDealingStat.getFile().exists()) {
            if (fileDealingStat.isFinish()) {
                File file = fileDealingStat.getFile();
                if (file.canRead()) {
                    result.setData(file);
                    result.setMsg("可以下载");
                    result.setStatus(200);
                } else {
                    result.setMsg("文件被占用，请稍后再试");
                    result.setStatus(500);
                }
            } else {
                result.setMsg("文件尚未生成完毕");
                result.setStatus(500);
            }
        } else {
            result.setMsg("文件不存在");
            result.setStatus(500);
        }

        return result;
    }

    DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH：mm");

    @Override
    public Result makeExcelDatWeather(LocalDateTime start, LocalDateTime end) {

        String uuid = downloadManager.writeThread("datWeather/" + "气象数据：" + start.format(df1) + "到" + end.format(df1) + ".xlsx",
                fileDealingStat -> {
                    // 获取excel
                    ExcelWriter writer = getExcelWriter(start, end, fileDealingStat);

                    // 写出文件
                    writer.flush(fileDealingStat.getFile());

                    try {
                        System.out.println(fileDealingStat.getFile().getCanonicalPath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // 关闭writer，释放内存
                    writer.close();
                    fileDealingStat.finish();// 100%
                });

        return new Result(uuid, "生成进行中", 200);
    }

    @Override
    public Result checkExcelDatWeather(String uuid) {
        FileDealingStat fileDealingStat = downloadManager.checkFileDealingStat(uuid);
        String msg = "已获取";
        int stat = 200;
        if (fileDealingStat == null) {
            msg = "文件不存在";
            stat = 500;
        }
        return new Result(fileDealingStat, msg, stat);
    }
}
