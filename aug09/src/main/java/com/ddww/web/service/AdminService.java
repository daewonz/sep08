package com.ddww.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddww.web.dao.AdminDAO;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class AdminService {
@Autowired
private AdminDAO adminDAO;

public Map<String, Object> adminLogin(Map<String, Object> map) {
	// TODO Auto-generated method stub
	return adminDAO.adminLogin(map);
}

public List<Map<String, Object>> notice() {
	// TODO Auto-generated method stub
	return adminDAO.notice();
}

public void noticeWrite(Map<String, Object> map) {
	 adminDAO.noticeWrite(map);
	
}

public String noticeDetail(int nno) {
	// TODO Auto-generated method stub
	return adminDAO.noticeDetail(nno);
}

public int noticeHide(int nno) {
	// TODO Auto-generated method stub
	return adminDAO.noticeHide(nno);
}

public List<Map<String, Object>> setupBoardList() {
	return adminDAO.setupBoardList();
	
}

public int multiBoardInsert(Map<String, String> map) {
	// TODO Auto-generated method stub
	return adminDAO.multiBoardInsert(map);
}

public List<Map<String, Object>> memberList() {
	// TODO Auto-generated method stub
	return adminDAO.memberList();
}

public int gradeChange(Map<String, Object> map) {
	// TODO Auto-generated method stub
	return adminDAO.gradeChange(map);
}

public List<Map<String, Object>> post(Map<String, Object> map) {
	// TODO Auto-generated method stub
	return adminDAO.post(map);
}

public List<Map<String, Object>> boardList() {
	// TODO Auto-generated method stub
	return adminDAO.boardList();
}

public Map<String, Object> postDetail(int mbno) {
	// TODO Auto-generated method stub
	return adminDAO.postDetail(mbno);
}
}
