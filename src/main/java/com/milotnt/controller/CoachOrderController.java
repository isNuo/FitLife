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

import java.util.List;

/**
 * 管理员系统的教练指导
 */
@Controller
@RequestMapping("/coach")
public class CoachOrderController {

    @Autowired
    private CoachTableService trainService;

    @Autowired
    private ClassOrderService classOrderService;

    @Autowired
    private ClassTableService classTableService;

    //查询教练
    @RequestMapping("/selCoach")
    public String selectCoach(Model model){
        List<CoachTable> coachList = trainService.findAll();
        model.addAttribute("coachList",coachList);
        return "selectCoach";
    }

    //查询教练指导训练情况
    @RequestMapping("/selCoachTrain")
    public String selectClassOrder(Integer classId, Model model) {
        List<ClassOrder> classOrderList = classOrderService.selectMemberOrderList(classId);
        ClassTable classList = classTableService.selectByClassId(classId);
        model.addAttribute("classOrderList", classOrderList);
        model.addAttribute("classList", classList);
        return "selectCoachTrain";
    }

}
