package com.hm.moc.shop.Config;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
@Data
public class PropertiesConfig {
    @Value("${abs.a}")
    public String b;
//    @Autowired
//    private String a;

}
