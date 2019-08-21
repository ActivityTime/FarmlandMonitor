package neau.cekong.service;

import neau.cekong.pojo.Result;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;

public interface DealExcelService {
    Boolean exportExcelDatWeather(LocalDateTime start, LocalDateTime end, OutputStream outputStream) throws IOException;

    Result<File> exportExcelDatWeather(String uuid);

    Result makeExcelDatWeather(LocalDateTime start, LocalDateTime end);

    Result checkExcelDatWeather(String uuid);
}
