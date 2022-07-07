package com.hm.moc.shop.Pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class modules {
    private String name;
    private String id;
    private String pid;
    private String url;

    public modules(String name, String id, String pid, String url) {
        this.name = name;
        this.id = id;
        this.pid = pid;
        this.url = url;
    }
}
