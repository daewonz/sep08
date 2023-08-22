package com.ddww.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.ddww.web.service.AdminService;
import com.ddww.web.util.Util;

@Controller
@RequestMapping("/admin")	//admin 아래 값을 받아옵니다.
public class AdminController {
@Autowired
private AdminService adminService;
@Autowired
Util util;

@GetMapping("/")
public String adminIndex2() {
   return "redirect:/admin/admin";
}

@GetMapping("/admin")
public String adminIndex() {
   return "admin/index";
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
	@GetMapping("/main")
	public String main() {
		return "admin/main";	//폴더 적어줘야 admin/밑에 main.jsp를 열어줍니다.
	}
	@GetMapping("/notice")
	public String notice(Model model) {
		//데이터베이스까지 연결하기
		//2 데이터불러오기
		//3 데이터 jsp로 보내기
		 List<Map<String, Object>> map =  adminService.notice();
		 model.addAttribute("list", map);
		//System.out.println(map);
		return "admin/notice";
	}
	@PostMapping("/noticeWrite")
	public String noticeWrite(@RequestParam("upFile") MultipartFile upfile, @RequestParam Map<String, Object> map) {
		//매개변수 @RequestParam("upFile") MultipartFile upFile,
		//2023-08-22 요구사항확인
		//
		
		 if(!upfile.isEmpty()) {
			 //저장할 경로명 뽑기 request뽑기
		 HttpServletRequest request =
		((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		 String path =	request.getServletContext().getRealPath("/upload");
		System.out.println("실제경로"+ path);
		
		
		
		
		
		//upFile 정보보기 
		System.out.println(upfile.getOriginalFilename()); 	//어떤 이름인지
		System.out.println(upfile.getSize()); 	//어떤 사이즈인지	 
		System.out.println(upfile.getContentType()); 	//어떤 타입인지 
		//진짜 파일 업로드 하기 
		//String 타입의 경로를 file 형태로 바꿔주겠습니다.
		//File filePath = new File(path);
		//중복이 발생할 수 있기 때문에......파일명+날짜+아이디.파일확장자
		//									UUID+파일명+.확장자
		//									UUID+파일명+아이디+.확장자
		
//		//날짜 뽑기
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmss");
//		String dateTime = sdf.format(date);
		
		
		UUID uuid = UUID.randomUUID();
		String realFileName= uuid.toString() + upfile.getOriginalFilename();
		//다른 날짜 형식 뽑기
		LocalDateTime ldt = LocalDateTime.now();
		String format = ldt.format(DateTimeFormatter.ofPattern("YYYYMMddHHmmss"));
				
		realFileName = format + uuid.toString() +upfile.getOriginalFilename();
		
		File newFileName = new File(path, realFileName);
		try {
			//upfile.transferTo(newFileName);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} //멀티파츠가 파일을 이동시키거나 저장하는 기능이 있어서 사용했습니다./
		
		//System.out.println("저장 끝");
		//스프링 프레임워크에서 제공해주는 FileCopyUtils
		//FileCopyUtils을 사용하기 위해서는 오리지날 파일을 byte[]로 만들어야 합니다.
		try {
			FileCopyUtils.copy(upfile.getBytes(), newFileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("realFile", realFileName);
		map.put("upfile", upfile.getOriginalFilename());
		}
		 
		
		
		
		System.out.println(map);
		//System.out.println(map);
		map.put("mno", 1);
		adminService.noticeWrite(map);
		return "redirect:/admin/notice";
	}
	@GetMapping("/mail")
	public String mail() {
		return "/admin/mail";
	}
	
}
