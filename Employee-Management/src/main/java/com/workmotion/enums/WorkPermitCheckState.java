package com.workmotion.enums;

public enum WorkPermitCheckState {

    WORK_PERMIT_CHECK_STARTED{
        @Override
        public WorkPermitCheckState nextState() {
            return  WorkPermitCheckState.WORK_PERMIT_CHECK_PENDING_VERIFICATION;
        }
    },
    WORK_PERMIT_CHECK_PENDING_VERIFICATION{
        @Override
        public WorkPermitCheckState nextState() {
            return  WorkPermitCheckState.WORK_PERMIT_CHECK_FINISHED;
        }
    },
    WORK_PERMIT_CHECK_FINISHED{
        @Override
        public WorkPermitCheckState nextState() {
            return null;
        }
    };

    public abstract WorkPermitCheckState nextState();
}
