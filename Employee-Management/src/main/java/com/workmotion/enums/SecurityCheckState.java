package com.workmotion.enums;

public enum SecurityCheckState {
    SECURITY_CHECK_STARTED{
        @Override
        public SecurityCheckState nextState() {
            return SecurityCheckState.SECURITY_CHECK_FINISHED;
        }
    },
    SECURITY_CHECK_FINISHED{
        @Override
        public SecurityCheckState nextState() {
            return null;
        }
    };
    public abstract SecurityCheckState nextState();
}
