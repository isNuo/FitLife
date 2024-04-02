package com.milotnt.pojo;

import lombok.Data;

/**
 * 课程实体类
 */

@Data
public class ClassTable {

    private Integer classId;
    private String className;
    private String classBegin;
    private String classTime;
    private Integer classAmount;
    private Integer coachAccount;

}
