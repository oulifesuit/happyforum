package com.xiumelt.myforum.web.admin.web.controller;

import com.xiumelt.myforum.domain.Notice;
import com.xiumelt.myforum.domain.Post;
import com.xiumelt.myforum.domain.Topic;
import com.xiumelt.myforum.web.admin.service.NoticeService;
import com.xiumelt.myforum.web.admin.service.PostService;
import com.xiumelt.myforum.web.admin.service.TbUserService;
import com.xiumelt.myforum.web.admin.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TopicService topicService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private PostService postService;
    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main(Model model){
        List<Topic> topics=topicService.selectAll();
        List<Notice> notices=noticeService.selectAll();
        //按最新发帖时间
        List<Post> posts=postService.selectPostByTime();
        for(Post po:posts){
            po.setTopic(topicService.selectById(postService.getTidByPid(po.getPid())));
            po.setTbUser(tbUserService.selectById(postService.getUidByPid(po.getPid())));
        }

        //按最新回复时间
        List<Post> posts1=postService.selectPostByReplyTime();
        for(Post po:posts1){
            po.setTopic(topicService.selectById(postService.getTidByPid(po.getPid())));
            po.setTbUser(tbUserService.selectById(postService.getUidByPid(po.getPid())));
        }

        model.addAttribute("topics",topics);
        model.addAttribute("posts",posts);
        model.addAttribute("posts1",posts1);
        model.addAttribute("notices",notices);

        return "main";
    }
}
