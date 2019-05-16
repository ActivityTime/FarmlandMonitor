package neau.cekong.util;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MyExcelUtils {

    public static void setDownloadExcelHeader(HttpServletResponse response, String filename) {

        response.reset();
        response.setContentType("application/octet-stream;charset=utf-8");


        try {
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}


