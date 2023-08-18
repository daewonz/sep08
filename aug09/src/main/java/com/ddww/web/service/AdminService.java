package com.ddww.web.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddww.web.dao.AdminDAO;

@Service
public class AdminService {
@Autowired
private AdminDAO adminDAO;

public Map<String, Object> adminLogin(Map<String, Object> map) {
	// TODO Auto-generated method stub
	return adminDAO.adminLogin(map);
}
}
