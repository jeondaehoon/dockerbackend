package com.camperxoffice.admin.dao;

import com.vo.admin.AdminVO;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface adminDao {

    public List<AdminVO> setAdminList(AdminVO vo) throws Exception;

    public int adminAdd(AdminVO vo) throws Exception;

    public int adminLeave(AdminVO vo) throws Exception;

    public List<AdminVO> setreactAdminSearch(@ModelAttribute AdminVO vo) throws Exception;

    public List<AdminVO> setreactvendorSearch(@ModelAttribute AdminVO vo) throws Exception;

    public List<AdminVO> setreactadminUnit(@ModelAttribute AdminVO vo) throws Exception;

    public int setreactadminAdd(@RequestBody AdminVO vo) throws Exception;

    public int setreactvendorAdd(@RequestBody AdminVO vo) throws Exception;
}
