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

import java.util.ArrayList;
import java.util.List;

/**
 * 管理员系统的课程管理
 */

@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassTableService classTableService;

    @Autowired
    private ClassOrderService classOrderService;

    @Autowired
    private CoachTableService coachTableService;

    //查询课程
    @RequestMapping("/selClass")
    public String selectClass(Model model) {
        List<ClassTable> classList = classTableService.findAll();
        List<String> coachNameList = new ArrayList<>();

        for (ClassTable classTable : classList){
            int coachAccount = classTable.getCoachAccount();
            //根据教练账号查询教练姓名
            String coachName = coachTableService.selectByCoachAccount(coachAccount).getCoachName();
            coachNameList.add(coachName);
        }

        model.addAttribute("classList", classList);
        model.addAttribute("coachNameList", coachNameList);
        return "selectClass";
    }

    //跳转新增课程页面
    @RequestMapping("/toAddClass")
    public String toAddClass() {
        return "addClass";
    }

    //新增课程
    @RequestMapping("/addClass")
    public String addClass(ClassTable classTable, Model model) {
        CoachTable coachTable = coachTableService.selectByCoachAccount(classTable.getCoachAccount());
        if(coachTable == null){
            model.addAttribute("error","教练ID不存在，请重新输入");
            model.addAttribute("classTable",classTable);
            return "addClass";
        }
        classTableService.insertClass(classTable);
        return "redirect:selClass";
    }

    //删除课程
    @RequestMapping("/delClass")
    public String deleteClass(Integer classId) {
        classTableService.deleteClassByClassId(classId);
        classOrderService.deleteByClassId(classId);
        return "redirect:selClass";
    }

    //查询课程报名信息
    @RequestMapping("/selClassOrder")
    public String selectClassOrder(Integer classId, Model model) {
//        CoachTable coach = coachTableService.selectByClassId(classId);
        int coachAccount = classTableService.selectByClassId(classId).getCoachAccount();
        CoachTable coach = coachTableService.selectByCoachAccount(coachAccount);
        List<ClassOrder> classOrderList = classOrderService.selectMemberOrderList(classId);
        model.addAttribute("coach",coach);
        model.addAttribute("classOrderList", classOrderList);
        return "selectClassOrder";
    }

}
