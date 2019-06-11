package com.xiumelt.myforum.web.admin.web.controller;

import com.xiumelt.myforum.domain.Post;
import com.xiumelt.myforum.domain.Topic;
import com.xiumelt.myforum.web.admin.service.NoticeService;
import com.xiumelt.myforum.web.admin.service.PostService;
import com.xiumelt.myforum.web.admin.service.TbUserService;
import com.xiumelt.myforum.web.admin.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TopicController {
    @Autowired
    private TopicService topicService;
    @Autowired
    private PostService postService;
    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value="topic",method = RequestMethod.GET)
    public String topic(Long topic_tid, Model model){
        List<Post> posts=postService.selectAllByTid(topic_tid);
        for(Post post:posts){
            post.setTopic(topicService.selectById(topic_tid));
            post.setTbUser(tbUserService.selectById(postService.getUidByPid(post.getPid())));
        }
        Topic topic=topicService.selectById(topic_tid);
        model.addAttribute("topic",topic);
        model.addAttribute("posts",posts);
        return "topic";
    }
}
