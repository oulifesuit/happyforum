package com.xiumelt.myforum.web.admin.dao;

import com.xiumelt.myforum.domain.Topic;

import java.util.List;

public interface TopicDao {
    List<Topic> selectAll();
    Topic selectById(Long id);
    Topic selectByName(String tname);
}
