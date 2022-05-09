package org.zerock.controller.ex04;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex07")
public class Ex07Controller {

	@RequestMapping("sub01")
	public String method01() {
		// 1.request parameter 수집 가공
		// 2.business 로직처리
		// 3.add attribute
		// 4.forward/redirect
		
		return "redirect:http://www.naver.com";
	}
	
	@RequestMapping("sub02")
	public String method02(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// ex06/sub01로 redirection
		
		String location = request.getContextPath() + "/ex06/sub01";
		response.sendRedirect(location);
		
		return null;
	}
	
	@RequestMapping("sub03")
	public String method02() {
		// ex07/sub03
		// ex06/sub01로 redirection
		
		return "redirect:/ex06/sub01";
	}
	
	@RequestMapping("sub04")
	public String method03() {
		// ex06/sub05로 리디렉션하는 코드 작성
		return "redirect:/ex06/sub05";
	}
	
	
	
}
