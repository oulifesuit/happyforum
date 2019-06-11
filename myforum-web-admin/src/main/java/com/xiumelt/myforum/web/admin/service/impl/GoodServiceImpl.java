package com.xiumelt.myforum.web.admin.service.impl;

import com.xiumelt.myforum.web.admin.dao.GoodDao;
import com.xiumelt.myforum.web.admin.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodDao goodDao;

    @Override
    public void insert(Long uid, Long pid) {
        goodDao.insert(uid,pid);
    }

    @Override
    public void deleGood(Long pid) {
        goodDao.deleGood(pid);
    }

    @Override
    public Long getUidByPid(Long pid) {

            return goodDao.getUidByPid(pid);

    }
}
