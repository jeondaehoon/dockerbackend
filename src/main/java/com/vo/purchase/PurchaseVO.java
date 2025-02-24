package com.vo.purchase;

import lombok.Data;

@Data
public class PurchaseVO {

    private String purchaseCode;
    private String vendorCode;
    private String prdCode;
    private String purchaseQty;
    private String inboundPrice;
    private String purchaseDate;
    private String purchaseStatus;
    private String purchaseIndate;
}
