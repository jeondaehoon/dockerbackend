package com.vo.buy;

import lombok.Data;

@Data
public class BuyVO {

    private String ordCode;
    private String prdCode;
    private String payAmount;
    private String buyQty;
    private String buyIndate;
}
