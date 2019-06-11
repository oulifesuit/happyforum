package com.xiumelt.myforum.web.admin.service.test;

import com.xiumelt.myforum.domain.TbUser;
import com.xiumelt.myforum.web.admin.dao.TbUserDao;
import com.xiumelt.myforum.web.admin.service.TbUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml",
        "classpath:spring-context-druid.xml",
        "classpath:spring-context-mybatis.xml"})
public class TbUserServiceTest {

    @Autowired
    private TbUserService tbUserService;
    @Test
    public void testselectAll(){
        List<TbUser> tbUsers=tbUserService.selectAll();
        for (TbUser tbUser : tbUsers)
            System.out.println(tbUser.getUsername());
    }

    @Test
    public void testselectByName(){
        tbUserService.selectByName("张三");
    }

    @Autowired
    TbUserDao tbUserDao;

    @Test
    public void teseselectall(){
        List<TbUser> tbUsers = tbUserDao.selectAll();
        for(TbUser tbUser:tbUsers){
            System.out.println(tbUser);
        }

    }
}
