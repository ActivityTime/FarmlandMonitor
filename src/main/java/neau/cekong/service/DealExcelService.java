package neau.cekong.service;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;

public interface DealExcelService {
    Boolean exportExcelDatWeather(LocalDateTime start, LocalDateTime end, OutputStream outputStream) throws IOException;
}
