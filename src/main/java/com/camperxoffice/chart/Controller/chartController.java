package com.camperxoffice.chart.Controller;

import com.camperxoffice.chart.Service.chartService;
import com.vo.react.ChartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class chartController {
    @Autowired
    chartService service;

    @RequestMapping("/react/salesChart")
    @ResponseBody
    public List<ChartVO> setreactSalesChart(@ModelAttribute ChartVO vo) throws Exception{
        List<ChartVO> list = service.setreactSalesChart(vo);
        return list;
    }

    @RequestMapping("/react/stockChart")
    @ResponseBody
    public List<ChartVO> setreactstockChart(@ModelAttribute ChartVO vo) throws Exception{
        List<ChartVO> list = service.setreactstockChart(vo);
        return list;
    }
}
