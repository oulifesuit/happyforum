package com.xiumelt.myforum.web.admin.web.controller;

import com.xiumelt.myforum.domain.Notice;
import com.xiumelt.myforum.web.admin.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "goNotice",method = RequestMethod.GET)
    public String goNotice(Model model){
        List<Notice> notices=noticeService.selectAll();

        model.addAttribute("notices",notices);
        return "noticeBoard";
    }

    @RequestMapping(value = "toNotice")
    public String toNotice(Model model, @RequestParam Long nid){
        Notice notice=noticeService.selectById(nid);
        model.addAttribute("notice",notice);
        return "toNotice";
    }

}
