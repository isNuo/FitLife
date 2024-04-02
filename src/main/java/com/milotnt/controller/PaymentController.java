package com.milotnt.controller;

import com.milotnt.pojo.Equipment;
import com.milotnt.service.EquipmentService;
import com.milotnt.service.MemberPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 管理员系统的收支情况
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private MemberPaymentService memberPaymentService;

    @Autowired
    private EquipmentService equipmentService;

    //初版--包装近一年内收入与支出对比图数据  双折线图
//    @RequestMapping ("/lineChartData")
//    @ResponseBody
//    public Object stackedLineChartData(){
//
//        //获取当前年份和月份
//        Calendar now = Calendar.getInstance();
//        int nowYear = now.get(Calendar.YEAR);
//        int nowMonth = now.get(Calendar.MONTH) + 1;
//
//        Map<String,Object> monthlyData = new HashMap<>();
//        List<String> date = new ArrayList<>();
//        List<Integer> income = new ArrayList<>(), expense = new ArrayList<>();
//
//        int index = 12;  //获取月数据次数
//        boolean flag = true;  //控制循环
//        for (int indexYear = nowYear; indexYear >= nowYear-1 && flag ; indexYear--) {
//            for (int indexMonth = 12; indexMonth >=1 && flag; indexMonth--) {
//                //判断是否为今年,此时month循环从当前月开始
//                if(indexYear == nowYear && date.isEmpty()) {
//                    indexMonth = nowMonth;
//                }
//                //日期
//                String dataOfMonth = (indexYear-2000) + "-" + indexMonth;   //日期形式"24-1"
//                date.add(dataOfMonth);
//                //会员缴纳金额收入
//                Integer rechargeAmountTotal = memberPaymentService.selectByMonth(indexYear, indexMonth);
//                income.add(rechargeAmountTotal != null ? rechargeAmountTotal : 0);
//                //器材购买支出
//                Integer equipmentAmountTotal = equipmentService.selectByMonth(indexYear, indexMonth);
//                expense.add(equipmentAmountTotal != null ? equipmentAmountTotal : 0);
//
//                index--;
//                if(index < 1){
//                    flag = false;
//                }
//            }
//
//        }
////        测试数据
////        List<String> date = Stream.of("Mon", "Mon", "Mon", "Mon", "Mon", "Mon","Mon", "Mon", "Mon", "Mon", "Mon", "Mon").collect(Collectors.toList());
////        List<Integer> income = Stream.of(420, 532, 301, 434, 690, 430, 420, 532, 301, 434, 690, 430).collect(Collectors.toList());
////        List<Integer> expense = Stream.of(220, 182, 191, 234, 290, 330, 220, 182, 191, 234, 290, 330).collect(Collectors.toList());
//
//        // 反转列表
//        Collections.reverse(date);
//        Collections.reverse(income);
//        Collections.reverse(expense);
//        monthlyData.put("date",date);
//        monthlyData.put("income",income);
//        monthlyData.put("expense",expense);
//
//        return monthlyData;
//    }

    // 包装近一年内收入与支出对比图数据
    // 更适应折线图数据格式,但需修改Fetch代码
    @RequestMapping("/lineChartData")
    @ResponseBody
    public Object stackedLineChartData() {
        // 获取数据
        List<Object> monthlyData = new ArrayList<>();

        //获取当前年份和月份
        Calendar now = Calendar.getInstance();
        int nowYear = now.get(Calendar.YEAR);
        int nowMonth = now.get(Calendar.MONTH) + 1;

        int index = 12;  //获取月数据次数
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

                Map<String,Object> monthData = new HashMap<>();
                monthData.put("date",dataOfMonth);
                monthData.put("income",rechargeAmountTotal != null ? rechargeAmountTotal : 0);
                monthData.put("expense",equipmentAmountTotal != null ? equipmentAmountTotal : 0);

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

    //包装器材类型数量统计数据 饼图
    @RequestMapping("/pieChartData")
    @ResponseBody
    public Object basicPieChartData() {

        List<Equipment> equipmentList = equipmentService.findAll();

        List<Object> pieChartData = new ArrayList<>();
        for (Equipment equipment : equipmentList) {
            String equipmentName = equipment.getEquipmentName();
            int equipmentNumber = equipment.getEquipmentNumber();

            // 包装成饼图数据格式
            Map<String, Object> dataItem = new HashMap<>();
            dataItem.put("value", equipmentNumber);
            dataItem.put("name", equipmentName);

            pieChartData.add(dataItem);
        }

        return pieChartData;
    }



    //收支情况页面
    @RequestMapping("/selPayment")
    public String selectPayment(Model model) {

        //获取当前年份和月份
        Calendar now = Calendar.getInstance();
        int nowYear = now.get(Calendar.YEAR);
        int nowMonth = now.get(Calendar.MONTH) + 1;

        //传递相关数据的列表
        List<String> dataOfMonthList = new ArrayList<>();
        List<Integer> rechargeAmountList = new ArrayList<>(), equipmentAmountList = new ArrayList<>(), netIncomeList = new ArrayList<>();

        //初始年份为2023
        for (int indexYear = 2023; indexYear <= nowYear; indexYear++) {
            for (int indexMonth = 1; indexMonth <= 12; indexMonth++) {   //结束条件必须为12，考虑多个年份情况
                //判断是否为最后一个月
                if (indexYear == nowYear && indexMonth > nowMonth) {
                    break;
                }
                //日期
                String dataOfMonth = indexYear + "-" + indexMonth;
                dataOfMonthList.add(dataOfMonth);
                //会员缴纳金额收入
                Integer rechargeAmountTotal = memberPaymentService.selectByMonth(indexYear, indexMonth);
                rechargeAmountList.add(rechargeAmountTotal != null ? rechargeAmountTotal : 0);
                //器材购买支出
                Integer equipmentAmountTotal = equipmentService.selectByMonth(indexYear, indexMonth);
                equipmentAmountList.add(equipmentAmountTotal != null ? equipmentAmountTotal : 0);
//                //净收入
//                Integer netIncome = (rechargeAmountTotal != null ? rechargeAmountTotal : 0) - (equipmentAmountTotal != null ? equipmentAmountTotal : 0);
//                netIncomeList.add(netIncome);
            }
        }

        model.addAttribute("dataOfMonthList", dataOfMonthList);
        model.addAttribute("rechargeAmountList", rechargeAmountList);
        model.addAttribute("equipmentAmountList", equipmentAmountList);
//        model.addAttribute("netIncomeList", netIncomeList);

        return "selectPayment";
    }
}
