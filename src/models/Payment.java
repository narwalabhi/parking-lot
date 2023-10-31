package models;

import exception.InvalidBillingAmountException;
import models.constants.PaymentMode;
import models.constants.PaymentStatus;

public class Payment extends BaseModel{

    private int amount;
    private PaymentMode paymentMode;
    private String transactionNumber;
    private PaymentStatus paymentStatus;
    private Bill bill;

    public Payment(Builder builder) {
        super(builder.id, builder.createdBy);
        this.amount = builder.amount;
        this.paymentMode = builder.paymentMode;
        this.transactionNumber = builder.transactionNumber;
        this.paymentStatus = builder.paymentStatus;
        this.bill = builder.bill;
    }

    public static class Builder{

        public int id;
        public String createdBy;
        private int amount;
        private PaymentMode paymentMode;
        private String transactionNumber;
        private PaymentStatus paymentStatus;
        private Bill bill;

        public Builder id(int id){
            this.id = id;
            return this;
        }

        public Builder createdBy(String createdBy){
            this.createdBy = createdBy;
            return this;
        }

        public Builder amount(int amount){
            this.amount = amount;
            return this;
        }

        public Builder paymentMode(PaymentMode paymentMode){
            this.paymentMode = paymentMode;
            return this;
        }

        public Builder transactionNumber(String transactionNumber){
            this.transactionNumber = transactionNumber;
            return this;
        }

        public Builder paymentStatus(PaymentStatus paymentStatus){
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Builder bill(Bill bill){
            this.bill = bill;
            return this;
        }

        public Payment build(){
            verify();
            return new Payment(this);
        }

        private void verify() throws InvalidBillingAmountException {
            verifyAmount();
        }

        private void verifyAmount() throws InvalidBillingAmountException {
            if(amount <= 0){
                throw new InvalidBillingAmountException("Amount cannot be less than or equal to zero");
            }
        }

    }


}
