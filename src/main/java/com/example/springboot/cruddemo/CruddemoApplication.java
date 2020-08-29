package com.example.springboot.cruddemo;

import com.example.springboot.cruddemo.dao.EmployeeDaoImpl;
import com.example.springboot.cruddemo.entity.Employee;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//List<Employee> employeeList=new EmployeeDaoImpl().findAll();
	}
}
