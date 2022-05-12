package org.zerock.controller.ex09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.domain.ex01.EmployeeDto;
import org.zerock.domain.ex01.PageInfoDto;
import org.zerock.service.ex02.Ex04Service;

@Controller
@RequestMapping("ex14")
public class Ex14Controller {
	
	@Autowired
	private Ex04Service service;
	

	@RequestMapping("sub01")
	public void method01(int id, Model model) {
		
		//1.request parameter 
		//2.business logic
		String name = service.getNameById(id);
		//3.model.addAttribute
		model.addAttribute("name", name);
		//4.forward/redirect
	}
	
	// ex14/sub02?id=3
	// view에서 Employee의 firstName이 출력 되도록
	
	// controller.method02
	// service method
	// mapper method
	// jsp
	
	
	
	@RequestMapping("sub02")
	public void method02(int id, Model model) {
		
		String firstName = service.getEmployeeFirstNameById(id);
		model.addAttribute("employeeName", firstName);
	}
	
	
	
	// ex14/sub03?id=3
	@RequestMapping("sub03")
	public void method03(int id, Model model) {
		CustomerDto dto = service.getCustomerInfoById(id);
		
		model.addAttribute("customer", dto);
		
	}
	
	
	
	// ex14/sub04?id=7
	// 직원의 FirstName, LastName 이 모두 jsp 출력되도록
	
	// controller method
	// service method
	// mapper method
	// jsp - 새로 작성
	// EmployeeDto - 새로 작성
	
	@RequestMapping("sub04")
	public void method04(int id, Model model) {
		
		EmployeeDto dto = service.getEmployeeInfoById(id);
		
		
		model.addAttribute("employee", dto);
	}
	
	
	@GetMapping("sub05")
	public void method05() {
		// form 있는 jsp forward
	}
	
	@PostMapping("sub05")
	public String method06(CustomerDto customer, RedirectAttributes rttr) {
		
		//1. request
		System.out.println(customer);
		//2.
		boolean ok = service.addCustomer(customer);
		//3.
		if (ok) {
			rttr.addFlashAttribute("message", "등록완료");
			
		}else {
			rttr.addFlashAttribute("message", "등록실패");
		}
		//4.
		return "redirect:/ex14/sub05";
		
	}
	
	/* 직원등록 */
	@GetMapping("sub06")
	public void employeeInputForm() {
		
	}
	
	
	@PostMapping("sub06")
	public String addEmployeeProcess(EmployeeDto dto, RedirectAttributes rttr) {
		
		boolean success = service.addEmployee(dto);
		if (success) {
			rttr.addFlashAttribute("message","등록완료");
		}else {
			rttr.addFlashAttribute("message", "등록실패");
		}
		
		return "redirect:/ex14/sub06";
	}
	
	@GetMapping("sub07")
	public void method07(Model model) {
		List<EmployeeDto> list = service.listEmployee();
		
		model.addAttribute("employees", list);
	}
	
	@GetMapping("sub08")
	public void method08(Model model) {
		List<CustomerDto> list = service.listCustomer();
		
		model.addAttribute("customers", list);
	}
	
	
	// ex14/sub09?page=3
	@GetMapping("sub09")
	public String method09(@RequestParam(name="page", defaultValue = "1") int page, Model model) {
		
		int rowPerPage = 5; // 한 페이지당 몇 개 보여주는지
		
		List<CustomerDto> list = service.listCustomerPage(page, rowPerPage);
		
		int totalRecords = service.countCustomers();
		
		int end = (totalRecords -1) / rowPerPage + 1;
		
		PageInfoDto pageInfo = new PageInfoDto();
		pageInfo.setCurrent(page);
		pageInfo.setEnd(end);
		
		
		model.addAttribute("customers",list);
		model.addAttribute("pageInfo",pageInfo);
		return "/ex14/sub09";
	}
	
}







































