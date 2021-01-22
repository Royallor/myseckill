package com.adder.myseckillback.bean;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Goods {
    private int id;
    private String title;
    private String info;
    private BigDecimal price;
    private int save;
    private Timestamp begin_time;
    private Timestamp end_time;

    public Goods() {
    }

    public Goods(String title, String info, BigDecimal price, int save, Timestamp begin_time, Timestamp end_time) {
        this.title = title;
        this.info = info;
        this.price = price;
        this.save = save;
        this.begin_time = begin_time;
        this.end_time = end_time;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getSave() {
        return save;
    }

    public Timestamp getBegin_time() {
        return begin_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public void setBegin_time(Timestamp begin_time) {
        this.begin_time = begin_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", info='" + info + '\'' +
                ", price=" + price +
                ", save=" + save +
                ", begin_time=" + begin_time +
                ", end_time=" + end_time +
                '}';
    }
}

