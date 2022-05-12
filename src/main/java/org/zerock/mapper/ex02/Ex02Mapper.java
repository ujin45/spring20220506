package org.zerock.mapper.ex02;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.domain.ex01.EmployeeDto;

public interface Ex02Mapper {

	@Select("SELECT CustomerName FROM Customers WHERE CustomerID = #{id}")
	String selectNameById(int id);

	@Select("SELECT FirstName FROM Employees WHERE EmployeeID = #{id}")
	String selectFirstEmployeeNameById(int id);

	@Select("SELECT CustomerName AS Name, City, Country "
			+ ", Address FROM Customers WHERE CustomerID = #{id}")
	CustomerDto selectCustomerById(int id);

	
	
	@Select("SELECT FirstName, LastName, BirthDate FROM Employees WHERE EmployeeID = #{id}")
	EmployeeDto selectEmployeeInfoById(int id); // 하나일때

	
	@Insert("INSERT INTO Customers "
			+ "(CustomerName, ContactName, City, Country, Address, PostalCode) "
			+ "VALUES (#{customerName}, #{contactName}, #{city}, #{country}, #{address}, #{postalCode} ) ")
			
	int insertCustomer(CustomerDto customer);


	
	
	
	@Insert("INSERT INTO Employees "
			+ "(FirstName, LastName, BirthDate, Photo, Notes) "
			+ "VALUES (#{firstName}, #{lastName}, #{birthDate}, #{photo}, #{notes} ) ")
	
	int insertEmployee(EmployeeDto dto);
	

	
	@Select("SELECT EmployeeID id, FirstName, LastName, Photo, Notes, BirthDate "
			+ "FROM Employees ORDER BY EmployeeID ")
	  List<EmployeeDto>listEmployee(); // 여러개 조회시 List 

	
	
	
	@Select("SELECT CustomerID id, CustomerName, ContactName, City, Country, Address, PostalCode "
			+ "FROM Customers ORDER BY CustomerID ")
	
	List<CustomerDto> listCustomer();


	
	
	
	@Select("SELECT CustomerID id, CustomerName, ContactName, Address, City, Country, PostalCode "
			+ "FROM Customers "
			+ "LIMIT #{from}, #{row}") // #{from},#{row} 사용이 안 됨. 파라미터가 하나일때만 사용 가능. 지금 두개의 파라미터가 있어서 불가능.
	List<CustomerDto> listCustomerPage(@Param("from")int from, @Param("row") int row);


	
	@Select("SELECT Count(CustomerID) FROM Customers ")
	int countCustomers();
}

















