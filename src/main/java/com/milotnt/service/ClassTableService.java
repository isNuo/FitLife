package com.milotnt.service;

import com.milotnt.pojo.ClassTable;

import java.util.List;

/**
 * @author MiloTnT [milotntspace@gmail.com]
 * @date 2021/8/11
 */

public interface ClassTableService {

    //查询所有课程
    List<ClassTable> findAll();

    //根据 id 删除课程
    Boolean deleteClassByClassId(Integer classId);

    //添加课程
    Boolean insertClass(ClassTable classTable);

    //根据 课程id 查询课程
    ClassTable selectByClassId(Integer classId);

    //根据 教练账号 查询课程
    List<ClassTable> selectByCoachAccount(Integer coachAccount);

}
