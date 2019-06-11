package com.xiumelt.myforum.web.admin.service;

import com.xiumelt.myforum.domain.Notice;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NoticeService {
    List<Notice> selectAll();
    Notice selectById(Long nid);
}
