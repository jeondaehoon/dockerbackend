package com.camperxoffice.chart.Service;

import com.camperxoffice.chart.dao.chartDao;
import com.vo.react.ChartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class chartService {
    @Autowired
    chartDao dao;

    public List<ChartVO>setreactSalesChart(ChartVO vo) throws Exception{
        return dao.setreactSalesChart(vo);
    }

    public List<ChartVO>setreactstockChart(ChartVO vo) throws Exception{
        return dao.setreactstockChart(vo);
    }
}
