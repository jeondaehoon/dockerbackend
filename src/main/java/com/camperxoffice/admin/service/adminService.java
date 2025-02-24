package com.camperxoffice.admin.service;

import com.camperxoffice.admin.dao.adminDao;
import com.vo.admin.AdminVO;
import com.vo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class adminService {
    @Autowired
    adminDao dao;

    public List<AdminVO> setAdminList(AdminVO vo) throws Exception {
        return dao.setAdminList(vo);
    }

    public int adminAdd(AdminVO vo) throws Exception {
        return dao.adminAdd(vo);
    }

    public int adminLeave(AdminVO vo) throws Exception {
        return dao.adminLeave(vo);
    }

    public List<AdminVO> setreactAdminSearch(@ModelAttribute AdminVO vo) throws Exception{
        return dao.setreactAdminSearch(vo);
    }

    public List<AdminVO> setreactvendorSearch(@ModelAttribute AdminVO vo) throws Exception{
        return dao.setreactvendorSearch(vo);
    }

    public List<AdminVO> setreactadminUnit(@ModelAttribute AdminVO vo) throws Exception{
        return dao.setreactadminUnit(vo);
    }

    public int setreactadminAdd(@RequestBody AdminVO vo) throws Exception {
        return dao.setreactadminAdd(vo);
    }

    public int setreactvendorAdd(@RequestBody AdminVO vo) throws Exception {
        return dao.setreactvendorAdd(vo);
    }
}
