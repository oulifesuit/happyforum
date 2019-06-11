package com.xiumelt.myforum.web.admin.dao;

public interface GoodDao {
    Long getUidByPid(Long pid);
    void insert(Long uid,Long pid);
    void deleGood(Long pid);
}
