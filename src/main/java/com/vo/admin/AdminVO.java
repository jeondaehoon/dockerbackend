package com.vo.admin;

import lombok.Data;

@Data
public class AdminVO {

    private String adminId;
    private String adminName;
    private String posDept;
    private String adminEmail;
    private String adminPhone;
    private String adminPwd;
    private String adminStatus;
    private String adminJdt;
    private String adminDob;
    private String adminLv;
    private String adminUnit;
    private String deptUnit;

    private String vendorCode;
    private String vendorName;
    private String ceoName;
    private String companyPhone;
    private String inChatge;
    private String contactPerson;
    private String contactEmail;

    private String comCode;
    private String comName;

    private String[] adminArry;
}
