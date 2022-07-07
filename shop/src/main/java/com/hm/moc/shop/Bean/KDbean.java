package com.hm.moc.shop.Bean;

import com.hm.moc.shop.Api.kd;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KDbean {
    @Bean
    public kd getkd(){
        kd kd = new kd();
        return kd;
    }
}
