package com.workmotion.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeNotFoundException extends Exception{
    private String errorCode;
    private String errorMessage;
}
