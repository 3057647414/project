package com.hm.moc.shop.Controller.shop;

import com.hm.moc.shop.Dao.layjson;
import com.hm.moc.shop.Mapper.ShopMapper;
import com.hm.moc.shop.Pojo.Shop;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class shoplist {
    @Autowired
    SqlSessionFactory sqlSessionFactory;
    @RequestMapping("/fandall")
    public Object fandallshop(){
        ShopMapper mapper = sqlSessionFactory.openSession().getMapper(ShopMapper.class);
        List<Shop> fandshopall = mapper.fandshopall();
        layjson l=new layjson();
        Map lay = l.lay(fandshopall);
        return lay;
    }
    @RequestMapping("/fandshopbyid")
    public Object fandshopbyid(String id){
        ShopMapper mapper = sqlSessionFactory.openSession().getMapper(ShopMapper.class);
        List<Shop> fandshopall = mapper.fandshopbyid(id);
        layjson l=new layjson();
        Map lay = l.lay(fandshopall);
        return lay;
    }
    @RequestMapping("/fandshopbyname")
    public Object fandshopbyname(String name){
        ShopMapper mapper = sqlSessionFactory.openSession().getMapper(ShopMapper.class);
        List<Shop> fandshopall = mapper.fandshopbyname(name);
        layjson l=new layjson();
        Map lay = l.lay(fandshopall);
        return lay;
    }
    @RequestMapping("/fandshopbyphone")
    public Object fandshopbyphone(String phone){
        ShopMapper mapper = sqlSessionFactory.openSession().getMapper(ShopMapper.class);
        List<Shop> fandshopall = mapper.fandshopbyphone(phone);
        layjson l=new layjson();
        Map lay = l.lay(fandshopall);
        return lay;
    }
}
