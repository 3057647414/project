package com.hm.moc.shop.Pojo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString
public class User {
    private String id;
    private  String name;
    private String pwd;
    private String uid;
    private int gander;
    private String  shopcart;
    private double jf;
    private double ye;
    private String phone;
    private String job;
    private String head;
    private int jobgander;
    private List<Shop> careshop;
    private List<String> addressto;
}
