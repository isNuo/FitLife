package com.milotnt.controller;

import com.milotnt.pojo.Admin;
import com.milotnt.pojo.CoachTable;
import com.milotnt.pojo.Member;
import com.milotnt.pojo.MemberPayment;
import com.milotnt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 登录控制
 */

@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private AdminService adminService;
//    @Autowired
//    private EmployeeService employeeService;
    @Autowired
    private EquipmentService equipmentService;
    @Autowired
    private CoachTableService trainService;
    @Autowired
    private MemberPaymentService memberPaymentService;

    //主页、跳转管理员登录页面
    @RequestMapping("/")
    public String toAdminLogin() {
        return "adminLogin";
    }

    //跳转会员登录页面
    @RequestMapping("/toUserLogin")
    public String toUserLogin() {
        return "userLogin";
    }

    //跳转教练登录页面
    @RequestMapping("/toCoachLogin")
    public String toCoachLogin() {
        return "coachLogin";
    }


    //包装近六个月内净收入数据  面积图
    @RequestMapping("/areaChartData")
    @ResponseBody
    public Object basicAreaChartData() {
        // 获取数据
        List<Object> monthlyData = new ArrayList<>();

        //获取当前年份和月份
        Calendar now = Calendar.getInstance();
        int nowYear = now.get(Calendar.YEAR);
        int nowMonth = now.get(Calendar.MONTH) + 1;

        int index = 6;  //获取月数据次数
        boolean flag = true;  //控制循环
        for (int indexYear = nowYear; indexYear >= nowYear - 1 && flag; indexYear--) {
            for (int indexMonth = 12; indexMonth >= 1 && flag; indexMonth--) {
                //判断是否为今年,此时month循环从当前月开始
                if (indexYear == nowYear && monthlyData.isEmpty()) {
                    indexMonth = nowMonth;
                }
                //日期
                String dataOfMonth = (indexYear - 2000) + "-" + indexMonth;   //日期形式"24-1"
                //会员缴纳金额收入
                Integer rechargeAmountTotal = memberPaymentService.selectByMonth(indexYear, indexMonth);
                //器材购买支出
                Integer equipmentAmountTotal = equipmentService.selectByMonth(indexYear, indexMonth);
                //净收入
                Integer netIncome = (rechargeAmountTotal != null ? rechargeAmountTotal : 0) - (equipmentAmountTotal != null ? equipmentAmountTotal : 0);

                Map<String,Object> monthData = new HashMap<>();
                monthData.put("date",dataOfMonth);
                monthData.put("netIncome",netIncome);

                monthlyData.add(monthData);

                index--;
                if (index < 1) {
                    flag = false;
                }
            }

        }

        // 反转列表
        Collections.reverse(monthlyData);

        return monthlyData;
    }

    //包装近一周会员缴费金额数据  柱状图
    @RequestMapping("/barChartData")
    @ResponseBody
    public Object basicBarChartData() {
        // 获取数据
        List<Object> monthlyData = new ArrayList<>();

        //获取当前 年\月\日
        Calendar now = Calendar.getInstance();
        int nowYear = now.get(Calendar.YEAR);
        int nowMonth = now.get(Calendar.MONTH) + 1;

        int index = 6;  //获取月数据次数
        boolean flag = true;  //控制循环
        for (int indexYear = nowYear; indexYear >= nowYear - 1 && flag; indexYear--) {
            for (int indexMonth = 12; indexMonth >= 1 && flag; indexMonth--) {
                //判断是否为今年,此时month循环从当前月开始
                if (indexYear == nowYear && monthlyData.isEmpty()) {
                    indexMonth = nowMonth;
                }
                //日期
                String dataOfMonth = (indexYear - 2000) + "-" + indexMonth;   //日期形式"24-1"
                //会员缴纳金额收入
                Integer rechargeAmountTotal = memberPaymentService.selectByMonth(indexYear, indexMonth);

                Map<String,Object> monthData = new HashMap<>();
                monthData.put("date",dataOfMonth);
                monthData.put("income",rechargeAmountTotal != null ? rechargeAmountTotal : 0);

                monthlyData.add(monthData);

                index--;
                if (index < 1) {
                    flag = false;
                }
            }

        }

        // 反转列表
        Collections.reverse(monthlyData);

        return monthlyData;
    }

    //管理员登录
    @RequestMapping("/adminLogin")
    public String adminLogin(Admin admin, Model model, HttpSession session) {
        Admin admin1 = adminService.adminLogin(admin);
        if (admin1 != null) {
            //获取当前年份和月份
            Calendar now = Calendar.getInstance();
            int year = now.get(Calendar.YEAR);
            int month = now.get(Calendar.MONTH) + 1;

            //会员人数
            Integer memberTotal = memberService.selectTotalCount();
            model.addAttribute("memberTotal", memberTotal);
            session.setAttribute("memberTotal", memberTotal);

//            //员工人数
//            Integer employeeTotal = employeeService.selectTotalCount();
//            model.addAttribute("employeeTotal", employeeTotal);
//            session.setAttribute("employeeTotal", employeeTotal);

            //教练人数
            Integer coachTotal = trainService.selectTotalCount();
            model.addAttribute("coachTotal", coachTotal);
            session.setAttribute("coachTotal", coachTotal);

//            //健身房总人数
//            Integer humanTotal = memberTotal + coachTotal;
//            model.addAttribute("humanTotal", humanTotal);
//            session.setAttribute("humanTotal", humanTotal);
            //本月净收入
            Integer rechargeAmountTotal = memberPaymentService.selectByMonth(year,month);
            Integer equipmentAmountTotal = equipmentService.selectByMonth(year, month);
            Integer netIncome = (rechargeAmountTotal != null ? rechargeAmountTotal : 0) - (equipmentAmountTotal != null ? equipmentAmountTotal : 0);
            model.addAttribute("netIncome", netIncome);
            session.setAttribute("netIncome", netIncome);

            //器材数
            Integer equipmentTotal = equipmentService.selectTotalCount();
            model.addAttribute("equipmentTotal", equipmentTotal);
            session.setAttribute("equipmentTotal", equipmentTotal);

            return "adminMain";
        }
        model.addAttribute("msg", "您输入的账号或密码有误，请重新输入！");
        return "adminLogin";
    }

    //会员登录
    @RequestMapping("/userLogin")
    public String userLogin(Member member, Model model, HttpSession session) {
        Member member1 = memberService.userLogin(member);
        if (member1 != null) {
            model.addAttribute("member", member1);
            session.setAttribute("user", member1);
            return "userMain";
        }
        model.addAttribute("msg", "您输入的账号或密码有误，请重新输入！");
        return "userLogin";
    }

    //教练登录
    @RequestMapping("/coachLogin")
    public String coachLogin(CoachTable coach, Model model, HttpSession session) {
        CoachTable coach1 = trainService.coachLogin(coach);
        if (coach1 != null) {
            model.addAttribute("coach", coach1);
            session.setAttribute("user", coach1);
            return "coachMain";
        }
        model.addAttribute("msg", "您输入的账号或密码有误，请重新输入！");
        return "coachLogin";
    }


    //跳转管理员主页
    @RequestMapping("/toAdminMain")
    public String toAdminMain(Model model, HttpSession session) {

        Integer memberTotal = (Integer) session.getAttribute("memberTotal");
        Integer coachTotal = (Integer) session.getAttribute("coachTotal");
//        Integer humanTotal = (Integer) session.getAttribute("humanTotal");
        Integer netIncome = (Integer) session.getAttribute("netIncome");
        Integer equipmentTotal = (Integer) session.getAttribute("equipmentTotal");

        model.addAttribute("memberTotal", memberTotal);
        model.addAttribute("coachTotal", coachTotal);
        model.addAttribute("netIncome", netIncome);
        model.addAttribute("equipmentTotal", equipmentTotal);

        //获取当前年份和月份
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;

        //获取一年内每月的会员缴费金额
        Map<String, Integer> paymentData = new LinkedHashMap<>();
        for (int i = year-1; i <= year ; i++) {
            if (i == year-1){
                for (int j = month; j <= 12; j++) {
                    Integer payment = memberPaymentService.selectByMonth(i,j);
                    paymentData.put(i + "-" + j, payment);
                }
            }else {
                for (int j = 1; j <= month ; j++) {
                    Integer payment = memberPaymentService.selectByMonth(i,j);
                    paymentData.put(i + "-" + j, payment);
                }
            }
        }

        model.addAttribute("paymentData", paymentData);

        return "adminMain";
    }

    //跳转会员主页
    @RequestMapping("/toUserMain")
    public String toUserMain(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "userMain";
    }

    //跳转教练主页
    @RequestMapping("/toCoachMain")
    public String toCoachMain(Model model, HttpSession session) {
        CoachTable coach = (CoachTable) session.getAttribute("user");
        model.addAttribute("coach", coach);
        return "coachMain";
    }

}
