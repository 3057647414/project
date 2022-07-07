package com.hm.moc.shop.Controller.User;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hm.moc.shop.Dao.layjson;
import com.hm.moc.shop.Mapper.UserMapper;
import com.hm.moc.shop.Pojo.Shopcart;
import com.hm.moc.shop.Pojo.Shopobj;
import com.hm.moc.shop.Pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class userlist {
    @Autowired
    SqlSessionFactory sqlSessionFactory;
    @Autowired
    JSONObject jsonObject;
    @RequestMapping("/fandall")
    public Object fandall(){
        UserMapper mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        List<User> fanduserall = mapper.fanduserall();
        layjson l=new layjson();
        Map lay = l.lay(fanduserall);
        return lay;
    }
    @RequestMapping("/fandbyuid")
    public Object fanduserbyuid(String uid){
        UserMapper mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        User fanduserbyid = mapper.fanduserbyuid(uid);
        List list=new ArrayList();
        list.add(fanduserbyid);
        layjson l=new layjson();
        Map lay = l.lay(list);
        return lay;
    }
    @RequestMapping("/fandbygander")
    public Object fanduserbugander(int gander) {
        UserMapper mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        List<User> fanduserbyid = mapper.fanduserbygander(gander);
        layjson l=new layjson();
        Map lay = l.lay(fanduserbyid);
        return lay;
    }
    @RequestMapping("/fandbyid")
    public Object fanduserbyid(String  id){
        UserMapper mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        User fanduserbyid = mapper.fanduserbyid(Double.parseDouble(id));
        List list=new ArrayList();
        layjson l=new layjson();
        Map lay = l.lay(list);
        return lay;

    }
    @RequestMapping("/fandbyname")
    public Object fandbyname(String name){
        UserMapper mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        List<User> fanduserall = mapper.fanduserbyname(name);
        layjson l=new layjson();
        Map lay = l.lay(fanduserall);
        return lay;
    }
    @RequestMapping("/fandbyphone")
    public Object fandbyphone(String phone){
        UserMapper mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        User fanduserall = mapper.fanduserbyphone(phone);
        List list=new ArrayList();
        list.add(fanduserall);
        layjson l=new layjson();
        Map lay = l.lay(list);
        return lay;
    }
    @RequestMapping("/fandbyjob")
    public Object fandbyjob(String job){
        UserMapper mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        List<User> fanduserall = mapper.fanduserbyjob(job);
        layjson l=new layjson();
        Map lay = l.lay(fanduserall);
        return lay;
    }
    @RequestMapping("/fandshopcart")
    public Object fandshopcart(double id){
        UserMapper mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        User fanduserall = mapper.fanduserbyid(id);
        String shopcart = fanduserall.getShopcart();
        Shopcart o = (Shopcart) jsonObject.toJSON(shopcart);
        return o;
    }
    @RequestMapping("/addshopcart")
    public Object addshopcart(double id,Shopobj a){
        UserMapper mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        User fanduserbyid = mapper.fanduserbyid(id);
        String shopcart = fanduserbyid.getShopcart();
        Shopcart o = (Shopcart) jsonObject.toJSON(shopcart);
        boolean add = o.shopcart.add(a);
        String s = jsonObject.toJSONString(o);
        if (add)
        {
            int addshopcart = mapper.addshopcart(fanduserbyid.getPhone(), s);
            if (addshopcart==1){
                return true;
            }else {
                return false;
            }
        }else {
            log.error("购物车添加错误");
            return false;
        }

    }
    @RequestMapping("/delshopcart")
    public Object delshopcart(double id,Shopobj a){
        UserMapper mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        User fanduserbyid = mapper.fanduserbyid(id);
        String shopcart = fanduserbyid.getShopcart();
        Shopcart o = (Shopcart) jsonObject.toJSON(shopcart);

        boolean add=false;
        for (Shopobj s:o.shopcart){
            boolean equals = s.equals(a);
            if (equals){
                add = o.shopcart.remove(a);
            }
            else {
                add=false;
            }

        }

        String s = jsonObject.toJSONString(o);
        if (add)
        {
            int addshopcart = mapper.addshopcart(fanduserbyid.getPhone(), s);
            if (addshopcart==1){
                return true;
            }else {
                return false;
            }
        }else {
            log.error("购物车删除失败");
            return false;
        }

    }
    @RequestMapping("/adduser")
    public Object adduser(String phone,String name,String pwd){
        UserMapper mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        int adduser = mapper.adduser(phone, pwd, name);
        if (adduser==1){
            return true;
        }else {
            return false;
        }
    }



    }
