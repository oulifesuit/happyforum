package com.xiumelt.myforum.web.admin.web.controller;

import com.xiumelt.myforum.commons.constant.ConstantUtils;
import com.xiumelt.myforum.domain.*;
import com.xiumelt.myforum.web.admin.dao.PostDao;
import com.xiumelt.myforum.web.admin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private TbUserService tbUserService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private PostService postService;
    @Autowired
    private ReplyService replyService;
    @Autowired
    private GoodService goodService;

    private Long goodPid=null;

    @RequestMapping(value="post/{name}",method = RequestMethod.GET)
    public String post(@PathVariable("name") String name, HttpServletRequest httpServletRequest,Model model){
        Post post=new Post();
        model.addAttribute("post",post);
        httpServletRequest.setAttribute("topic_name",name);
        return "post";
    }

    @RequestMapping(value="/postTie/{user_id}/{topic_name}",method = RequestMethod.POST)
    public String postTie(@PathVariable("user_id") Long user_id,@PathVariable("topic_name") String topic_name,
        Model model,Post post){
        Topic topic=topicService.selectByName(topic_name);
        Long tid=topic.getTid();
        postService.insert(post,tid,user_id);

        return "redirect:/toPost?pid="+postService.selectMaxId();
    }

    @RequestMapping(value = "toPost")
    public String toPost(@RequestParam Long pid,Model model){
        System.out.println(pid);
        goodPid =goodService.getUidByPid(pid);

        Post post=postService.selectByPid(pid);
        //对两个外键对象赋值
        post.setTbUser(tbUserService.selectById(postService.getUidByPid(pid)));
        post.setTopic(topicService.selectById(postService.getTidByPid(pid)));

        //获取评论信息
        List<Reply> replyLists = replyService.listReply(pid);
        for(Reply reply:replyLists){
            reply.setTbUser(tbUserService.selectById(replyService.getUidByRid(reply.getRid())));
            reply.setPost(postService.selectByPid(replyService.getPidByRid(reply.getRid())));
        }

        System.out.println(post);
        model.addAttribute("post",post);
        model.addAttribute("replyLists",replyLists);
        model.addAttribute("replyCon", new ReplyCon());
        model.addAttribute("goodPid",goodPid);
        return "tie";
    }

    @RequestMapping(value = "/postGood/{uid}/{pid}",method = RequestMethod.GET)
    public String postGood(@PathVariable("uid") Long uid,@PathVariable("pid") Long pid,Model model){

        goodPid =goodService.getUidByPid(pid);
            if(goodPid==null){
                postService.updateLikeCount(pid);
            goodService.insert(uid,pid);
        }else{

        }
        return "redirect:/toPost?pid="+pid;
    }

    //帖子列表
    @RequestMapping(value = "postlist",method = RequestMethod.GET)
    public String postlist(Model model){
        List<Post> posts=postService.selectAll();
        for(Post post:posts){
            post.setTbUser(tbUserService.selectById(postService.getUidByPid(post.getPid())));
            post.setTopic(topicService.selectById(postService.getTidByPid(post.getPid())));
        }
        model.addAttribute("posts",posts);
        return "post_list";
    }

    //帖子搜索
    @RequestMapping(value="postsearch",method = RequestMethod.POST)
    public String postsearch(Post post,Model model){
        List<Post> posts=postService.search(post);
        model.addAttribute("posts",posts);
        return "post_list";
    }

    @RequestMapping(value = "postdele/{pid}",method = RequestMethod.GET)
    public String postdele(@PathVariable("pid") Long pid){
        postService.dele(pid);
        return "redirect:/postlist";
    }

    @RequestMapping(value="searchByContent",method = RequestMethod.POST)
    public String searchcontent(Model model,HttpServletRequest httpServletRequest){
        String content=httpServletRequest.getParameter("content");
        List<Post> posts=postService.searchContent(content);
        for(Post post1:posts){
            post1.setTbUser(tbUserService.selectById(postService.getUidByPid(post1.getPid())));
            post1.setTopic(topicService.selectById(postService.getTidByPid(post1.getPid())));
        }
        model.addAttribute("posts",posts);
        return "search";
    }
}
