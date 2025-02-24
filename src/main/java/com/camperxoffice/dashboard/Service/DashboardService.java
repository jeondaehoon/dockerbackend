package com.camperxoffice.dashboard.Service;

import com.camperxoffice.dashboard.dao.DashboardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @Autowired
    DashboardDao Dao;
}
