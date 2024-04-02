package com.milotnt.pojo;

import lombok.Data;

/**
 * 会员缴费记录实体
 */

@Data
public class MemberPayment {
    private Integer memberPaymentId;
    private Integer memberAccount;
    private Integer rechargeAmount;
    private String rechargeTime;

}
