package com.xiumelt.myforum.domain;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable{
    private Long rid;
    private String content;
    private TbUser tbUser;
    private Post post;
    private String replyTime;


    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "rid=" + rid +
                ", content='" + content + '\'' +
                ", tbUser=" + tbUser +
                ", post=" + post +
                ", replyTime='" + replyTime + '\'' +
                '}';
    }
}
