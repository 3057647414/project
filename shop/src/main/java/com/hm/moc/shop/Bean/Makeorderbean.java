package com.hm.moc.shop.Bean;

import com.hm.moc.shop.Dao.Makeorder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Makeorderbean {
    @Bean
    public Makeorder makeorder(){
        Makeorder makeorder = new Makeorder();
        return makeorder;
    }
}
