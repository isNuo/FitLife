package com.milotnt.controller;

import com.milotnt.pojo.*;
import com.milotnt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 会员系统
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ClassTableService classTableService;

    @Autowired
    private CoachTableService coachTableService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberPaymentService memberPaymentService;

    @Autowired
    private ClassOrderService classOrderService;


    //跳转个人信息页面
    @RequestMapping("/toUserInfo")
    public String toUserInformation(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "userInformation";
    }

    //跳转修改个人信息页面
    @RequestMapping("/toUpdateInfo")
    public String toUpdateUserInformation(Integer memberAccount, HttpSession session, Model model) {
        Member member = memberService.selectByMemberAccount(memberAccount);
        model.addAttribute("member", member);
        return "updateUserInformation";
    }

    //修改个人信息
    @RequestMapping("/updateInfo")
    public String updateUserInformation(HttpSession session, Member member) {
        Member member1 = (Member) session.getAttribute("user");

        member.setMemberAccount(member1.getMemberAccount());
        member.setCardBalance(member1.getCardBalance());
        member.setCardTime(member1.getCardTime());

        memberService.updateMemberByMemberAccount(member);
        return "userInformation";
    }


    //跳转当前会员的会员卡缴费页面
    @RequestMapping("/toSelCard")
    public String selectUserCard(HttpSession session, Model model){
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "userCard";
    }

    //查询当前会员卡缴费记录
    @RequestMapping("/selUserPayment")
    public String selectMemberPayment(Integer memberAccount, Model model) {
        List<MemberPayment> memberPaymentList = memberPaymentService.selectByMemberAccount(memberAccount);
        model.addAttribute("memberPaymentList", memberPaymentList);
        return "selectUserPayment";
    }

    //充值页面
    @RequestMapping("/toUserPay")
    public String toUserPayment(HttpSession session, Integer rechargeAmount){
        Member member = (Member) session.getAttribute("user");

        if (rechargeAmount != null && rechargeAmount > 0) {
            MemberPayment memberPayment = new MemberPayment();

            //获取当前日期
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String nowDay = simpleDateFormat.format(date);

            memberPayment.setMemberAccount(member.getMemberAccount());
            memberPayment.setRechargeAmount(rechargeAmount);
            memberPayment.setRechargeTime(nowDay);

            memberPaymentService.insertMemberPayment(memberPayment);

            Integer balance = member.getCardBalance();
            balance += rechargeAmount;
            member.setCardBalance(balance);

            memberService.updateMemberByMemberAccount(member);
        }

        return "userPayment";
    }


    //跳转我的课程页面
    @RequestMapping("/toUserClass")
    public String toUserClass(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        Integer memberAccount = member.getMemberAccount();
        List<ClassOrder> classOrderList = classOrderService.selectClassOrderByMemberAccount(memberAccount);
        List<CoachTable> coachList = new ArrayList<>();
        List<ClassTable> classList = new ArrayList<>();

        // 适用for-each循环获取classOrderList中的classId
        for (ClassOrder classOrder : classOrderList) {
            Integer classId = classOrder.getClassId();
            ClassTable classTable = classTableService.selectByClassId(classId);
            classList.add(classTable);   // 将查询到的classTable添加到classList中
            // 根据coachAccount查询对应的CoachTable
            CoachTable coachTable = coachTableService.selectByCoachAccount(classTable.getCoachAccount());
            coachList.add(coachTable);   // 将查询到的coachTable添加到coachList中
        }

        model.addAttribute("member", member);
        model.addAttribute("classOrderList", classOrderList);
        model.addAttribute("classList", classList);
        model.addAttribute("coachList",coachList);

        return "userClass";
    }

    //退课
    @RequestMapping("delUserClass")
    public String deleteUserClass(Integer classOrderId) {
        classOrderService.deleteByClassOrderId(classOrderId);
        return "redirect:toUserClass";
    }

//    //跳转报名选课页面
//    @RequestMapping("/toApplyClass")
//    public String toUserApplyClass(Model model, HttpSession session) {
//        Member member = (Member) session.getAttribute("user");
//        List<ClassTable> classList = classTableService.findAll();
//        model.addAttribute("member", member);
//        model.addAttribute("classList", classList);
//        return "userApplyClass";
//    }

