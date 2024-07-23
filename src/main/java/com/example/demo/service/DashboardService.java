package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DashboardDao;

@Service
public class DashboardService {

    @Autowired
    private DashboardDao dashboardDao;

    public int getTotalProfessors() {
        return dashboardDao.getTotalProfessors();
    }

    public int getTotalAsesorias() {
        return dashboardDao.getTotalAsesorias();
    }

    public int getTotalStudents() {
        return dashboardDao.getTotalStudents();
    }

    public int getTotalSessions() {
        return dashboardDao.getTotalSessions();
    }
}
