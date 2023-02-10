package com.workmotion.enums;

public enum EmployeeState {
    ADDED{
        @Override
        public EmployeeState nextState() {
            return EmployeeState.IN_CHECK;
        }
    },
    IN_CHECK{
        @Override
        public EmployeeState nextState() {
            return EmployeeState.APPROVED;
        }
    },
    APPROVED{
       @Override
       public EmployeeState nextState() {
           return EmployeeState.ACTIVE;
       }
   },
    ACTIVE{
        @Override
        public EmployeeState nextState() {
            return null;
        }
    };

    public abstract EmployeeState nextState();


}
