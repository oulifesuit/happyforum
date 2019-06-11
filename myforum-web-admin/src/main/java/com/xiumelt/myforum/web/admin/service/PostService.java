package com.xiumelt.myforum.web.admin.service;

import com.xiumelt.myforum.commons.dto.BaseResult;
import com.xiumelt.myforum.domain.Post;

import java.util.List;

public interface PostService {
    List<Post> selectAll();
    BaseResult insert(Post post,Long topic_id,Long user_id);
    BaseResult checkPost(Post post);
    Post selectByPid(Long pid);
    Long selectMaxId();
    Long getUidByPid(Long pid);
    Long getTidByPid(Long pid);
    List<Post> selectPostByTime();
    List<Post> selectPostByReplyTime();
    void updateReplyCount(Long pid);
    void updateScanCount(Long pid);
    void updateLikeCount(Long pid);
    void updateReplyTime(Long pid);

    List<Post> search(Post post);
    void dele(Long pid);
    List<Post> selectAllByTid(Long tid);
    List<Post> searchContent(String content);
}
