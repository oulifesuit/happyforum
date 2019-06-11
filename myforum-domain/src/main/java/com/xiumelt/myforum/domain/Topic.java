package com.xiumelt.myforum.domain;

import java.io.Serializable;

public class Topic implements Serializable {
    private Long tid ;
    private String tname;
    private String content;
    private String image;

    public Long getTid() { return tid; }

    public void setTid(Long tid) { this.tid = tid; }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
