package com.xiumelt.myforum.web.admin.service.impl;

import com.xiumelt.myforum.commons.constant.RegexpUtils;
import com.xiumelt.myforum.commons.dto.BaseResult;
import com.xiumelt.myforum.commons.utils.TimeUtils;
import com.xiumelt.myforum.domain.Post;
import com.xiumelt.myforum.web.admin.dao.PostDao;
import com.xiumelt.myforum.web.admin.dao.TbUserDao;
import com.xiumelt.myforum.web.admin.dao.TopicDao;
import com.xiumelt.myforum.web.admin.service.PostService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Autowired
    private TbUserDao tbUserDao;

    @Autowired
    private TopicDao topicDao;

    @Override
    public List<Post> selectAll() {
        return postDao.selectAll();
    }

    @Override
    public BaseResult insert(Post post,Long topic_id,Long user_id) {
        BaseResult baseResult = checkPost(post);
        if (baseResult.getStatus() == BaseResult.STATUS_SUCCESS) {
            post.setPostTime(TimeUtils.formatDate(new Date()));
            post.setAlterTime(TimeUtils.formatDate(new Date()));
            post.setReplyTime(TimeUtils.formatDate(new Date()));
            post.setTbUser(tbUserDao.selectById(user_id));
            post.setTopic(topicDao.selectById(topic_id));
            //初始化数据为零
            post.setReplyCount(0L);
            post.setLikeCount(0L);
            post.setScanCount(0L);
            postDao.insert(post);
            tbUserDao.updatePostCount(user_id);
            baseResult.setMessage("发帖成功");
        }
        return baseResult;
    }


    @Override
    public BaseResult checkPost(Post post) {
        BaseResult baseResult=BaseResult.success();
        if(StringUtils.isBlank(post.getTitle())){
            baseResult=BaseResult.fail("标题不能为空，请重新输入");
        }
        else if(StringUtils.isBlank(post.getContent())){
            baseResult=BaseResult.fail("内容不能为空，请重新输入");
        }
        return baseResult;
    }

    @Override
    public Post selectByPid(Long pid) {
        return postDao.selectByPid(pid);
    }

    @Override
    public Long selectMaxId() {
        return postDao.selectMaxId();
    }

    @Override
    public Long getUidByPid(Long pid) {
        return postDao.getUidByPid(pid);
    }

    @Override
    public Long getTidByPid(Long pid) {

        return postDao.getTidByPid(pid);
    }

    @Override
    public List<Post> selectPostByTime() {
        return postDao.selectPostByTime();
    }

    @Override
    public List<Post> selectPostByReplyTime() {
        return postDao.selectPostByReplyTime();
    }

    @Override
    public void updateReplyCount(Long pid) {
        postDao.updateReplyCount(pid);
    }

    @Override
    public void updateScanCount(Long pid) {
        postDao.updateScanCount(pid);
    }

    @Override
    public void updateLikeCount(Long pid) {
        postDao.updateLikeCount(pid);
    }

    @Override
    public void updateReplyTime(Long pid) {
        postDao.updateScanCount(pid);
    }

    @Override
    public List<Post> search(Post post) {
        return postDao.search(post);
    }

    @Override
    public void dele(Long pid) {
        postDao.dele(pid);
    }

    @Override
    public List<Post> selectAllByTid(Long tid) {
        return postDao.selectAllByTid(tid);
    }

    @Override
    public List<Post> searchContent(String content) {
        return postDao.searchContent(content);
    }


}
