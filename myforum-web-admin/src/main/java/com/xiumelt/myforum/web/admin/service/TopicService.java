package com.xiumelt.myforum.web.admin.service;

import com.xiumelt.myforum.domain.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> selectAll();
    Topic selectById(Long id);
    Topic selectByName(String tname);
}
