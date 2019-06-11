package com.xiumelt.myforum.web.admin.service.impl;

import com.xiumelt.myforum.domain.Notice;
import com.xiumelt.myforum.web.admin.dao.NoticeDao;
import com.xiumelt.myforum.web.admin.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;
    @Override
    public List<Notice> selectAll() {
        return noticeDao.selectAll();
    }

    @Override
    public Notice selectById(Long nid) {
        return noticeDao.selectById(nid);
    }
}
