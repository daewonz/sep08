package com.ddww.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ddww.web.service.MultiBoardService;

@Controller
public class MultiBoardController {

	@Autowired
	private MultiBoardService mbService;
	
	
	@GetMapping("/multiboard")
	public String multiboard(@RequestParam(value = "board", required = false, defaultValue = "1") int board, Model model) {
		
		//화면에 보여줄 게시판 목록도 가져오겠습니다.
		List<Map<String, Object>> boardList = mbService.boardList();
		model.addAttribute("boardList", boardList);
		
		List<Map<String, Object>> list = mbService.list(board);
		model.addAttribute("list", list);
		//System.out.println("멀티 보드의 값은" + list);
		
		
		//게시판 이름 가져오기 2023-09-06
		Map<String, Object> catename = mbService.cateName(board);
		model.addAttribute("catename", catename);
		return "multiboard";
	}
	@GetMapping("/mbwrite")
	public String mbwrite(@RequestParam(value = "board", required = false, defaultValue = "1") int board, Model model, HttpSession session) {
		//로그인한 사용자만 접근할 수 있게 해주세요
		if(session.getAttribute("mid") != null) {
			model.addAttribute("board",board);
			return "mbwrite";
			
		}else {
			
			return "redirect:/login.sik?error=login";
		}
	}
	
	@PostMapping("/mbwrite")
	public String mbWrite(@RequestParam Map<String, Object> map, HttpSession session) {
		
		System.out.println(map);
		if(session.getAttribute("mid")!=null) {
			
			
			map.put("mid", session.getAttribute("mid"));
			int result = mbService.mbWrite(map);//이번에는 selectKey라는 기법입니다.
			//System.out.println(result);
			//System.out.println(map);
			return "redirect:/mbdetail?board="+map.get("board")+"&mbno="+map.get("mb_no");
		}else {
			return "redirect:/login.sik?error=login";
		}
	}
	@GetMapping("/mbdetail")
	public String mbDetail(@RequestParam(value = "mbno", required = true) int mbno, Model model) {
		System.out.println(mbno);
		Map<String, Object> detail = mbService.mbDetail(mbno);
		model.addAttribute("detail", detail);
		System.out.println(detail);
		System.out.println(detail.get("mb_content"));
		return "mbdetail";
	}

	
}