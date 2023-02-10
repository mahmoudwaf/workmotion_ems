package com.workmotion.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class StateException extends Exception{
    private String errorCode;
    private String errorMessage;
}
