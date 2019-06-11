package com.xiumelt.myforum.web.admin.service;


import com.xiumelt.myforum.domain.Reply;
import com.xiumelt.myforum.domain.ReplyCon;

import java.util.List;

public interface ReplyService {

    void insert(ReplyCon replyCon);
    List<Reply> listReply(Long pid);
    Long getUidByRid(Long rid);
    Long getPidByRid(Long rid);
}
