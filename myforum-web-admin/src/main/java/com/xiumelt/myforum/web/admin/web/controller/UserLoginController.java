package com.xiumelt.myforum.web.admin.web.controller;

import com.xiumelt.myforum.commons.constant.ConstantUtils;
import com.xiumelt.myforum.commons.utils.CookieUtils;
import com.xiumelt.myforum.domain.TbUser;
import com.xiumelt.myforum.web.admin.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;

import static com.xiumelt.myforum.commons.constant.ConstantUtils.COOKIE_LOGIN_REMEMBER_NAME;

@Controller
public class UserLoginController {

    @Autowired
    private TbUserService tbUserService;
    /*默认 /login 和访问login.jsp*/
    /*
    * 跳转登录页面
    * */
    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login(HttpServletRequest httpServletRequest) {
        //获取cookie
        String cookieValue = CookieUtils.getCookieValue(httpServletRequest, COOKIE_LOGIN_REMEMBER_NAME);

/*//        如果所得cookie非空,设置页码内容
        try {
            httpServletRequest.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        if(!StringUtils.isBlank(cookieValue)){
            String [] userInfo=cookieValue.split(":");
            String username=userInfo[0];
            String password=userInfo[1];//或得cookie值，用户名和密码的值
            System.out.println(username+"======"+password);
            httpServletRequest.setAttribute("username",username);
            httpServletRequest.setAttribute("password",password);//传到jsp页码的username和password
            httpServletRequest.setAttribute("isRemember",true);
        }

        return "login";
    }

    /*
    * 登录逻辑
    * */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String username, @RequestParam(required = true) String password,
                        RedirectAttributes redirectAttributes,
                        HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {
       /* System.out.println("-------------------------------" + username + "--" + password);*/

        TbUser tbUser = tbUserService.login(username, password);
        System.out.println("tbUser: " + tbUser);

        if (tbUser == null) {
            redirectAttributes.addFlashAttribute("error_msg", "用户名或密码错误");
            return "redirect:login";
        } else {
            /*
             *记住我
             *勾选记住我传回来的值是on ,不勾选则为null
             */
            boolean isRemember = httpServletRequest.getParameter(COOKIE_LOGIN_REMEMBER_NAME) == null ? false : true;
            System.out.println("Remember me: "  + isRemember);
            //如果登录时没有记住我
            if (isRemember == false) {
                //清空所有登录信息
                tbUser.setRemember(false);
                //设置cookie值为空
                CookieUtils.setCookie(httpServletRequest, httpServletResponse, COOKIE_LOGIN_REMEMBER_NAME,
                        "", 0);

            } else {
                //设置登录信息
                tbUser.setRemember(true);
                //设置cookie值
                CookieUtils.setCookie(httpServletRequest, httpServletResponse, COOKIE_LOGIN_REMEMBER_NAME,
                        String.format("%s:%s", username, password), 7 * 24 * 60 * 60, true);//设置cookie值
            }

            //登录成功后，把登录信息传到前端的session
            httpServletRequest.getSession().setAttribute(ConstantUtils.SESSION_USER, tbUser);
            return "redirect:main";
        }
        /*保存邮箱放到session，用于到主页面显示用户*/
        /* session.setAttribute("email",username);*/
//            redirectAttributes.addFlashAttribute("email",loginId);
    }


    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String loginOut(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().invalidate();
        return "redirect:main";
    }

    @RequestMapping("testCookie")
    public void testCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie: cookies){
            System.out.println(cookie.getName() + "----" + cookie.getValue());
        }
    }
}

