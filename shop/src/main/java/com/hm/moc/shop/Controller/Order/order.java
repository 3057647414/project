package com.hm.moc.shop.Controller.Order;

import com.hm.moc.shop.Bean.Makeorderbean;
import com.hm.moc.shop.Dao.Makeorder;
import com.hm.moc.shop.Dao.layjson;
import com.hm.moc.shop.Mapper.OrderMapper;
import com.hm.moc.shop.Mapper.ShopMapper;
import com.hm.moc.shop.Pojo.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class order {
    @Autowired
    Makeorderbean makeorderbean;
    @Autowired
    SqlSessionFactory sqlSessionFactory;
    @RequestMapping("/fandall")
    public Object fandall(){
        OrderMapper mapper = sqlSessionFactory.openSession().getMapper(OrderMapper.class);
        List<Order> fandall = mapper.fandall();
        layjson l=new layjson();
        Map lay = l.lay(fandall);
        return lay;
    }
    @RequestMapping("/fandbyphone")
    public Object fandbyphone(String phone){
        OrderMapper mapper = sqlSessionFactory.openSession().getMapper(OrderMapper.class);
        List<Order> fandorderbyphone = mapper.fandorderbyphone(phone);
        layjson l=new layjson();
        Map lay = l.lay(fandorderbyphone);
        return lay;
    }
    @RequestMapping("/fandbykdnum")
    public Object fandbykdnum(String kdnum){
        OrderMapper mapper = sqlSessionFactory.openSession().getMapper(OrderMapper.class);
        List<Order> fand= mapper.fandorderbykdnum(kdnum);
        layjson l=new layjson();
        Map lay = l.lay(fand);
        return lay;
    }
    @RequestMapping("/fandbyshopid")
    public Object fandbyshopid(String shopid) {
        OrderMapper mapper = sqlSessionFactory.openSession().getMapper(OrderMapper.class);
        List<Order> fand = mapper.fandorderbyshopid(shopid);
        layjson l=new layjson();
        Map lay = l.lay(fand);
        return lay;
    }
    @RequestMapping("/fandbyaccept")
    public Object fandbyaccept(String accept) {
        OrderMapper mapper = sqlSessionFactory.openSession().getMapper(OrderMapper.class);
        List<Order> fand = mapper.fandorderbyaccept(accept);
        layjson l=new layjson();
        Map lay = l.lay(fand);
        return lay;
    }
    @RequestMapping("/fandbyordernum")
    public Object fandbyordernum(String ordernum) {
        OrderMapper mapper = sqlSessionFactory.openSession().getMapper(OrderMapper.class);
        List<Order> fand = mapper.fandorderbyordernum(ordernum);
        layjson l=new layjson();
        Map lay = l.lay(fand);
        return lay;
    }
    @RequestMapping("/addorder")
    public Object addorder(HttpServletRequest res, Shopobj shopobj,int num) {
        List<Shopobj> shopobjList = null;
        shopobjList.add(shopobj);
        User user = (User) res.getSession().getAttribute("user");
        OrderMapper mapper = sqlSessionFactory.openSession().getMapper(OrderMapper.class);
        Makeorder makeorder = makeorderbean.makeorder();
        String shopid = shopobj.getShopid();
        ShopMapper mapper1 = sqlSessionFactory.openSession().getMapper(ShopMapper.class);
        List<Shop> fandshopbyid = mapper1.fandshopbyid(shopid);
        Shop shop = fandshopbyid.get(0);
        Order make = makeorder.make(user.getId(), shopobj.getShopid(), shopobj.getPrice(), shop.getAddress(), user.getAddressto().get(num), shopobjList);
        int addorder = mapper.addorder(make.getOrdernum(), make.getShopid(), make.getUserid(), make.getShopobj().toString(), make.getAddress(), make.getAddressto());
        if (addorder==1){
            return true;
        }else
        return false;
    }
    @RequestMapping("/addkdnum")
    public Object addkdnum(String ordernum,String kdnum){
        OrderMapper mapper = sqlSessionFactory.openSession().getMapper(OrderMapper.class);
        int upkdnum = mapper.upkdnum(ordernum, kdnum);
        if (upkdnum==1){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("/upaddress")
    public Object upaddress(String ordernum,String address){
        OrderMapper mapper = sqlSessionFactory.openSession().getMapper(OrderMapper.class);
        int upkdnum = mapper.upaddress(ordernum, address);
        if (upkdnum==1){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("/upaddressto")
    public Object upaddressto(String ordernum,String address){
        OrderMapper mapper = sqlSessionFactory.openSession().getMapper(OrderMapper.class);
        int upkdnum = mapper.upaddressto(ordernum, address);
        if (upkdnum==1){
            return true;
        }else {
            return false;
        }
    }
    @RequestMapping("/upaccept")
    public Object upaccept(String ordernum,String accept){
        OrderMapper mapper = sqlSessionFactory.openSession().getMapper(OrderMapper.class);
        int upkdnum = mapper.upaccept(ordernum, accept);
        if (upkdnum==1){
            return true;
        }else {
            return false;
        }
    }


}
