package org.zerock.controller.ex05;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.ex03.Customer;
import org.zerock.controller.ex03.Employee;

@Controller
@RequestMapping("ex09")
public class Ex09Controller {

	@RequestMapping("sub01")
	public void method01(String name, Model model) {
		
		// 1. request파라미터 수집, 가공
		System.out.println(name);
		// 3. model에 attribute 추가
		model.addAttribute("name", name);
		// 4. view forward : ex09/sub01.jsp
	}
	
	
	// 3. model에 attribute 추가
	// model.addAttribute("name", name);
	@RequestMapping("sub02")
	public String method02(@ModelAttribute("name") String name) {
		
		return "ex09/sub01";
	}
	
	// /ex09/sub03?address=seoul&email=seoul@gmail.com
	@RequestMapping("sub03")
	public void method03(@ModelAttribute("address") String address,
		               	@ModelAttribute("email") String email) {
		
	}
	
	// /ex09/sub04?name=jimin&age=40&address=newyork
	@RequestMapping("sub04")
	public void method04(@ModelAttribute ("customer") Customer cus) {
		
	}
	// /ex09/sub04?name=jimin&age=40&address=newyork
	@RequestMapping("sub05")
	public String method05(@ModelAttribute Customer cus) {
		return "ex09/sub04";
	}
	
	// /ex09/sub04?name=jimin&age=40&address=newyork
	@RequestMapping("sub06")
	public String method06(Customer cus) { //@ModelAttribute 생략가능
		return "ex09/sub04";
	}
	
	// 요청경로 : /ex09/sub07 작성
	// 쿼리스트링 : ?name=sunja&salary=50000&email=sunja@gmail.com
	
	
//	public void method07(HttpServletRequest request) {
//		String name = request.getParameter("name");
//		String salaryStr = request.getParameter("salary");
//		String email = request.getParameter("email");
//		
//		int salary = Integer.parseInt(salaryStr);
//		
//		Employee emp = new Employee();
//		emp.setEmail(email);
//		emp.setName(name);
//		emp.setSalary(salary);
//		
//		request.setAttribute("employee", emp);
//		request.getRequestDispatcher("/WEB-INF/views/ex09/sub07.jsp");
//	}
	
	// 위 과정이 밑의 하나로 작성 가능!!!! 
	@RequestMapping("sub07")
	public void method07(Employee emp) { //@ModelAttribute 생략가능
		
	}
}









