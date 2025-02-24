package com.camperxoffice.user.service;

import com.camperxoffice.user.dao.userDao;
import com.vo.user.UserVO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class userService {
    @Autowired
    userDao dao;

    public List<UserVO> setreactuserSearch(@ModelAttribute UserVO vo) throws Exception{
        return dao.setreactuserSearch(vo);
    }

    public List<UserVO> setreactdetailSearch(@ModelAttribute UserVO vo) throws Exception{
        return dao.setreactdetailSearch(vo);
    }

    public List<UserVO> setreactcustSearch(@ModelAttribute UserVO vo) throws  Exception{
        return dao.setreactcustSearch(vo);
    }

    public List<UserVO> setreactcustDetailSearch(@ModelAttribute UserVO vo) throws Exception{
        return dao.setreactcustDetailSearch(vo);
    }

    public List<UserVO> setreactMaincodeSearch(@ModelAttribute UserVO vo) throws Exception{
        return dao.setreactMaincodeSearch(vo);
    }

    public List<UserVO> setreactcustNamedescSearch(@ModelAttribute UserVO vo) throws Exception{
        return dao.setreactcustNamedescSearch(vo);
    }

    public int setreactcustUpdate(@RequestBody UserVO vo) throws Exception {
        return dao.setreactcustUpdate(vo);
    }


}
