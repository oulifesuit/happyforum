package com.xiumelt.myforum.domain;

public class Comment {
    private Long cid;

    //评论内容
    private String content;
    //两个外键，指向Reply和User
    private Reply reply;
    private TbUser tbUser;

    //评论时间
    private String commentTime;

    public Comment() {}

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cid=" + cid +
                ", content='" + content + '\'' +
                ", reply=" + reply +
                ", tbUser=" + tbUser +
                ", commentTime='" + commentTime + '\'' +
                '}';
    }
}
