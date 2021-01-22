package com.adder.myseckillback.controller;

import com.adder.myseckillback.bean.Goods;
import com.adder.myseckillback.dao.GoodsDao;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class GoodsController {

    @Autowired
    GoodsDao goodsDao;

    @CrossOrigin
    @RequestMapping("/allGoods")
    public String getGoodsList(com.adder.myseckillback.bean.QueryInfo queryInfo){
        System.out.println(queryInfo);
        int numbers = goodsDao.getGoodsCounts();// 获取数据总数
        int pageStart = (queryInfo.getPageNum()-1)*queryInfo.getPageSize();
        List<Goods> goods = goodsDao.getAllGoods(pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",goods);
        System.out.println("总条数："+numbers);
        return JSON.toJSONString(res);
    }
}
