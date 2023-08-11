package com.ddww.web.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddww.web.dao.BoardDAO;
import com.ddww.web.dto.BoardDTO;
import com.ddww.web.util.Util;

@Service
public class BoardService {
@Autowired
private BoardDAO boardDAO;
@Autowired
private Util util;

public List<BoardDTO> boardList() {
	// TODO Auto-generated method stub
	return boardDAO.boardList();
}

public BoardDTO detail(int bno) {
	//읽음수 +1하기
	boardDAO.readUP(bno);
	
	return boardDAO.detail(bno);
}

public int write(BoardDTO dto) {
	//아이피
	dto.setBip(util.getIp());
	//uuid
	dto.setUuid(UUID.randomUUID().toString());
	
	return boardDAO.write(dto);
}

}
