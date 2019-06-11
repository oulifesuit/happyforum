package com.xiumelt.myforum.web.admin.dao;

import com.xiumelt.myforum.domain.Reply;
import com.xiumelt.myforum.domain.ReplyCon;

import java.util.List;

public interface ReplyDao {
    void insert(Reply reply);
    List<Reply> listReply(Long pid);
    Long getUidByRid(Long rid);
    Long getPidByRid(Long rid);
}
