package com.camperxoffice.order.controller;

import com.camperxoffice.order.service.orderService;
import com.vo.order.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class orderController {
    @Autowired
    orderService service;

    @RequestMapping("/camperX_orderProcess")
    public String camperX_orderProcess() throws Exception {
        return "order/orderProcess";
    }

    @RequestMapping("/camperX_orderHistory")
    public String capmerX_orderHistory() throws Exception {
        return "order/orderHistory";
    }

    @RequestMapping("/camperX_orderCancel")
    public String camperX_orderCancel() throws Exception {
        return "order/orderCancel";
    }

    @RequestMapping("/order/search")
    @ResponseBody
    public List<OrderVO> setorderSearch(@ModelAttribute OrderVO vo) throws Exception {
        List<OrderVO> list = service.setorderSearch(vo);
        return list;
    }

    @RequestMapping("/order/Shipped")
    @ResponseBody
    public boolean orderShipped(@ModelAttribute OrderVO vo) throws Exception{
        if (vo.getOrderArry() == null || vo.getOrderArry().length == 0) {
            return false;
        }
        int c = 0;
        for (int i = 0; i < vo.getOrderArry().length; i++) {
            if (vo.getOrderArry()[i] != null && !"".equals(vo.getOrderArry()[i])) {
                OrderVO newVo = new OrderVO();
                newVo.setOrdCode(vo.getOrderArry()[i]);
                c += service.orderShipped(newVo);
            }
        }
        return c > 0;
    }

    @RequestMapping("/order/Delivered")
    @ResponseBody
    public boolean orderDelivered(@ModelAttribute OrderVO vo) throws Exception{
        if (vo.getOrderArry() == null || vo.getOrderArry().length == 0) {
            return false;
        }
        int c = 0;
        for (int i = 0; i < vo.getOrderArry().length; i++) {
            if (vo.getOrderArry()[i] != null && !"".equals(vo.getOrderArry()[i])) {
                OrderVO newVo = new OrderVO();
                newVo.setOrdCode(vo.getOrderArry()[i]);
                c += service.orderDelivered(newVo);
            }
        }
        return c > 0;
    }

    @RequestMapping("/order/history")
    @ResponseBody
    public List<OrderVO> HistoryList(@ModelAttribute OrderVO vo) throws Exception {
        List<OrderVO> list = service.HistoryList(vo);
        return list;
    }

    @RequestMapping("/order/Return")
    @ResponseBody
    public List<OrderVO> ReturnList(@ModelAttribute OrderVO vo) throws Exception {
        List<OrderVO> list = service.ReturnList(vo);
        return list;
    }

    @RequestMapping("/order/update")
    @ResponseBody
    public boolean orderupdate(@ModelAttribute OrderVO vo) throws Exception{
        if (vo.getOrderArry() == null || vo.getOrderArry().length == 0) {
            return false;
        }
        int c = 0;
        for (int i = 0; i < vo.getOrderArry().length; i++) {
            if (vo.getOrderArry()[i] != null && !"".equals(vo.getOrderArry()[i])) {
                OrderVO newVo = new OrderVO();
                newVo.setOrdCode(vo.getOrderArry()[i]);
                c += service.orderupdate(newVo);
            }
        }
        return c > 0;
    }


    @GetMapping("/api/data")
    @ResponseBody
    public String test() {
        System.out.println("Call Server");
        return "Hello, world!!!!";
    }

    //react!!!!
    @RequestMapping("/react/OrdSearch")
    @ResponseBody
    public List<OrderVO> setReactOrdSearch(@ModelAttribute OrderVO vo) throws Exception {
        List<OrderVO> list = service.setReactOrdSearch(vo);
        return list;
    }

    @RequestMapping("/react/OrderDetails")
    @ResponseBody
    public List<OrderVO> setReactOrderDetails(@ModelAttribute OrderVO vo) throws Exception {
        List<OrderVO> list = service.setReactOrderDetails(vo);
        return list;
    }

    @RequestMapping("/react/orderHistory")
    @ResponseBody
    public List<OrderVO> setReactorderHistory(@ModelAttribute OrderVO vo) throws Exception {
        List<OrderVO> list = service.setReactorderHistory(vo);
        return list;
    }

    @RequestMapping("/react/Shipped")
    @ResponseBody
    public boolean setReactShipped(@ModelAttribute OrderVO vo) throws Exception{
        if (vo.getOrderArry() == null || vo.getOrderArry().length == 0) {
            return false;
        }
        int c = 0;
        for (int i = 0; i < vo.getOrderArry().length; i++) {
            if (vo.getOrderArry()[i] != null && !"".equals(vo.getOrderArry()[i])) {
                OrderVO newVo = new OrderVO();
                newVo.setOrdCode(vo.getOrderArry()[i]);
                c += service.setReactShipped(newVo);
            }
        }
        return c > 0;
    }

    @RequestMapping("/react/Delivered")
    @ResponseBody
    public boolean setReactDelivered(@ModelAttribute OrderVO vo) throws Exception {
        if (vo.getOrderArry() == null || vo.getOrderArry().length == 0) {
            return false;
        }
        int c = 0;
        for (int i = 0; i < vo.getOrderArry().length; i++) {
            if (vo.getOrderArry()[i] != null && !"".equals(vo.getOrderArry()[i])) {
                OrderVO newVo = new OrderVO();
                newVo.setOrdCode(vo.getOrderArry()[i]);
                c += service.setReactDelivered(newVo);
            }
        }
        return c > 0;
    }

    @RequestMapping("/react/cancelsearch")
    @ResponseBody
    public List<OrderVO> setReactcancelsearch(@ModelAttribute OrderVO vo) throws Exception {
        List<OrderVO> list = service.setReactcancelsearch(vo);
        return list;
    }

    @RequestMapping("/react/cancelsDetails")
    @ResponseBody
    public List<OrderVO> setReactcancelsDetails(@ModelAttribute OrderVO vo) throws Exception {
        List<OrderVO> list = service.setReactcancelsDetails(vo);
        return list;
    }

    @RequestMapping("/react/updateCanceling")
    @ResponseBody
    public boolean setReactupdateCanceling(@ModelAttribute OrderVO vo) throws Exception {
        if (vo.getOrderArry() == null || vo.getOrderArry().length == 0) {
            return false;
        }
        int c = 0;
        for (int i = 0; i < vo.getOrderArry().length; i++) {
            if (vo.getOrderArry()[i] != null && !"".equals(vo.getOrderArry()[i])) {
                OrderVO newVo = new OrderVO();
                newVo.setOrdCode(vo.getOrderArry()[i]);
                c += service.setReactupdateCanceling(newVo);
            }
        }
        return c > 0;
    }

    @RequestMapping("/react/updateCancelend")
    @ResponseBody
    public boolean setReactupdateCancelend(@ModelAttribute OrderVO vo) throws Exception {
        if (vo.getOrderArry() == null || vo.getOrderArry().length == 0) {
            return false;
        }
        int c = 0;
        for (int i = 0; i < vo.getOrderArry().length; i++) {
            if (vo.getOrderArry()[i] != null && !"".equals(vo.getOrderArry()[i])) {
                OrderVO newVo = new OrderVO();
                newVo.setOrdCode(vo.getOrderArry()[i]);
                c += service.setReactupdateCancelend(newVo);
            }
        }
        return c > 0;
    }
}

