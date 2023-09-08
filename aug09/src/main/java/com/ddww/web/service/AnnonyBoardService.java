package com.ddww.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddww.web.dao.AnnonyBoardDAO;

@Service
public class AnnonyBoardService {
@Autowired
AnnonyBoardDAO annonyBoardDAO;

public List<Map<String, Object>> list(Map<String, Integer> map) {
	// TODO Auto-generated method stub
	return annonyBoardDAO.list(map);
}

public void write(Map<String, Object> map) {
	annonyBoardDAO.write(map);
	
}

public int count() {
	// TODO Auto-generated method stub
	return annonyBoardDAO.count();
}
}
