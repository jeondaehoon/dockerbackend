package com.camperxoffice.stock.service;

import com.camperxoffice.stock.dao.stockDao;
import com.vo.category.CatVO;
import com.vo.product.PrdVO;
import com.vo.stock.StockVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class stockService {
    @Autowired
    stockDao dao;

    public List<CatVO> selectCatList(CatVO vo) throws Exception {
        return dao.selectCatList(vo);
    }

    public int SavePrdInfo(@ModelAttribute PrdVO vo) throws Exception {
        return dao.SavePrdInfo(vo);
    }

    public List<PrdVO> setStockList(PrdVO vo) throws Exception {
        return dao.setStockList(vo);
    }

    public List<StockVO> setStockListinfo(StockVO vo) throws Exception {
        return dao.setStockListinfo(vo);
    }

    public List<StockVO> setStockDateLog(StockVO vo) throws Exception {
        return dao.setStockDateLog(vo);
    }

    public List<PrdVO> setreactStockSearch(PrdVO vo) throws Exception {
        return dao.setreactStockSearch(vo);
    }

    public List<PrdVO> setreactStockDetails(PrdVO vo) throws Exception {
        return dao.setreactStockDetails(vo);
    }

    public int SaveSubImg(@ModelAttribute PrdVO vo) throws Exception {
        return dao.SaveSubImg(vo);
    }

    public String selectMaxPrdCode() throws Exception{
        return dao.selectMaxPrdCode();
    }

    public List<PrdVO> setreactStockLog(PrdVO vo) throws Exception {
        return dao.setreactStockLog(vo);
    }

    public List<StockVO> setreactStockDateLog(StockVO vo) throws Exception{
        return dao.setreactStockDateLog(vo);
    }
}

