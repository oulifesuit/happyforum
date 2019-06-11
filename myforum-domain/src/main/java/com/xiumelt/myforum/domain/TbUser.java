package com.xiumelt.myforum.domain;

import java.io.Serializable;
import java.util.Date;

public class TbUser implements Serializable {
    private Long uid;
    private String username;
    private String password;
    private String email;
 /*   private boolean isRemember;*/
    private String timeStart;
    private String timeEnd;
    private int role;
    private Boolean isRemember;

    public TbUser(){}

    public TbUser (String username,String password,String email,String timeStart,String timeEnd){
        this.setUid(uid);
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setTimeStart(timeStart);
        this.setTimeEnd(timeEnd);
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Boolean getRemember() {
        return isRemember;
    }

    public void setRemember(Boolean remember) {
        isRemember = remember;
    }

    @Override
    public String toString() {
        return "TbUser{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", role=" + role +
                ", isRemember=" + isRemember +
                '}';
    }
}
