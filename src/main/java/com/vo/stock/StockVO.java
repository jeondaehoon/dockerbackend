package com.vo.stock;

import lombok.Data;

@Data
public class StockVO {

    private String prdCode;
    private String stockSeq;
    private String stockDate;
    private String price;
    private String prdQty;
    private String stockStatus;
    private String notes;


    private String prdName;
    private String safetyStock;

    private String inChatge;
    private String purchaseQty;

    private String catName;
    private String comName;

    private String[] stockArry;
}

