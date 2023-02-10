package com.workmotion.util;

import com.workmotion.entity.Employee;
import com.workmotion.enums.EmployeeState;
import com.workmotion.enums.Event;
import com.workmotion.enums.SecurityCheckState;
import com.workmotion.enums.WorkPermitCheckState;

public class ValidateTransition {

    public static boolean isValidTransition(Employee emp , Event event){
        boolean isValidTransition = true;
        EmployeeState sourceEmployeeState = emp.getEmpState();
        SecurityCheckState sourceSecurityCheckState = emp.getSecurityCheckState();
        WorkPermitCheckState sourceWorkPermitState = emp.getWorkPermitCheckState();

        EmployeeState targetEmployeeState = event.employeeState();
        SecurityCheckState targetSecurityCheckState = event.securityCheckState();
        WorkPermitCheckState targetWorkPermitCheckState = event.workPermitCheckState();

        if(sourceEmployeeState != null && targetEmployeeState != null){
            if(! sourceEmployeeState.nextState().equals(targetEmployeeState)){
                System.out.println("sourceEmployeeState = "+sourceEmployeeState);
                System.out.println("targetEmployeeState = "+targetEmployeeState);
                System.out.println("sourceEmployeeState.nextState() = "+sourceEmployeeState.nextState());
                isValidTransition = false;
            }
        }
        if(sourceSecurityCheckState != null && targetSecurityCheckState != null){
            if(! sourceSecurityCheckState.nextState().equals(targetSecurityCheckState)){
                System.out.println("sourceSecurityCheckState = "+sourceSecurityCheckState);
                System.out.println("targetEmployeeState = "+targetSecurityCheckState);
                System.out.println("sourceSecurityCheckState.nextState() = "+sourceSecurityCheckState.nextState());
                isValidTransition = false;
            }
        }

        if(sourceWorkPermitState != null &&  targetWorkPermitCheckState != null){
            if(! sourceWorkPermitState.nextState().equals(targetWorkPermitCheckState)){
                System.out.println("sourceWorkPermitState = "+sourceWorkPermitState);
                System.out.println("targetWorkPermitCheckState = "+targetWorkPermitCheckState);
                System.out.println("sourceWorkPermitState.nextState() = "+sourceWorkPermitState.nextState());
                isValidTransition = false;
            }
        }



        return isValidTransition;
    }
}
