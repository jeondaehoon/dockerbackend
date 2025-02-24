package com.camperxoffice.order.dao;

import com.vo.order.OrderVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface orderDao {

    public List<OrderVO> setorderSearch(OrderVO vo) throws Exception;

    public int orderShipped(OrderVO vo) throws Exception;

    public int orderDelivered(OrderVO vo) throws Exception;

    public List<OrderVO> HistoryList(OrderVO vo) throws Exception;

    public List<OrderVO> ReturnList(OrderVO vo) throws Exception;

    public int orderupdate(OrderVO vo) throws Exception;

    //react!!!!!!!
    public List<OrderVO> setReactOrdSearch(OrderVO vo) throws Exception;

    public List<OrderVO> setReactOrderDetails(OrderVO vo) throws Exception;

    public List<OrderVO> setReactorderHistory(OrderVO vo) throws Exception;

    public int setReactShipped(OrderVO vo) throws Exception ;

    public int setReactDelivered(OrderVO vo) throws Exception;

    public List<OrderVO> setReactcancelsearch(OrderVO vo) throws Exception;

    public List<OrderVO> setReactcancelsDetails(OrderVO vo) throws Exception;

    public int setReactupdateCanceling(OrderVO vo) throws Exception;

    public int setReactupdateCancelend(OrderVO vo) throws Exception;
}
