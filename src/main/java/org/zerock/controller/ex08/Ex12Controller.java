package org.zerock.controller.ex08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.ex03.Employee;
import org.zerock.service.ex01.Ex01Service;
import org.zerock.service.ex01.Ex02Service;

@Controller
@RequestMapping("ex12")
public class Ex12Controller {

	@Autowired
	private Ex01Service service;
	
//	@Setter(Method_ = @Autowired) : 책에 나와 있음
	@Autowired
	private Ex02Service service2;
	
	@RequestMapping("sub01")
	public void method01() {
		//1.request parameter 
		//2.business logic (오늘 다루는 내용) 
		service.getCustomer(1);
		
		//3.model add attribute
		//4.forward, redirect
	
	}
	
	@RequestMapping("sub02")
	public void method02(Employee e) {
		service2.insertEmplyoee(e);
		
		System.out.println("입력 성공....");
		
	}
}





















