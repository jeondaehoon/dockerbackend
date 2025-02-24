package com.vo.order;

import lombok.Data;

@Data
public class OrderVO {

    private String ordCode;
    private String userId;
    private String prdName;
    private String buyQty;
    private String returnStatus;
    private String userName;
    private String ordStatus;
    private String totalPrice;

    private String prdCode;
    private String prdColor;

    private String comCode;
    private String comName;
    private String grCode;

    private String userAddress;

    private String returnDate;
    private String returnReq;

    private String[] orderArry;
}
