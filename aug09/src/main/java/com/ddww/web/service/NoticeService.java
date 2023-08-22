package com.ddww.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddww.web.dao.NoticeDAO;

@Service
public class NoticeService {
@Autowired
private NoticeDAO noticeDAO;

public List<Map<String, Object>> list() {
	// TODO Auto-generated method stub
	return noticeDAO.list();
}

public Map<String, Object> detail(int nno) {
	// TODO Auto-generated method stub
	return noticeDAO.detail(nno);
}

public String getOriFileName(String fileName) {
	// TODO Auto-generated method stub
	return noticeDAO.getOriFileName(fileName);
}
}
