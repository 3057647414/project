package com.hm.moc.shop.Pojo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Order {
    private double id;
    private String ordernum;
    private List<Shopobj> shopobj;
    private String  shopid;
    private String  userid;
    private String Kdnum;
    private String address;
    private String addressto;


}
