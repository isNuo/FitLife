package com.milotnt.service.impl;

import com.milotnt.mapper.PaymentMapper;
import com.milotnt.pojo.MemberPayment;
import com.milotnt.service.MemberPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberPaymentServiceImpl implements MemberPaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public List<MemberPayment> selectByMemberAccount(Integer memberAccount) {
        return paymentMapper.selectByMemberAccount(memberAccount);
    }

    @Override
    public Boolean insertMemberPayment(MemberPayment memberPayment) {
        return paymentMapper.insertMemberPayment(memberPayment);
    }

    @Override
    public Integer selectByMonth(Integer year, Integer month) {
        return paymentMapper.selectByMonth(year,month);
    }
}
