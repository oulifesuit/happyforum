package com.xiumelt.myforum.web.admin.dao;

import com.xiumelt.myforum.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostDao {
    List<Post> selectAll();
    void insert(Post post);
    Post selectByPid(Long pid);
    Long selectMaxId();
    Long getUidByPid(Long pid);
    Long getTidByPid(Long pid);
    List<Post> selectPostByTime();
    List<Post> selectPostByReplyTime();
    List<Post> search(Post post);

    void updateReplyCount(Long pid);
    void updateScanCount(Long pid);
    void updateLikeCount(Long pid);
    void updateReplyTime(Long pid);
    void dele(Long pid);
    List<Post> selectAllByTid(Long tid);
    List<Post> searchContent(String content);
}
