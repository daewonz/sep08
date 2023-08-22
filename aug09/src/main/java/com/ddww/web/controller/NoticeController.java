package com.ddww.web.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddww.web.service.NoticeService;
import com.ddww.web.util.Util;

@Controller
public class NoticeController {
@Autowired
private NoticeService noticeService;

@Autowired
private Util util;

	@GetMapping("/notice")
	public String index(Model model, Map<String, Object> map) {
		List<Map<String, Object>> list = noticeService.list();
		
		model.addAttribute("list", list);
		System.out.println(list);
		return "notice";
	}
	
	//2023-08-22
	@GetMapping("/noticeDetail")
	public String noitceDeatil(@RequestParam ("nno") int nno, Model model) {
		System.out.println("엔엔오의 값 : " + nno);
		Map<String, Object> detail = noticeService.detail(nno);
		model.addAttribute("detail", detail);
		System.out.println(detail);
		return "noticeDetail";
	}
	
	//다운로드 처리하기 /download@파일명
	@ResponseBody
	@GetMapping("/download@{fileName}")
	public String download(@PathVariable("fileName")String fileName, HttpServletResponse response) {
		System.out.println(fileName);
		String path = util.uploadPath();
		//System.out.println(path);
		String oriFileName=noticeService.getOriFileName(fileName);
		File serverSideFile = new File(path, fileName);
		try {
			byte[] fileByte = FileCopyUtils.copyToByteArray(serverSideFile);
			response.setContentType("application/octet-stream");
	          response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(oriFileName, "UTF-8")+"\";");
	          response.setHeader("Content-Transfer-Encoding", "binary");
	         response.getOutputStream().write(fileByte);
	         response.getOutputStream().flush();
	         response.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
}
