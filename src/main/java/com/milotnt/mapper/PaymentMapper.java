package com.milotnt.mapper;

import com.milotnt.pojo.MemberPayment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {

    List<MemberPayment> selectByMemberAccount(Integer memberAccount);

    Boolean insertMemberPayment(MemberPayment memberPayment);

    Integer selectByMonth(Integer year,Integer month);
}
