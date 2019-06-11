package com.xiumelt.myforum.web.admin.service.impl;

import com.xiumelt.myforum.commons.utils.TimeUtils;
import com.xiumelt.myforum.domain.Reply;
import com.xiumelt.myforum.domain.ReplyCon;
import com.xiumelt.myforum.web.admin.dao.PostDao;
import com.xiumelt.myforum.web.admin.dao.ReplyDao;
import com.xiumelt.myforum.web.admin.dao.TbUserDao;
import com.xiumelt.myforum.web.admin.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyDao replyDao;

    @Autowired
    private PostDao postDao;

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public void insert(ReplyCon replyCon) {
        /*reply.setTbUser(tbUserDao.selectById(replyDao.getUidByRid(reply.getRid())));
        reply.setPost(postDao.selectByPid(replyDao.getPidByRid(reply.getRid())));*/
        Reply reply=new Reply();
        reply.setTbUser(tbUserDao.selectById(replyCon.getUid()));
        reply.setPost(postDao.selectByPid(replyCon.getPid()));
        reply.setContent(replyCon.getContent());
        reply.setReplyTime(TimeUtils.formatDate(new Date()));
        replyDao.insert(reply);
    }

    @Override
    public List<Reply> listReply(Long pid) {
        return replyDao.listReply(pid);
    }

    @Override
    public Long getUidByRid(Long rid) {
        return replyDao.getUidByRid(rid);
    }

    @Override
    public Long getPidByRid(Long rid) {
        return replyDao.getPidByRid(rid);
    }
}
