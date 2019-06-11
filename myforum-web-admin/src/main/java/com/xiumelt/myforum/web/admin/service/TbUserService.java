package com.xiumelt.myforum.web.admin.service;

import com.xiumelt.myforum.commons.dto.BaseResult;
import com.xiumelt.myforum.domain.TbUser;

import java.util.Base64;
import java.util.List;

public interface TbUserService {
    /*
    *查询所有用户信息
    */
    List<TbUser> selectAll();
    BaseResult save(TbUser tbUser);
    void delete(Long id);
    void update(TbUser tbUser);
    TbUser selectById(Long id);
    TbUser selectByName(String username);

    TbUser login(String loginId, String loginPwd);
    void register(String username,String password,String email);

    /**
     * 搜索功能
     * @param tbUser
     * @return
     */
    List<TbUser> search(TbUser tbUser);
    void deleteMulti(String[] idArray);
}
