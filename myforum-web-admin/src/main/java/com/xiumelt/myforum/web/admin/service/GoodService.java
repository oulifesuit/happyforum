package com.xiumelt.myforum.web.admin.service;

public interface GoodService {
    void insert(Long uid,Long pid);
    void deleGood(Long pid);
    Long getUidByPid(Long pid);
}
