package com.camperxoffice.login.service;

import com.camperxoffice.login.dao.loginDao;
import com.vo.admin.AdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class loginService {
    @Autowired
    loginDao dao;

    public AdminVO setreactloginId(AdminVO vo) throws Exception{
        return dao.setreactloginId(vo);
    }

    public AdminVO setreactloginPwd(AdminVO vo) throws Exception{
        return dao.setreactloginPwd(vo);
    }
}
