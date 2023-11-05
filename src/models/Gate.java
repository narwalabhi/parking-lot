package models;

import exception.InvalidFloorNumberException;
import exception.InvalidGateNumberException;
import exception.InvalidGateTypeException;
import exception.InvalidOperatorException;
import models.constants.GateStatus;
import models.constants.GateType;

public class Gate extends BaseModel {
    private int gateNumber;
    private int floorNumber;
    private GateType gateType;
    private GateStatus status;
    private Operator operator;

    private Gate() {
        super();
    }

    public Gate(Builder builder) {
        super(builder.id, builder.operator.getName());
        this.gateNumber = builder.gateNumber;
        this.status = GateStatus.OPEN;
        this.gateType = builder.gateType;
        this.operator = builder.operator;
    }

//    private Gate(int gateNumber, GateType gateType, Operator operator) {
//        this.gateNumber = gateNumber;
//        this.gateType = gateType;
//        this.status = GateStatus.OPEN;
//        this.operator = operator;
//    }

    public int getGateNumber() {
        return gateNumber;
    }

    public GateType getGateType() {
        return gateType;
    }

    public GateStatus getStatus() {
        return status;
    }

    public Operator getOperator() {
        return operator;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public static class Builder {
        private int id;
        private int gateNumber;
        private GateType gateType;
        private Operator operator;
        private int floorNumber;

        public Builder floorNumber(int floorNumber) {
            this.floorNumber = floorNumber;
            return this;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }


        public Builder gateNumber(int gateNumber) {
            this.gateNumber = gateNumber;
            return this;
        }

        public Builder gateType(GateType gateType) {
            this.gateType = gateType;
            return this;
        }

        public Builder operator(Operator operator) {
            this.operator = operator;
            return this;
        }

        public Gate build() throws InvalidOperatorException, InvalidGateNumberException, InvalidGateTypeException, InvalidFloorNumberException {
            verify();
            return new Gate(this);
        }

        private void verify() throws InvalidGateNumberException, InvalidGateTypeException, InvalidOperatorException, InvalidFloorNumberException {
            verifyGateNumber();
            verifyGateType();
            verifyOperator();
            verifyFloorNumber();
        }

        private void verifyFloorNumber() throws InvalidFloorNumberException {
            if (floorNumber < 0) {
                throw new InvalidFloorNumberException("Invalid floor number");
            }
        }

        private void verifyOperator() throws InvalidOperatorException {
            if (operator == null) {
                throw new InvalidOperatorException("Operator cannot be null");
            }
        }

        private void verifyGateType() throws InvalidGateTypeException {
            if (gateType == null) {
                throw new InvalidGateTypeException("Gate type cannot be null");
            }
        }


        private void verifyGateNumber() throws InvalidGateNumberException {
            if (gateNumber < 0) {
                throw new InvalidGateNumberException("Invalid gate number");
            }
        }
    }

}
