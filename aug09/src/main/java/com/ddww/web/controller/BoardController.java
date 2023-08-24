package com.ddww.web.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.HTTP;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddww.web.dto.BoardDTO;
import com.ddww.web.service.BoardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
@GetMapping("/board")
public String board(Model model) {
	List<BoardDTO> list =boardService.boardList();
	BoardDTO dto = new BoardDTO();
	System.out.println(list);
	model.addAttribute("list", list);
	return "board";
}
@ResponseBody
@PostMapping("/detail")
public String detail(@RequestParam("bno") int bno) {
	//System.out.println(bno);
	BoardDTO boardDTO = boardService.detail(bno);

	
	JSONObject json = new JSONObject();
	//JSONObject e = new JSONObject();
	//e.put("content", boardDTO.getBcontent());
	//e.put("uuid", boardDTO.getUuid());
	
	json.put("content", boardDTO.getBcontent());
	json.put("uuid", boardDTO.getUuid());
	json.put("ip", boardDTO.getBip());
	
	//json.put("dto", boardDTO);
	System.out.println(json.toString());
	
	return json.toString();
}

@GetMapping("/write")
public String write() {
	return "write";
}
@PostMapping("/write")
public String write(HttpServletRequest request, HttpSession session) {
	//로그인한 사용자만 들어올 수 있습니다.
	BoardDTO dto = new BoardDTO();
	if(session.getAttribute("mid") != null) {
		//HttpSession session = request.getSession();
		System.out.println(request.getParameter("title"));
		System.out.println(request.getParameter("content"));
		dto.setBtitle(request.getParameter("title"));
		dto.setBcontent(request.getParameter("content"));
		dto.setM_id(String.valueOf(session.getAttribute("mid")));
		System.out.println(dto.getBip());
	}else {
		return "redirect:/";
	}
	
	int result;
	result = boardService.write(dto);
	System.out.println(result);
	return "redirect:/board";
}
@PostMapping("/delete")
public String delete(BoardDTO dto) {
	
	System.out.println(dto.getBno());
	System.out.println(dto.getUuid());
	return "redirect:/board";
}
@ResponseBody
@PostMapping("/detail2")
public String detail2(@RequestParam("bno")int bno) throws JsonProcessingException {
	
	BoardDTO detail = boardService.detail2(bno);
	System.out.println("DTO가 보내준 값은 : "+detail);
	ObjectMapper mapp = new ObjectMapper();
	String json = mapp.writeValueAsString(detail);
	//GSON << 구글이 만든 제이슨
	System.out.println(json);
	return json;
}

}
