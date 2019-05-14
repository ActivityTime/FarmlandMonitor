package neau.cekong.service;

import neau.cekong.pojo.PageInfoVO;

import java.time.LocalDateTime;

public interface DatWeatherPageService {
//    table.render({
//        elem: '#demp'
//                ,url: ''
//                ,request: {
//            pageName: 'curr' //页码的参数名称，默认：page
//                    ,limitName: 'nums' //每页数据量的参数名，默认：limit
//        }
//        //,…… //其他参数
//    });
    PageInfoVO findBetDates(LocalDateTime start, LocalDateTime end, Long page, Integer limit);
}
