package com.adder.myseckillback.dao;


import com.adder.myseckillback.bean.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {
    public List<Goods> getAllGoods(@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getGoodsCounts();
}
