package com.ddww.web.dto;

import lombok.Data;

@Data
public class BoardPagingDTO {
	
	private int startRow;
	private int endRow;
	
	//현재 페이지
	private int pageIndex =1;
	
	//페이지 사이즈
	private int pageSize = 10; //한 페이지에 나오는 게시물 개수
	
	private int pageGroupSize = 3; //페이지에 번호 몇 개 보여줄 건지
	
	
	//페이지는 LIMIT (pageIndex-1)*pageSize, pageSize
	
	
}
