package neau.cekong.controller;

import neau.cekong.pojo.Data;
import neau.cekong.pojo.Result;
import neau.cekong.pojo.TbProduct;
import neau.cekong.service.InsertDataService;
import neau.cekong.service.InsertProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("data/setter")
public class InsertDataController {
    @Resource
    InsertProductService insertProductService;
    @Resource
    InsertDataService insertDataService;

    @RequestMapping("product")
    @ResponseBody
    Result insertProduct(TbProduct tbProduct) {
        return insertProductService.insService(tbProduct);
    }

    @RequestMapping("{view}/{productId}")
    @ResponseBody
    Result insertData(@PathVariable String view, @PathVariable int productId, String data, Date time) {

        return insertDataService.insData(productId, time, data, view);
    }
}
