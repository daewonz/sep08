package com.ddww.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ddww.web.service.AdminService;
import com.ddww.web.util.Util;

@Controller
@RequestMapping("/admin")
public class AdminController {
@Autowired
private AdminService adminService;
@Autowired
Util util;

	@GetMapping(value = {"/", "/admin"})
	public String adminIndex() {
		return "redirect:/admin/index";
	}
	
	@PostMapping("/login")
	public String adminLogin(@RequestParam Map<String, Object> map, HttpSession session) {
		//count(아이디 패스워드 같은지), name, 등급
		System.out.println(map);
		Map<String, Object> list = adminService.adminLogin(map);
		System.out.println(list);
		if(util.obj2Int(list.get("count"))== 1 && util.obj2Int(list.get("m_grade")) > 5) {
			System.out.println("통과!");
			
			session.setAttribute("mid", map.get("id"));
			session.setAttribute("mname", list.get("m_name"));
			session.setAttribute("mgrade", list.get("m_grade"));
			//세션 올리기
			//메인으로 이동하기
			return "redirect:/admin/main";
		}else {
			return "redirect:/admin/admin?error=login";
		}
	}
}
