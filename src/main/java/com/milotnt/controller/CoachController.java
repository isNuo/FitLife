package com.milotnt.controller;

import com.milotnt.pojo.ClassOrder;
import com.milotnt.pojo.ClassTable;
import com.milotnt.pojo.CoachTable;
import com.milotnt.service.ClassOrderService;
import com.milotnt.service.ClassTableService;
import com.milotnt.service.CoachTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 教练系统
 */

@Controller
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    private CoachTableService coachTableService;

    @Autowired
    private ClassTableService classTableService;

    @Autowired
    private ClassOrderService classOrderService;

    //跳转个人信息页面
    @RequestMapping("/toCoachInfo")
    public String toCoachInformation(Model model, HttpSession session) {
        CoachTable coach = (CoachTable) session.getAttribute("user");
        model.addAttribute("coach", coach);
//        ClassTable classTable = classTableService.selectByClassId(coach.getClassId());
//        model.addAttribute("class", classTable);
        return "coachInformation";
    }

//    //跳转修改个人信息页面
//    @RequestMapping("/toUpdateInfo")
//    public String toUpdateCoachInformation(HttpSession session, Model model) {
//        CoachTable coach = (CoachTable) session.getAttribute("user");
//        model.addAttribute("coach", coach);
//        return "updateCoachInformation";
//    }

    //跳转修改个人信息页面
    @RequestMapping("/toUpdateInfo")
    public String toUpdateCoachInformation(Integer coachAccount, HttpSession session, Model model) {
        CoachTable coach = coachTableService.selectByCoachAccount(coachAccount);
        model.addAttribute("coach", coach);
        return "updateCoachInformation";
    }

    //修改个人信息
    @RequestMapping("/updateInfo")
    public String updateCoachInformation(Model model, HttpSession session, CoachTable coach) {
        CoachTable coach1 = (CoachTable) session.getAttribute("user");
        model.addAttribute("coach", coach);

        coach.setCoachAccount(coach1.getCoachAccount());
        coach.setEntryTime(coach1.getEntryTime());

        coachTableService.updateCoachByCoachAccount(coach);
        return "coachInformation";
    }

    //查询指导课程
    @RequestMapping("/selCoachClass")
    public String selectCoachClass(Model model, HttpSession session) {
        CoachTable coach = (CoachTable) session.getAttribute("user");
        List<ClassTable> classList = classTableService.selectByCoachAccount(coach.getCoachAccount());

        model.addAttribute("classList", classList);
        return "selectCoachClass";
    }

    //查询指导课程报名信息
    @RequestMapping("/selCoachClassOrder")
    public String selectCoachClassOrder(Integer classId, Model model) {
//        CoachTable coach = coachTableService.selectByClassId(classId);
//        int coachAccount = classTableService.selectByClassId(classId).getCoachAccount();
//        CoachTable coach = coachTableService.selectByCoachAccount(coachAccount);
        List<ClassOrder> classOrderList = classOrderService.selectMemberOrderList(classId);
//        model.addAttribute("coach",coach);
        model.addAttribute("classOrderList", classOrderList);
        return "selectCoachClassOrder";
    }

}

