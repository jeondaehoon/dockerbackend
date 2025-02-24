package com.camperxoffice.user.controller;

import com.camperxoffice.user.service.userService;
import com.vo.order.OrderVO;
import com.vo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class userController {
    @Autowired
    userService service;

    @RequestMapping("/camperX_userInfo")
    public String capmerX_userInfo() throws Exception {
        return "user/userInfo";
    }

    @RequestMapping("/camperX_userService")
    public String capmerX_userService() throws Exception {
        return "user/userService";
    }

    @RequestMapping("/react/userSearch")
    @ResponseBody
    public List<UserVO> setreactuserSearch(@ModelAttribute UserVO vo) throws Exception{
        List<UserVO> list = service.setreactuserSearch(vo);
        return list;
    }

    @RequestMapping("/react/detailSearch")
    @ResponseBody
    public List<UserVO> setreactdetailSearch(@ModelAttribute UserVO vo) throws Exception{
        List<UserVO> list = service.setreactdetailSearch(vo);
        return list;
    }

    @RequestMapping("/react/custSearch")
    @ResponseBody
    public List<UserVO> setreactcustSearch(@ModelAttribute UserVO vo) throws Exception{
        List<UserVO> list = service.setreactcustSearch(vo);
        return list;
    }

    @RequestMapping("/react/custDetaulSearch")
    @ResponseBody
    public List<UserVO> setreactcustDetailSearch(@ModelAttribute UserVO vo) throws Exception{
        List<UserVO> list = service.setreactcustDetailSearch(vo);
        return list;
    }

    @RequestMapping("/react/custMaincodeSearch")
    @ResponseBody
    public List<UserVO> setreactMaincodeSearch(@ModelAttribute UserVO vo) throws Exception{
        List<UserVO> list = service.setreactMaincodeSearch(vo);
        return list;
    }

    @RequestMapping("/react/custNamedescSearch")
    @ResponseBody
    public List<UserVO> setreactcustNamedescSearch(@RequestParam("custMaincode") String custMaincode) throws Exception {
        UserVO vo = new UserVO();
        vo.setCustMaincode(custMaincode);
        List<UserVO> list = service.setreactcustNamedescSearch(vo);
        return list;
    }

    @RequestMapping("/react/custUpdate")
    @ResponseBody
    public boolean setreactcustUpdate(@RequestBody UserVO vo) throws Exception {
        if (vo.getCustMaincode() == null || vo.getCustComment() == null || vo.getAdminId() == null) {
            return false;
        }
        int result = service.setreactcustUpdate(vo);
        return result > 0;
    }

}
