package com.milotnt.controller;

import com.milotnt.pojo.Equipment;
import com.milotnt.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 管理员系统的器材管理
 */

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    //查询器材
    @RequestMapping("/selEquipment")
    public String selectEquipment(Model model, HttpSession session) {
        List<Equipment> equipmentList = equipmentService.findAll();
        session.setAttribute("equipmentList", equipmentList);
        model.addAttribute("equipmentList", equipmentList);
        return "selectEquipment";
    }

    //删除器材
    @RequestMapping("/delEquipment")
    public String deleteEquipment(Integer equipmentId) {
        equipmentService.deleteByEquipmentId(equipmentId);
        return "redirect:selEquipment";
    }

    //跳转修改器材页面
    @RequestMapping("/toUpdateEquipment")
    public String toUpdateEquipment(Integer equipmentId, Model model) {
        List<Equipment> equipmentList = equipmentService.selectByEquipmentId(equipmentId);
        model.addAttribute("equipmentList", equipmentList);
        return "updateEquipment";
    }

    //修改器材
    @RequestMapping("/updateEquipment")
    public String updateEquipment(Equipment equipment) {
        equipmentService.updateEquipmentByEquipmentId(equipment);
        return "redirect:selEquipment";
    }

    //跳转新增器材页面
    @RequestMapping("/toAddEquipment")
    public String toAddEquipment() {
        return "addEquipment";
    }

//    //新增器材
//    @RequestMapping("/addEquipment")
//    public String addEquipment(Equipment equipment) {
//        equipmentService.insertEquipment(equipment);
//        return "redirect:selEquipment";
//    }

    //新增器材
    @RequestMapping("/addEquipment")
    public String addEquipment(Equipment equipment) {
        //获取当前日期
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDay = simpleDateFormat.format(date);

//        for (int i = 0; i < num; i++) {
//            Equipment equipment = new Equipment(null,equipmentName,equipmentName);
//            //新增器材
//            equipmentService.insertEquipment(equipment);
//        }

        equipment.setPurchaseTime(nowDay);

        equipmentService.insertEquipment(equipment);

        return "redirect:selEquipment";
    }

}
