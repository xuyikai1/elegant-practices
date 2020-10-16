package com.example.paydemo.jd.vo;

import java.io.Serializable;

/**
 * Created by zhangmeining on 2018/4/2.
 *
 * @Description:
 */
public class GoodsInfo implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    //商品编号
    private String id;
    //商品名称
    private String name;
    //商品一级类目
    private String cat1;
    //商品二级类目
    private String cat2;
    //商品三级类目
    private String cat3;
    //商品类型
    private String type;
    //商品单价
    private Long price;
    //商品数量
    private Integer num;
    //商品描述信息
    private String desc;

    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }

    public String getCat2() {
        return cat2;
    }

    public void setCat2(String cat2) {
        this.cat2 = cat2;
    }

    public String getCat3() {
        return cat3;
    }

    public void setCat3(String cat3) {
        this.cat3 = cat3;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
