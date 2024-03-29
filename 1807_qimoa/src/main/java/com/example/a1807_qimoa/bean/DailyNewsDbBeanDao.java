package com.example.a1807_qimoa.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DailyNewsDbBeanDao {
    @Id(autoincrement = true)
    private Long id;

    private String url;
    private String topic;
    private String desc;
    @Generated(hash = 1911311508)
    public DailyNewsDbBeanDao(Long id, String url, String topic, String desc) {
        this.id = id;
        this.url = url;
        this.topic = topic;
        this.desc = desc;
    }
    @Generated(hash = 1178033901)
    public DailyNewsDbBeanDao() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTopic() {
        return this.topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

}
