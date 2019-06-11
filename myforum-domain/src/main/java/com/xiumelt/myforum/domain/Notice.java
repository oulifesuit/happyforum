package com.xiumelt.myforum.domain;

import java.io.Serializable;
import java.util.Date;

public class Notice implements Serializable {
    private Long nid  ;
    private String title;
    private String  content;
    private String noTime;
    private String alterTime;

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNoTime() {
        return noTime;
    }

    public void setNoTime(String noTime) {
        this.noTime = noTime;
    }

    public String getAlterTime() {
        return alterTime;
    }

    public void setAlterTime(String alterTime) {
        this.alterTime = alterTime;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "nid=" + nid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", noTime=" + noTime +
                ", alterTime=" + alterTime +
                '}';
    }
}
