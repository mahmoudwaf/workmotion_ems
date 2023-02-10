package com.workmotion.controller;

import com.workmotion.entity.Employee;
import com.workmotion.enums.EmployeeState;
import com.workmotion.enums.Event;
import com.workmotion.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping()
    @ApiOperation(value = "Add new employee" , notes = "Add new employee to workmotion database" , response = String.class ,httpMethod = "POST")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{empId}")
    @ApiOperation(value = "fetch employee details" , notes = "fetch employee details" , response = String.class ,httpMethod = "GET")
    public Employee fetchEmployeeDetails(@PathVariable long empId) throws Exception{
        return employeeService.fetchEmployeeDetails(empId);
    }

    @PutMapping("/updateEmployeeState")
    @ApiOperation(value = "update employee state" , notes = "update employee state" , response = String.class ,httpMethod = "PUT")
    public Employee updateEmployeeState(@RequestParam long empId , @RequestParam Event event) throws Exception{
        return  employeeService.updateEmployeeState(empId , event);
    }
}
