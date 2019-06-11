package com.xiumelt.myforum.web.admin.web.controller;

import com.xiumelt.myforum.domain.Reply;
import com.xiumelt.myforum.domain.ReplyCon;
import com.xiumelt.myforum.web.admin.dao.PostDao;
import com.xiumelt.myforum.web.admin.dao.ReplyDao;
import com.xiumelt.myforum.web.admin.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private PostDao postDao;

    @RequestMapping(value = "/reply",method = RequestMethod.POST)
    public String reply(ReplyCon replyCon){

        replyService.insert(replyCon);
        postDao.updateReplyCount(replyCon.getPid());
        postDao.updateReplyTime(replyCon.getPid());

        return "redirect:/toPost?pid="+replyCon.getPid();
    }
}
