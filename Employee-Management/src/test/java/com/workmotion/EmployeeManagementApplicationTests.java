package com.workmotion;

import com.workmotion.entity.Employee;
import com.workmotion.enums.EmployeeState;
import com.workmotion.enums.Event;
import com.workmotion.exception.StateException;
import com.workmotion.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
class EmployeeManagementApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired EmployeeService employeeService;
	@Test
	public void givenEmployee_whenAddEmployee_thenReturnEmployee(){

		Employee employee = new Employee();
		employee.setEmpName("Test Emp Name");
		employee.setBirthDate(Date.valueOf("2000-10-10"));
		employee.setEmpState(EmployeeState.ADDED);
		employee.setStateDate(Date.valueOf(LocalDate.now()));

		employee = employeeService.addEmployee(employee);

		Assertions.assertNotNull(employee, "Faild to add new employee");

	}

	@Test
	public void givenEmployee_whenUpdateState_thenReturnEmployee() throws Exception{
		 Employee emp =  employeeService.updateEmployeeState(1, Event.BEGIN_CHECK);
		 Assertions.assertEquals(EmployeeState.IN_CHECK,emp.getEmpState());
	}

}
