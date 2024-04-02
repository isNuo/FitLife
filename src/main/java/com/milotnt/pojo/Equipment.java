package com.milotnt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 健身器材实体类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {

    private Integer equipmentId;
    private String equipmentName;
    private String equipmentLocation;
    private String equipmentStatus;   //状态
    private Double unitPrice;  //单价
    private Integer equipmentNumber;  //数量
    private String purchaseTime;  //购买时间
    private String equipmentMessage;    //备注信息

//    public Equipment(){}
//
    public Equipment(Integer equipmentId, String equipmentName, Double unitPrice, String purchaseTime) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.unitPrice = unitPrice;
        this.purchaseTime = purchaseTime;
    }

}
