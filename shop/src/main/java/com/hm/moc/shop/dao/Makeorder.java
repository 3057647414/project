package com.hm.moc.shop.Dao;

import com.hm.moc.shop.Pojo.Order;
import com.hm.moc.shop.Pojo.Shopobj;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Makeorder {
    public Order make(String userid, String shopid, double money, String address, String addressto, List<Shopobj> shopobjList){
        Date date = new Date(System.currentTimeMillis());
        String time=date.toString();
        Order order=new Order();
        order.setOrdernum(time+userid+money+shopid);
        order.setUserid(userid);
        order.setAddress(address);
        order.setAddressto(addressto);
        order.setShopid(shopid);
        order.setShopobj(shopobjList);
        return order;
    }
}
