package com.ddww.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ddww.web.dto.BoardPagingDTO;
import com.ddww.web.service.AnnonyBoardService;
import com.ddww.web.util.Util;

@Controller
public class AnnonyBoardController {
	@Autowired
	AnnonyBoardService annonyBoardService;

@GetMapping("annonyboard")
public String annonyBoard(@RequestParam(value = "page", required = false, defaultValue = "1")int page, Model model) {
	BoardPagingDTO pagingDTO = new BoardPagingDTO();
	System.out.println(page);
	page = (page - 1)*pagingDTO.getPageSize();
	System.out.println(page);
	Map<String, Integer> map = new HashMap<String, Integer>();
	//.put("pageIndex", pagingDTO.getPageIndex());
	map.put("pageSize", pagingDTO.getPageSize());
	map.put("pageIndex", page);
	
	List<Map<String, Object>> list = annonyBoardService.list(map);
	int count = annonyBoardService.count();
	System.out.println(count);
	int pageCount = count /pagingDTO.getPageSize();
	System.out.println("첫 페이지 카운트는" + pageCount);
	if(count % pagingDTO.getPageSize() != 0) {
		pageCount = pageCount+1;
	}
	System.out.println("결과 페이지 카운트는 : " + pageCount);
	model.addAttribute("pageCount", pageCount);
	model.addAttribute("list", list);
	return "annonyboard";
}
@GetMapping("/annonywrite")
public String annonywrite(Model model) {
	String[] arr01 = {"수진","화진","대원","재윤","지선","승리"};
	String[] arr02 = {"집가는","공부하는","자는","코딩하는","사과게임하는",
			"일기쓰는","커피마시는","발표하는","숨쉬는","밥먹는","운동하는","병원가는","지하철타는","버스타는","점프하는","달리는","쉬고있는"};
	int random1 = (int)(Math.random()*arr01.length);
	int random2 = (int)(Math.random()*arr02.length);
	String nickName = arr02[random2] +" " +arr01[random1];
	System.out.println(nickName);
	model.addAttribute("nickName", nickName);
	return "/annonywrite";
}
@PostMapping("/annonywrite")
public String annonywrite(@RequestParam Map<String, Object> map) {
	
	System.out.println(map);
	annonyBoardService.write(map);
	return "redirect:/annonyboard";
}


}
