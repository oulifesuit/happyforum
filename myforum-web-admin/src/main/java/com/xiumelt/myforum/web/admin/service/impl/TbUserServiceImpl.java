package com.xiumelt.myforum.web.admin.service.impl;

import com.xiumelt.myforum.commons.constant.RegexpUtils;
import com.xiumelt.myforum.commons.dto.BaseResult;
import com.xiumelt.myforum.commons.utils.TimeUtils;
import com.xiumelt.myforum.domain.TbUser;
import com.xiumelt.myforum.web.admin.dao.TbUserDao;
import com.xiumelt.myforum.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;
    @Autowired
    private TbUserService tbUserService;

    @Override
    public List<TbUser> selectAll() {

        return tbUserDao.selectAll();
    }

    @Override
    public BaseResult save(TbUser tbUser) {
        BaseResult baseResult=checkTbUser(tbUser);
        //验证通过
        if(baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            tbUser.setTimeEnd(TimeUtils.formatDate(new Date()));
            //新增用户
            if(tbUser.getUid()==null){
                //密码加密
               /* tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));*/
                tbUser.setTimeStart(TimeUtils.formatDate(new Date()));
                tbUserDao.insert(tbUser);
            }
            //编辑用户
            else{
                tbUserDao.insert(tbUser);
            }
            baseResult.setMessage("保存用户信息成功");
        }
        return baseResult;
    }

    @Override
    public void delete(Long id) {
        tbUserDao.delete(id);
    }

    @Override
    public void update(TbUser tbUser) {

        tbUserDao.update(tbUser);
    }

    @Override
    public TbUser selectById(Long id) {
        return tbUserDao.selectById(id);
    }

    @Override
    public TbUser selectByName(String username) {
        return tbUserDao.selectByName(username);
    }

    @Override
    public TbUser login(String username, String password) {
        TbUser tbUser=tbUserDao.getByName(username);
        //有用户状态
        if(tbUser!=null){
            /*//获取MD5密码
            String password= DigestUtils.md5DigestAsHex(loginPwd.getBytes());
            System.out.println("***************"+password);*/
            //密码匹配，登录成功
            if(password.equals(tbUser.getPassword())){

                return tbUser;
            }
            else{

            }
        }
        else{

        }
        return null;
    }

    @Override
    public void register(String username,String password,String email) {
        /*获取当前时间*/

        String timeStart=TimeUtils.formatDate(new Date());
        String timeEnd=TimeUtils.formatDate(new Date());
        /*输出测试*/
        System.out.println(username + "--" + password + "--" + email+ "-----" + timeStart + "--" + timeEnd);
        /*插入数据*/
        TbUser tbUser=new TbUser(username,password,email,timeStart,timeEnd);
        tbUserDao.insert(tbUser);
        /*TbUser tbUser = new TbUser();
        tbUser.setUsername(Username);
        return tbUser;*/
    }

    @Override
    public List<TbUser> search(TbUser tbUser) {
        return tbUserDao.search(tbUser);
    }

    @Override
    public void deleteMulti(String[] idArray) {
        tbUserDao.deleteMulti(idArray);
    }

    /**
     *用户信息的有效验证
     */
    public BaseResult checkTbUser(TbUser tbUser){
        BaseResult baseResult=BaseResult.success();
        if(StringUtils.isBlank(tbUser.getEmail())){
            baseResult=BaseResult.fail("邮箱不能为空，请重新输入");
        }
        else if(!RegexpUtils.checkEmail(tbUser.getEmail())){
            baseResult=BaseResult.fail("邮箱格式不正确，请重新输入");
        }
        else if(StringUtils.isBlank(tbUser.getUsername())){
            baseResult=BaseResult.fail("用户名不能为空，请重新输入");
        }
        else if(StringUtils.isBlank(tbUser.getPassword())){
            baseResult=BaseResult.fail("密码不能为空，请重新输入");
        }
        return baseResult;
    }
}
