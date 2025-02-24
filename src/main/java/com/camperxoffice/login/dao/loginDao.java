package com.camperxoffice.login.dao;

import com.vo.admin.AdminVO;
import org.springframework.stereotype.Repository;

@Repository
public interface loginDao {

    public AdminVO setreactloginId(AdminVO vo) throws Exception;

    public AdminVO setreactloginPwd(AdminVO vo) throws Exception;
}
