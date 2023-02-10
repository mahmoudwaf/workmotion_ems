package com.workmotion.enums;

public enum Event {
    BEGIN_CHECK{
        @Override
        public EmployeeState employeeState() {
            return EmployeeState.IN_CHECK;
        }

        @Override
        public SecurityCheckState securityCheckState() {
            return SecurityCheckState.SECURITY_CHECK_STARTED;
        }

        @Override
        public WorkPermitCheckState workPermitCheckState() {
            return WorkPermitCheckState.WORK_PERMIT_CHECK_STARTED;
        }
    },
    COMPLETE_INITIAL_WORK_PERMIT_CHECK{
        @Override
        public EmployeeState employeeState() {
            return null;
        }

        @Override
        public SecurityCheckState securityCheckState() {
            return null;
        }

        @Override
        public WorkPermitCheckState workPermitCheckState() {
            return WorkPermitCheckState.WORK_PERMIT_CHECK_PENDING_VERIFICATION;
        }
    },
    FINISH_WORK_PERMIT_CHECK{
        @Override
        public EmployeeState employeeState() {
            return null;
        }

        @Override
        public SecurityCheckState securityCheckState() {
            return null;
        }

        @Override
        public WorkPermitCheckState workPermitCheckState() {
            return WorkPermitCheckState.WORK_PERMIT_CHECK_FINISHED;
        }
    },
    FINISH_SECURITY_CHECK{
        @Override
        public EmployeeState employeeState() {
            return null;
        }

        @Override
        public SecurityCheckState securityCheckState() {
            return SecurityCheckState.SECURITY_CHECK_FINISHED;
        }

        @Override
        public WorkPermitCheckState workPermitCheckState() {
            return null;
        }
    },
    ACTIVATE {
        @Override
        public EmployeeState employeeState() {
            return EmployeeState.ACTIVE;
        }

        @Override
        public SecurityCheckState securityCheckState() {
            return null;
        }

        @Override
        public WorkPermitCheckState workPermitCheckState() {
            return null;
        }
    };

    public abstract EmployeeState employeeState();
    public abstract SecurityCheckState securityCheckState();
    public abstract WorkPermitCheckState workPermitCheckState();
}
