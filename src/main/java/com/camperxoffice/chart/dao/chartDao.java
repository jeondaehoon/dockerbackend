package com.camperxoffice.chart.dao;

import com.vo.react.ChartVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface chartDao {

    public List<ChartVO> setreactSalesChart(ChartVO vo) throws Exception;

    public List<ChartVO> setreactstockChart(ChartVO vo) throws Exception;

}
