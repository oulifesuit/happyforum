package com.xiumelt.myforum.web.admin.service.impl;

import com.xiumelt.myforum.domain.Topic;
import com.xiumelt.myforum.web.admin.dao.TopicDao;
import com.xiumelt.myforum.web.admin.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicDao topicDao;
    @Autowired
    private TopicService topicService;
    @Override
    public List<Topic> selectAll() {
        return topicDao.selectAll();
    }

    @Override
    public Topic selectById(Long id) {
        return topicDao.selectById(id);
    }

    @Override
    public Topic selectByName(String tname) {
        return topicDao.selectByName(tname);
    }
}
