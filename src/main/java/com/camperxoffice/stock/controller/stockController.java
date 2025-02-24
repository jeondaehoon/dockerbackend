package com.camperxoffice.stock.controller;

import com.camperxoffice.common.service.FileService;
import com.camperxoffice.stock.service.stockService;
import com.camperxoffice.util.Constant;
import com.vo.category.CatVO;
import com.vo.common.FileVO;
import com.vo.product.PrdVO;

import com.vo.stock.StockVO;
import com.vo.subimg.SubImageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class stockController {
    @Autowired
    stockService service;

    @Autowired
    FileService fileservice;

    @RequestMapping("/camperX_stockInfo")
    public String camperX_stockInfo() throws Exception {
        return "stock/stockInfo";
    }

    @RequestMapping("/camperX_stockLog")
    public String camperX_stockLog() throws Exception {
        return "stock/stockLog";
    }

    @RequestMapping("/cat/search")
    @ResponseBody
    public List<CatVO> catsearch(@ModelAttribute CatVO vo)
        throws Exception {
        if(vo.getCatLv()==null || "".equals(vo.getCatLv())) {
            vo.setCatLv("1");
        }
        List<CatVO> list = service.selectCatList(vo);
        return list;
    }


    @RequestMapping("/stock/prdadd")
    @ResponseBody
    public boolean SavePrd(@ModelAttribute PrdVO vo, @RequestParam MultipartFile[] subimgFile) throws Exception {
        // 메인 이미지 처리
        if (vo.getPrdImgFile() != null && !vo.getPrdImgFile().isEmpty()) {
            FileVO fvo = new FileVO();
            fvo.setFile(vo.getPrdImgFile());
            fvo.setOriginPath(Constant.UPLOAD_PATH);
            fvo = fileservice.createFile(fvo);
            vo.setPrdImg(Constant.IMAGE_PATH + "/" + fvo.getFileNm());
        } else {
            vo.setPrdImg("");
        }


        // 카테고리 처리
        if (vo.getSubCode() != null && !"".equals(vo.getSubCode())) {
            vo.setCatCode(vo.getSubCode());
        } else if (vo.getMainCode() != null && !"".equals(vo.getMainCode())) {
            vo.setCatCode(vo.getMainCode());
        }

        String prdCode = service.selectMaxPrdCode();
        vo.setPrdCode(prdCode);

        // 상품 정보 저장
        int save = service.SavePrdInfo(vo);


        // 서브 이미지 처리
        if (subimgFile != null && subimgFile.length > 0) {
            StringBuilder imagePaths = new StringBuilder();

            for (MultipartFile file : subimgFile) {
                if (!file.isEmpty()) {
                    FileVO gvo = new FileVO();
                    gvo.setFile(file);
                    gvo.setOriginPath(Constant.UPLOAD_PATH);
                    gvo = fileservice.createFile(gvo);

                    if (imagePaths.length() > 0) {
                        imagePaths.append(",");
                    }
                    imagePaths.append(Constant.IMAGE_PATH).append("/").append(gvo.getFileNm());
                }
            }

            vo.setPrdSubimg(imagePaths.toString());
        } else {
            vo.setPrdSubimg("");
        }


        // 서브 이미지 정보 저장
        int add = service.SaveSubImg(vo);

        return save > 0 && add > 0;
    }




    @RequestMapping("/stock/search")
    @ResponseBody
    public List<PrdVO> setStockList(@ModelAttribute PrdVO vo) throws Exception {
        List<PrdVO> list = service.setStockList(vo);
        return list;
    }

    @RequestMapping("/stock/stocklist")
    @ResponseBody
    public List<StockVO> setStockListinfo(@ModelAttribute StockVO vo) throws Exception {
        List<StockVO> list = service.setStockListinfo(vo);
        return list;
    }

    @RequestMapping("/stock/DateLog")
    @ResponseBody
    public List<StockVO> setStockDateLog(@ModelAttribute StockVO vo) throws Exception {
        List<StockVO> list = service.setStockDateLog(vo);
        return list;
    }

    @RequestMapping("/react/StockSearch")
    @ResponseBody
    public List<PrdVO> setreactStockSearch(@ModelAttribute PrdVO vo) throws Exception {
        List<PrdVO> list = service.setreactStockSearch(vo);
        return list;
    }

    @RequestMapping("/react/StockDetails")
    @ResponseBody
    public List<PrdVO> setreactStockDetails(@ModelAttribute PrdVO vo) throws Exception {
        List<PrdVO> list = service.setreactStockDetails(vo);
        return list;
    }

    @RequestMapping("/react/StockLog")
    @ResponseBody
    public List<PrdVO> setreactStockLog(@ModelAttribute PrdVO vo) throws  Exception {
        List<PrdVO> list = service.setreactStockLog(vo);
        return list;
    }

    @RequestMapping("/react/stockDateLog")
    @ResponseBody
    public List<StockVO> setreactStockDateLog(@ModelAttribute StockVO vo) throws Exception{
        List <StockVO> list = service.setreactStockDateLog(vo);
        return list;
    }

}

