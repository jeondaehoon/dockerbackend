package com.camperxoffice.order.service;

import com.camperxoffice.order.dao.orderDao;
import com.vo.order.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class orderService {
    @Autowired
    orderDao dao;

    public List<OrderVO> setorderSearch(OrderVO vo) throws Exception {
        return dao.setorderSearch(vo);
    }

    public int orderShipped(OrderVO vo) throws Exception {
        return dao.orderShipped(vo);
    }

    public int orderDelivered(OrderVO vo) throws Exception {
        return dao.orderDelivered(vo);
    }

    public List<OrderVO> HistoryList(OrderVO vo) throws Exception {
        return dao.HistoryList(vo);
    }

    public List<OrderVO> ReturnList(OrderVO vo) throws Exception {
        return dao.ReturnList(vo);
    }

    public int orderupdate(OrderVO vo) throws Exception {
        return dao.orderupdate(vo);
    }
    //react!!!!!!!!
    public List<OrderVO> setReactOrdSearch(OrderVO vo) throws Exception {
        return dao.setReactOrdSearch(vo);
    }

    public List<OrderVO> setReactOrderDetails(OrderVO vo) throws Exception {
        return dao.setReactOrderDetails(vo);
    }

    public List<OrderVO> setReactorderHistory(OrderVO vo) throws Exception {
        return dao.setReactorderHistory(vo);
    }

    public int setReactShipped(OrderVO vo) throws Exception {
        return dao.setReactShipped(vo);
    }

    public int setReactDelivered(OrderVO vo) throws Exception {
        return dao.setReactDelivered(vo);
    }

    public List<OrderVO> setReactcancelsearch(OrderVO vo) throws Exception {
        return dao.setReactcancelsearch(vo);
    }

    public List<OrderVO> setReactcancelsDetails(OrderVO vo) throws Exception {
        return dao.setReactcancelsDetails(vo);
    }

    public int setReactupdateCanceling(OrderVO vo) throws Exception {
        return dao.setReactupdateCanceling(vo);
    }

    public int setReactupdateCancelend(OrderVO vo) throws Exception {
        return dao.setReactupdateCancelend(vo);
    }
}



