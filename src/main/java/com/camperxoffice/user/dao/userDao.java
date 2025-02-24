package com.camperxoffice.user.dao;

import com.vo.user.UserVO;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface userDao {

    public List<UserVO> setreactuserSearch(@ModelAttribute UserVO vo) throws Exception;

    public List<UserVO> setreactdetailSearch(@ModelAttribute UserVO vo) throws Exception;

    public List<UserVO> setreactcustSearch(@ModelAttribute UserVO vo) throws  Exception;

    public List<UserVO> setreactcustDetailSearch(@ModelAttribute UserVO vo) throws Exception;

    public List<UserVO> setreactMaincodeSearch(@ModelAttribute UserVO vo) throws Exception;

    public List<UserVO> setreactcustNamedescSearch(@ModelAttribute UserVO vo) throws Exception;

    public int setreactcustUpdate(@RequestBody UserVO vo) throws Exception;
}

