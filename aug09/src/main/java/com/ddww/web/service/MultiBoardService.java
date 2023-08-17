package com.ddww.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddww.web.dao.MultiBoardDAO;

@Service
public class MultiBoardService {

	@Autowired
	private MultiBoardDAO mbDAO;

	public List<Map<String, Object>> list(int board) {
		// TODO Auto-generated method stub
		return mbDAO.list(board);
	}

	public int mbWrite(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mbDAO.mbWrite(map);
	}

	public Map<String, Object> mbDetail(int mbno) {
		// TODO Auto-generated method stub
		return mbDAO.mbDetail(mbno);
	}
	
}