//    //跳转报名选课页面
//    @RequestMapping("/toApplyClass")
//    public String toUserApplyClass(Model model, HttpSession session) {
//        Member member = (Member) session.getAttribute("user");
//        List<CoachTable> coachList = trainService.findAll();
//        List<ClassTable> classList = new ArrayList<>();
//        // 使用for-each循环获取coachList中的classId
//        for (CoachTable coach : coachList) {
//            int classId = coach.getClassId();
//            // 根据classId查询对应的ClassTable
//            ClassTable classTable = classTableService.selectByClassId(classId);
//            classList.add(classTable);   // 将查询到的ClassTable添加到classList中
//        }
//        model.addAttribute("member", member);
//        model.addAttribute("coachList", coachList);
//        model.addAttribute("classList", classList);
//        return "userApplyClass";
//    }

    //跳转报名选课页面
    @RequestMapping("/toApplyClass")
    public String toUserApplyClass(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
//        List<CoachTable> coachList = coachTableService.findAll();
        List<ClassTable> classList = classTableService.findAll();
        List<CoachTable> coachList = new ArrayList<>();
        // 使用for-each循环获取classList中的coachAccount
        for (ClassTable classItem : classList) {
            int coachAccount = classItem.getCoachAccount();
            // 根据coachAccount查询对应的CoachTable
            CoachTable coachTable = coachTableService.selectByCoachAccount(coachAccount);
            coachList.add(coachTable);   // 将查询到的coachTable添加到coachList中
        }
        model.addAttribute("member", member);
        model.addAttribute("coachList", coachList);
        model.addAttribute("classList", classList);
        return "userApplyClass";
    }

    //报名选课
    @RequestMapping("/applyClass")
    public String userApplyClass(Integer classId, Model model, HttpSession session) {
        ClassTable classTable = classTableService.selectByClassId(classId);
        Member member = (Member) session.getAttribute("user");

        Integer classId1 = classTable.getClassId();
        String className = classTable.getClassName();
//        String coach = classTable.getCoach();
        Integer coachAccount = classTable.getCoachAccount();
        String classBegin = classTable.getClassBegin();
        String memberName = member.getMemberName();
        Integer memberAccount = member.getMemberAccount();

        ClassOrder classOrder = new ClassOrder(classId1, className, memberName, memberAccount, classBegin);
        Integer memberAccount1 = member.getMemberAccount();
        ClassOrder classOrder1 = classOrderService.selectMemberByClassIdAndMemberAccount(classId1, memberAccount1);

        if (classOrder1 == null) {
            classOrderService.insertClassOrder(classOrder);
        }

        return "redirect:toUserClass";
    }

    //跳转预约教练页面
    @RequestMapping("/toReserveCoach")
    public String toUserReserveCoach(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        List<CoachTable> coachList = coachTableService.findAll();
        List<ClassTable> classList = new ArrayList<>();

//        // 使用for-each循环获取coachList中的classId
//        for (CoachTable coach : coachList) {
//            int classId = coach.getClassId();
//            // 根据classId查询对应的ClassTable
//            ClassTable classTable = classTableService.selectByClassId(classId);
//            classList.add(classTable);   // 将查询到的ClassTable添加到classList中
//        }

        model.addAttribute("member", member);
        model.addAttribute("coachList", coachList);
//        model.addAttribute("classList", classList);
        return "userReserveCoach";
    }

    //跳转指定教练指导课程页面
    @RequestMapping("/toSelCoachClass")
    public String toUserSelCoachClass(Integer coachAccount, Model model, HttpSession session){
        CoachTable coachTable = coachTableService.selectByCoachAccount(coachAccount);

        List<ClassTable> classList = classTableService.selectByCoachAccount(coachAccount);

        model.addAttribute("classList", classList);
        return "userSelCoachClass";
    }


    //预约教练指导课程
    @RequestMapping("/reserveCoachClass")
    public String userReserveCoachClass(Integer classId, Model model, HttpSession session) {
        ClassTable classTable = classTableService.selectByClassId(classId);
        Member member = (Member) session.getAttribute("user");

        Integer classId1 = classTable.getClassId();
        String className = classTable.getClassName();
        String classBegin = classTable.getClassBegin();
        String memberName = member.getMemberName();
        Integer memberAccount = member.getMemberAccount();

        ClassOrder classOrder = new ClassOrder(classId1, className, memberName, memberAccount, classBegin);
        ClassOrder classOrder1 = classOrderService.selectMemberByClassIdAndMemberAccount(classId1, memberAccount);

        if (classOrder1 == null) {
            classOrderService.insertClassOrder(classOrder);
        }

        return "redirect:toUserClass";
    }
    

}
