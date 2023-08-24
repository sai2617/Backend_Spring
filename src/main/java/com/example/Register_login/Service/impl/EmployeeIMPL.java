package com.example.Register_login.Service.impl;

//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.Register_login.Dto.EmployeeDto;
import com.example.Register_login.Dto.LoginDto;
import com.example.Register_login.Entity.Employee;
import com.example.Register_login.Repo.EmployeeRepo;
import com.example.Register_login.Service.EmployeeService;
import com.example.Register_login.response.LoginResponse;

public class EmployeeIMPL implements EmployeeService{
	
	@Autowired
    private EmployeeRepo employeeRepo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
    public String addEmployee(EmployeeDto employeeDTO) {
	   Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),
               this.passwordEncoder.encode(employeeDTO.getPassword())
        );
        employeeRepo.save(employee);
        return employee.getEmployeename();
	}

	@Override
    public LoginResponse loginEmployee(LoginDto loginDto) {
        Employee employee = employeeRepo.findByEmail(loginDto.getEmail());
        if (employee != null) {
            String password = loginDto.getPassword();
            String encodedPassword = employee.getPassword();
            if (passwordEncoder.matches(password, encodedPassword)) {
                return new LoginResponse("Login Success", true);
            } else {
                return new LoginResponse("Password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not found", false);
        }
    }


}
