package com.workmotion.service;

import com.workmotion.entity.Employee;
import com.workmotion.enums.EmployeeState;
import com.workmotion.enums.Event;
import com.workmotion.enums.SecurityCheckState;
import com.workmotion.enums.WorkPermitCheckState;
import com.workmotion.exception.EmployeeNotFoundException;
import com.workmotion.exception.StateException;
import com.workmotion.repo.EmployeeRepository;
import com.workmotion.util.ValidateTransition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        employee.setEmpState(EmployeeState.ADDED);
        employee.setStateDate(Date.valueOf(LocalDate.now()));
        return employeeRepository.save(employee);
    }

    public Employee fetchEmployeeDetails(long empId) throws Exception {
        Optional<Employee> employeeOpt = employeeRepository.findById(empId);
        if (!employeeOpt.isPresent()) {
            throw new EmployeeNotFoundException("Err001", "Employee Not found");
        }
        return employeeOpt.get();
    }

    public Employee updateEmployeeState(long empId, Event event) throws Exception {
        Optional<Employee> employeeOpt = employeeRepository.findById(empId);
        if (!employeeOpt.isPresent()) {
            throw new EmployeeNotFoundException("Err001", "Employee Not found");
        }

        Employee employee = employeeOpt.get();
        if (!ValidateTransition.isValidTransition(employee, event)) {
            throw new StateException("Err002", "Invalid Transition");
        }
        if (event.employeeState() != null) {
            employee.setEmpState(event.employeeState());
        }
        if (event.securityCheckState() != null) {
            employee.setSecurityCheckState(event.securityCheckState());
        }
        if (event.workPermitCheckState() != null) {
            employee.setWorkPermitCheckState(event.workPermitCheckState());
        }

        if(employee.getEmpState().equals(EmployeeState.IN_CHECK) &&  employee.getSecurityCheckState() != null && employee.getWorkPermitCheckState() != null) {
            if (employee.getSecurityCheckState().equals(SecurityCheckState.SECURITY_CHECK_FINISHED) && employee.getWorkPermitCheckState().equals(WorkPermitCheckState.WORK_PERMIT_CHECK_FINISHED)) {
                employee.setEmpState(EmployeeState.APPROVED);
            }
        }
        employee.setStateDate(Date.valueOf(LocalDate.now()));

        return employeeRepository.save(employee);

    }
}
