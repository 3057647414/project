package com.hm.moc.shop.Bean;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FastJson {
    @Bean
    public JSONObject get(){
        return new JSONObject();
    }
}
