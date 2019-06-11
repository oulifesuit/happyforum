package com.xiumelt.myforum.web.admin.web.controller;

import com.xiumelt.myforum.commons.dto.BaseResult;
import com.xiumelt.myforum.domain.TbUser;
import com.xiumelt.myforum.web.admin.service.TbUserService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private TbUserService tbUserService;

    @ModelAttribute
    public TbUser getTbUser(Long id){
        TbUser tbUser=null;
        if(id!=null){
            tbUser=tbUserService.selectById(id);
        }
        else{
            tbUser=new TbUser();
        }
        return tbUser;
    }

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String manager_main(){

        return "manager_main";
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbUser> tbUsers=tbUserService.selectAll();

        model.addAttribute("tbUsers",tbUsers);
        return "user_list";
    }
    /**
     * 跳转用户表单页
     * @return
     */
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public String form(Model model) {
        TbUser tbUser=new TbUser();
        model.addAttribute("tbUser",tbUser);
        return "user_form";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser,Model model,RedirectAttributes redirectAttributes){
       /* System.out.println(tbUser);*/
        BaseResult baseResult=tbUserService.save(tbUser);
        //保存成功
        if(baseResult.getStatus()==200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "user_form";
        }


    }


    @RequestMapping(value = "userInfo",method = RequestMethod.GET)
    public String userInfo(HttpServletRequest httpServletRequest){
        return "userInfo";
    }

    @RequestMapping(value = "adminInfo",method = RequestMethod.GET)
    public String admin(HttpServletRequest httpServletRequest){
        return "adminInfo";
    }


    /**
     * 搜索
     * @param tbUser
     * @param model
     * @return
     */
    @RequestMapping(value="search",method = RequestMethod.POST)
    public String search(TbUser tbUser,Model model){
        List<TbUser> tbUsers=tbUserService.search(tbUser);
        model.addAttribute("tbUsers",tbUsers);
        return "user_list";
    }

    @RequestMapping(value="alterUser",method = RequestMethod.GET)
    public String alterUser(Model model){

        return "alter_info";
    }

    @ResponseBody
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public String dele(String ids){
        if (StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            tbUserService.deleteMulti(idArray);
        }
        return "redirect:/user/list";
    }

    @RequestMapping(value = "update",method =RequestMethod.GET)
    public String update(TbUser tbUser){

        tbUserService.update(tbUser);
        return "redirect:/alterUser";
    }

    @RequestMapping(value = "deleOne/{uid}",method =RequestMethod.GET)
    public String deleOne(@PathVariable("uid") Long uid){

        tbUserService.delete(uid);
        return "redirect:/user/list";
    }

}
