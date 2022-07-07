package com.hm.moc.shop.Pojo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Shop {
    private double id;
    private String name;
    private String head;
    private List<User> careuser;
    private List<Order> order;
    private double ye;
    private double jf;
    private String  address;


}
