package com.xiumelt.myforum.domain;

public class Good {
    private Long uid;
    private Long pid;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Good{" +
                "uid=" + uid +
                ", pid=" + pid +
                '}';
    }

}
