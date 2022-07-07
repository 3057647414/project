package com.hm.moc.shop.Controller.kd;

import com.hm.moc.shop.Api.kd;
import com.hm.moc.shop.Bean.KDbean;
import com.hm.moc.shop.Dao.layjson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kd")
public class fandkd {
    @Autowired
    KDbean k;
    @RequestMapping("/fand")
    public Object fand(String kdnum,String kdgs){
        kd getkd = k.getkd();
        String getkdmsg = getkd.getkdmsg(kdnum, kdgs);
        return getkdmsg;
    }
}
