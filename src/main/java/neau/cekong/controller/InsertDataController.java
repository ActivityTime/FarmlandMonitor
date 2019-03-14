package neau.cekong.controller;

import neau.cekong.pojo.Result;
import neau.cekong.pojo.TbProduct;
import neau.cekong.service.InsertProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("data/setter")
public class InsertDataController {
    @Resource
    InsertProductService insertProductService;

    @RequestMapping("product")
    @ResponseBody
    Result insertProduct(TbProduct tbProduct) {
        return insertProductService.insService(tbProduct);
    }
}
