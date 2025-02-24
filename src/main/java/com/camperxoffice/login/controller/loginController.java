package com.camperxoffice.login.controller;

import com.camperxoffice.login.service.loginService;
import com.vo.admin.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginController {
    @Autowired
    loginService service;

    @RequestMapping("/camperX_adminloginId")
    public String capmerX_adminloginId() throws Exception {
        return "login/loginId";
    }

    @RequestMapping("/camperX_adminloginPwd")
    public String capmerX_adminloginPwd() throws Exception {
        return "login/loginPwd";
    }

    @RequestMapping("/react/loginId")
    @ResponseBody
    public boolean setreactloginId(@RequestBody AdminVO vo) throws Exception{
        AdminVO adminvo = service.setreactloginId(vo);

        if (adminvo != null) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("/react/loginPwd")
    @ResponseBody
    public boolean setreactloginPwd(@RequestBody AdminVO vo) throws Exception{
        AdminVO adminPwd = service.setreactloginPwd(vo);
        if (adminPwd != null){
            return true;
        } else {
            return false;
        }
    }
}
