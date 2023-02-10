package com.workmotion.entity;

import com.workmotion.enums.EmployeeState;
import com.workmotion.enums.SecurityCheckState;
import com.workmotion.enums.WorkPermitCheckState;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "emp_id")
    private long empId;

    @Column(name = "emp_name")
    private String empName;


    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "employee_state")
    @Enumerated(EnumType.STRING)
    private EmployeeState empState;

    @Column(name = "state_date")
    private Date stateDate;

    @Column(name = "security_check_state")
    @Enumerated(EnumType.STRING)
    private SecurityCheckState securityCheckState;

    @Column(name = "work_permit_check_state")
    @Enumerated(EnumType.STRING)
    private WorkPermitCheckState workPermitCheckState;


    @Column(name = "contract_date")
    private Date contractDate;
}
