package com.milotnt.mapper;

import com.milotnt.pojo.CoachTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoachTableMapper {

    //查询所有教练
    List<CoachTable> findAll();

    //根据教练账号删除教练
    Boolean deleteCoachByAccount(Integer coachAccount);

    //添加教练
    Boolean insertCoach(CoachTable coachTable);

    //根据教练账号修改教练信息
    Boolean updateCoachByCoachAccount(CoachTable coach);

    //查询教练账号密码
    CoachTable selectByAccountAndPassword(CoachTable coach);

    //根据教练账号查询教练
    CoachTable selectByCoachAccount(Integer coachAccount);

//    //根据课程ID查询教练
//    CoachTable selectByClassId(Integer classId);

    //查询教练数
    Integer selectTotalCount();

    //根据教练账号删除已预约的课程
    Boolean deleteOrderByCoachAccount(Integer coachAccount);

}
