package com.hm.moc.shop.Dao;

import javax.jws.Oneway;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class layjson {
    public Map lay(List list){
        Object A[] = list.toArray();
        Map<String, Object> m = new HashMap();
        m.put("code", "0");
        m.put("count", "100");
        m.put("msg", "");
        m.put("data", A);
        return m;
    }
}
