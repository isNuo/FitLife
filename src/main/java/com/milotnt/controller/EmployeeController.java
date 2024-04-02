package com.milotnt.controller;

import com.milotnt.pojo.ClassTable;
import com.milotnt.pojo.CoachTable;
import com.milotnt.service.ClassTableService;
import com.milotnt.service.CoachTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 管理员系统的教练（员工）管理
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {

//    @Autowired
//    private EmployeeService employeeService;

    @Autowired
    private ClassTableService classTableService;

    @Autowired
    private CoachTableService coachTableService;

    //查询员工
//    @RequestMapping("/selEmployee")
//    public String selectEmployee(Model model) {
//        List<Employee> employeeList = employeeService.findAll();
//        model.addAttribute("employeeList", employeeList);
//        return "selectEmployee";
//    }

    //查询员工（教练）
    @RequestMapping("/selEmployee")
    public String selectEmployee(Model model) {
        List<CoachTable> coachList = coachTableService.findAll();
//        List<ClassTable> classList = new ArrayList<>();
        // 使用for-each循环获取coachList中的classId
//        for (CoachTable coach : coachList) {
//            int classId = coach.getClassId();
//            // 根据classId查询对应的ClassTable
//            ClassTable classTable = classTableService.selectByClassId(classId);
//            // 将查询到的ClassTable添加到classList中
//            classList.add(classTable);
//        }
        model.addAttribute("coachList", coachList);
//        model.addAttribute("classList", classList);
        return "selectEmployee";
    }

    //跳转新增员工（教练）页面
    @RequestMapping("/toAddEmployee")
    public String toAddEmployee() {
        return "addEmployee";
    }


//    //新增员工
//    @RequestMapping("/addEmployee")
//    public String addEmployee(Employee employee) {
//        //工号随机生成
//        Random random = new Random();
//        String account1 = "1010";
//        for (int i = 0; i < 5; i++) {
//            account1 += random.nextInt(10);
//        }
//        Integer account = Integer.parseInt(account1);
//
//        //获取当前日期
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String nowDay = simpleDateFormat.format(date);
//
//        employee.setEmployeeAccount(account);
//        employee.setEntryTime(nowDay);
//
//        employeeService.insertEmployee(employee);
//
//        return "redirect:selEmployee";
//
//    }

    //新增员工（教练）
    @RequestMapping("/addEmployee")
    public String addEmployee(CoachTable coach) {
        //工号随机生成
        Random random = new Random();
        String account1 = "1010";
        for (int i = 0; i < 5; i++) {
            account1 += random.nextInt(10);
        }
        Integer account = Integer.parseInt(account1);

        //初始密码
        String password = "123456";

        //获取当前日期
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDay = simpleDateFormat.format(date);

        coach.setCoachAccount(account);
        coach.setCoachPassword(password);
        coach.setEntryTime(nowDay);

        coachTableService.insertCoach(coach);

        return "redirect:selEmployee";

    }

//    //删除员工
//    @RequestMapping("/delEmployee")
//    public String deleteEmployee(Integer employeeAccount) {
//        employeeService.deleteByEmployeeAccount(employeeAccount);
//        return "redirect:selEmployee";
//    }

    //删除员工（教练）
    @RequestMapping("/delEmployee")
    public String deleteEmployee(Integer coachAccount) {
        coachTableService.deleteCoachByAccount(coachAccount);
        return "redirect:selEmployee";
    }

//    //跳转员工修改页面
//    @RequestMapping("/toUpdateEmployee")
//    public String toUpdateEmployee(Integer employeeAccount, Model model) {
//        List<Employee> employeeList = employeeService.selectByEmployeeAccount(employeeAccount);
//        model.addAttribute("employeeList", employeeList);
//        return "updateEmployee";
//    }

    //跳转员工（教练）修改页面
    @RequestMapping("/toUpdateEmployee")
    public String toUpdateEmployee(Integer coachAccount, Model model) {
        CoachTable coach = coachTableService.selectByCoachAccount(coachAccount);
        model.addAttribute("coach", coach);
        return "updateEmployee";
    }

//    //修改员工信息
//    @RequestMapping("/updateEmployee")
//    public String updateEmployee(Employee employee) {
//        employeeService.updateMemberByEmployeeAccount(employee);
//        return "redirect:selEmployee";
//    }

    //修改员工（教练）信息
    @RequestMapping("/updateEmployee")
    public String updateEmployee(CoachTable coach) {
        coachTableService.updateCoachByCoachAccount(coach);
        return "redirect:selEmployee";
    }

}
