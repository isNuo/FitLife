package com.milotnt.pojo;

import lombok.Data;

/**
 * 会员实体类
 */
@Data
public class Member {

    private Integer memberAccount;
    private String memberPassword;
    private String memberName;
    private String memberGender;
    private Integer memberAge;
    private Integer memberHeight;
    private Integer memberWeight;
    private Long memberPhone;
    private String cardTime;
    private Integer cardBalance;
//    private Integer cardRemainClass;

}
