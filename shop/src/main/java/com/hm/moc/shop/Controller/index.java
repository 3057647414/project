package com.hm.moc.shop.Controller;

import com.alibaba.fastjson.JSONObject;
import com.hm.moc.shop.Pojo.modules;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.hash;

@RestController
public class index{
    @RequestMapping("/menu")
    public List getmodules(HttpServletResponse response){
//        List<modules> list = new ArrayList<>();
//        modules modules = new modules("num1","1","-1","http://4399.com");
//        modules modules1 = new modules("num1","2","-1","http://4399.com");
//        modules modules2 = new modules("num1","3","-1","http://4399.com");
//        modules modules3 = new modules("num1","4","-1","http://4399.com");
//        modules modules4 = new modules("num1","5","-1","http://4399.com");
//        modules modules5 = new modules("num1","6","-1","http://4399.com");
//        modules modules6 = new modules("num1","7","-1","http://4399.com");
//        modules modules7 = new modules("num1","8","-1","http://4399.com");
//        modules modules8 = new modules("num1","9","-1","http://4399.com");
//
//        list.add(modules);
//        list.add(modules1);
//        list.add(modules2);
//        list.add(modules3);
//        list.add(modules4);
//        list.add(modules5);
//        list.add(modules6);
//
//        list.add(modules7);
//        list.add(modules8);
//        HashMap<String, Object> map= new HashMap<String, Object>();
//        map.keySet().add("title");
//        map.entrySet().add("title",new map<String,String>)
        Map<String,Object> map=new HashMap<>();
        map.put("title","sas='acdac'");
        System.out.println(map);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title","sasc");
        System.out.println(jsonObject);
        return null;

    }
}
