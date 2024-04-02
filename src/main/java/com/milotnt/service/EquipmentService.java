package com.milotnt.service;

import com.milotnt.pojo.Equipment;

import java.util.List;


public interface EquipmentService {

    //查询所有器材
    List<Equipment> findAll();

    //根据 id 删除器材
    Boolean deleteByEquipmentId(Integer equipmentId);

    //添加器材
    Boolean insertEquipment(Equipment equipment);

    //根据 id 修改器材信息
    Boolean updateEquipmentByEquipmentId(Equipment equipment);

    //根据 id 查询器材
    List<Equipment> selectByEquipmentId(Integer equipmentId);

    //查询器材总数
    Integer selectTotalCount();

    //根据日期（年、月）查询器材购买总金额
    Integer selectByMonth(Integer year ,Integer month);

}
