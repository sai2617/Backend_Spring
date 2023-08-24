package com.example.Register_login.Service;

import org.springframework.stereotype.Service;

import com.example.Register_login.Dto.EmployeeDto;
import com.example.Register_login.Dto.LoginDto;
import com.example.Register_login.response.LoginResponse;

@Service
public interface EmployeeService {
	String addEmployee(EmployeeDto employeeDTO);
	
	LoginResponse loginEmployee(LoginDto loginDTO);
}
