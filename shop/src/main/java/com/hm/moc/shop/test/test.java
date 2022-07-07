package com.hm.moc.shop.test;

import com.hm.moc.shop.Config.PropertiesConfig;
import com.hm.moc.shop.Restype.res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @Autowired
    private PropertiesConfig p;
    @RequestMapping("/a")
    public res ts(){
        res errorforgander = res.ERRORFORGANDER;
        return errorforgander.
        return res.ERRORFORDELETE;
//        System.out.println(p.b);
    }


}
