package com.xiumelt.myforum.web.admin.dao;

import com.xiumelt.myforum.domain.TbUser;


import java.util.List;

public interface TbUserDao {
    /*
    * 查询全部用户信息
    */
    List<TbUser> selectAll();
    void insert(TbUser tbUser);
    void delete(Long id);
    void update(TbUser tbUser);
    TbUser selectById(Long id);
    TbUser selectByName(String username);
    TbUser getByName(String username);
    List<TbUser> search(TbUser tbUser);
    void updatePostCount(Long uid);
    void deleteMulti(String[] idArray);
}
