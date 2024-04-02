package com.milotnt.pojo;

import lombok.Data;

import java.time.LocalDate;
/**
 * 教练实体类
 */

@Data
public class CoachTable {

    private Integer coachAccount;
    private String coachPassword;
    private String coachName;
    private String coachGender;
    private String coachAge;
//    private LocalDate entryTime;
    private String entryTime;
//    private Integer classId;
    private String coachMessage;

}
