package com.camperxoffice.dashboard.Controller;

import com.camperxoffice.dashboard.Service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
    @Autowired
    DashboardService service;

    @RequestMapping("/capmerX_dashboard")
    public String capmerX_dashboard() throws Exception {
        return "dashboard/dashboard";
    }
}
