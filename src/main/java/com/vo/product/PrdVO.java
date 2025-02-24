package com.vo.product;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PrdVO {

    private String prdCode;
    private String prdName;
    private String prdColor;
    private String price;
    private String prdDesc;
    private String prdImg;
    private String prdSubimg;
    private String safetyStock;
    private String prdQty;
    private String catName;
    private String prdStatus;

    private String catCode;
    private String mainCode;
    private String subCode;

    private String comName;
    private String imgUrl;
    private String clName;

    private String stockDate;
    private String purchaseQty;
    private String inChatge;
    private String notes;



    @JsonIgnore
    private MultipartFile prdImgFile;
    private MultipartFile[] prdSubimgFile;
    private MultipartFile[] subimgFile;


    private String[] stockArry;
}
