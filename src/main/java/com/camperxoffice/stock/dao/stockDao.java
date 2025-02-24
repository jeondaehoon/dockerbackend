package com.camperxoffice.stock.dao;

import com.vo.category.CatVO;
import com.vo.product.PrdVO;
import com.vo.stock.StockVO;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Repository
public interface stockDao {

    public List<CatVO> selectCatList(CatVO vo) throws Exception;

    public int SavePrdInfo(@ModelAttribute PrdVO vo) throws Exception;

    public List<PrdVO> setStockList(PrdVO vo) throws Exception;

    public List<StockVO> setStockListinfo(StockVO vo) throws Exception;

    public List<StockVO> setStockDateLog(StockVO vo) throws Exception;

    public List<PrdVO> setreactStockSearch(PrdVO vo) throws Exception;

    public List<PrdVO> setreactStockDetails(PrdVO vo) throws Exception;

    public int SaveSubImg(@ModelAttribute PrdVO vo) throws Exception;

    public String selectMaxPrdCode() throws Exception;

    public List<PrdVO> setreactStockLog(PrdVO vo) throws Exception;

    public List<StockVO> setreactStockDateLog(StockVO vo) throws Exception;
}
