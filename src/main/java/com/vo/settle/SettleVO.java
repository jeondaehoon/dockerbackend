package com.vo.settle;

import lombok.Data;

@Data
public class SettleVO {

    private String settleDate;
    private String totalPrice;
    private String qtySold;
    private String returnAmount;
    private String returnQty;
}
