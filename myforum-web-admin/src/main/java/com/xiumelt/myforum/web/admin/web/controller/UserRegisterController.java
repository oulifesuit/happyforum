package com.xiumelt.myforum.web.admin.web.controller;

import com.xiumelt.myforum.domain.TbUser;
import com.xiumelt.myforum.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserRegisterController {
    @Autowired
    private TbUserService tbUserService;

    @RequestMapping(value="register",method= RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value="register",method=RequestMethod.POST)
    /*用户，邮箱，密码*/
    /*用于重定向之后还能带参数跳转的*/
    public String register(String username, String password, String en_password, String email, RedirectAttributes redirectAttributes){
        if(username==""||email==""||password==""||username==null||email==null||password==null) {
            redirectAttributes.addFlashAttribute("error_msg","信息不能为空");
            return "redirect:register";
        }
        else {
            System.out.println("-------------------------------" + email + "--" + password);

            List<TbUser> users = tbUserService.selectAll();
            for(TbUser user : users){
                System.out.println("-------------------------------" + user.getUsername());
                if(username.equals(user.getUsername())){
                    redirectAttributes.addFlashAttribute("error_msg","用户名已被注册");
                    return "redirect:register";
                }

                if(email.equals(user.getEmail())){
                    redirectAttributes.addFlashAttribute("error_msg","邮箱已被注册");
                    return "redirect:register";
                }

            }

            if(!password.equals(en_password)){
                System.out.println(password+" "+en_password);
                redirectAttributes.addFlashAttribute("error_msg","密码不一致");
                return "redirect:register";
            }

            tbUserService.register(username, password,email);

            return "redirect:login";
        }
    }

}
