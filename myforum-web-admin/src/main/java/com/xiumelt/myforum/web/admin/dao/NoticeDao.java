package com.xiumelt.myforum.web.admin.dao;

import com.xiumelt.myforum.domain.Notice;

import java.util.List;

public interface NoticeDao {
    List<Notice> selectAll();
    Notice selectById(Long nid);
}
