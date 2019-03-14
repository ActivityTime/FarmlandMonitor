package neau.cekong.service.impl;

import neau.cekong.mapper.TbProductMapper;
import neau.cekong.pojo.Result;
import neau.cekong.pojo.TbProduct;
import neau.cekong.service.InsertProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Service
public class InsertProductServiceImpl implements InsertProductService {
    @Resource
    TbProductMapper tbProductMapper;

    @Override
    public Result insService(TbProduct tbProduct) {

        Result result = new Result();
        int num = 0;
        try {
            num = tbProductMapper.insertSelective(tbProduct);
        } catch (Exception e) {
            num = -1;
        }

        if (num > 0) {
            System.out.println(tbProduct.getProductName());
            result.setData(num);
            result.setMsg("插入成功");
            result.setStatus(200);
        } else {
            result.setData(num);
            result.setMsg("插入失败");
            result.setStatus(500);
        }

        return result;
    }
}
