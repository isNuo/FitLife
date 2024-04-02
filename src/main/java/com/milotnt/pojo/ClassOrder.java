package com.milotnt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程预约实体类
 */
@Data
@NoArgsConstructor
public class ClassOrder {

    private Integer classOrderId;
    private Integer classId;
    private String className;
    private String memberName;
    private Integer memberAccount;
    private String classBegin;

//    public ClassOrder(Integer classId, String className, String coach, String memberName, Integer memberAccount, String classBegin) {
//        this.classId = classId;
//        this.className = className;
//        this.coach = coach;
//        this.memberName = memberName;
//        this.memberAccount = memberAccount;
//        this.classBegin = classBegin;
//    }

    public ClassOrder(Integer classId, String className, String memberName, Integer memberAccount, String classBegin) {
        this.classId = classId;
        this.className = className;
        this.memberName = memberName;
        this.memberAccount = memberAccount;
        this.classBegin = classBegin;
    }

}
