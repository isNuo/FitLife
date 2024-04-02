package com.milotnt.service;

import com.milotnt.pojo.MemberPayment;

import java.util.List;

public interface MemberPaymentService {

    //根据会员账号查询会员充值记录
    List<MemberPayment> selectByMemberAccount(Integer memberAccount);

    //添加会员充值记录
    Boolean insertMemberPayment(MemberPayment memberPayment);

    //根据日期（年、月）查询会员充值记录
    Integer selectByMonth(Integer year ,Integer month);

}
