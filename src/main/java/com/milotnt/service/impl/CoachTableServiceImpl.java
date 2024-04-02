package com.milotnt.service.impl;

import com.milotnt.mapper.CoachTableMapper;
import com.milotnt.pojo.CoachTable;
import com.milotnt.service.CoachTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachTableServiceImpl implements CoachTableService {

    @Autowired
    private CoachTableMapper coachTableMapper;

    @Override
    public List<CoachTable> findAll() {
        return coachTableMapper.findAll();
    }

    @Override
    public Boolean updateCoachByCoachAccount(CoachTable coach) {
        return coachTableMapper.updateCoachByCoachAccount(coach);
    }

    @Override
    public Boolean deleteCoachByAccount(Integer coachAccount) {
        return coachTableMapper.deleteCoachByAccount(coachAccount);
    }

    @Override
    public Boolean insertCoach(CoachTable coachTable) {
        return coachTableMapper.insertCoach(coachTable);
    }

    @Override
    public CoachTable selectByCoachAccount(Integer coachAccount) {
        return coachTableMapper.selectByCoachAccount(coachAccount);
    }

    @Override
    public CoachTable coachLogin(CoachTable coach) {
        return coachTableMapper.selectByAccountAndPassword(coach);
    }

//    @Override
//    public CoachTable selectByClassId(Integer classId) {
//        return coachTableMapper.selectByClassId(classId);
//    }

    @Override
    public Integer selectTotalCount() {
        return coachTableMapper.selectTotalCount();
    }

    @Override
    public Boolean deleteOrderByCoachAccount(Integer coachAccount) {
        return coachTableMapper.deleteOrderByCoachAccount(coachAccount);
    }
}
