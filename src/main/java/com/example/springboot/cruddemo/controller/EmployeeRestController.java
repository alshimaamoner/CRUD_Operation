package com.example.springboot.cruddemo.controller;

import com.example.springboot.cruddemo.dao.EmployeeDao;
import com.example.springboot.cruddemo.entity.Employee;
import com.example.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService EmployeeService;

    @Autowired
    public EmployeeRestController(EmployeeService EmployeeService) {
        this.EmployeeService = EmployeeService;
    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return EmployeeService.findAll();
    }
    @GetMapping("/employee/{id}")
    public Employee getById(@PathVariable int id){
        Employee employee= EmployeeService.findById(id);
        if(employee==null)
            throw  new RuntimeException("Employee Not Found"+id);
        return employee;
    }
    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        //must pass id
        employee.setId(0);
        EmployeeService.save(employee);
        return employee;
    }
    @PutMapping("/update")
    public Employee update(@RequestBody Employee employee){
        //must pass id
        EmployeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        Employee employee=EmployeeService.findById(id);
        if (employee==null)
            throw new RuntimeException("id not found "+id);
        EmployeeService.deleteById(id);
        return "Employee Deleted Successfully ";
    }
}
