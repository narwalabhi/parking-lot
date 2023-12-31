package models;

import exception.InvalidBillException;
import exception.InvalidBillingAmountException;
import exception.InvalidTransactionNumber;
import models.constants.PaymentMode;
import models.constants.PaymentStatus;

public class Payment extends BaseModel {

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
        this.paymentStatus = PaymentStatus.IN_PROGRESS;
        this.bill = builder.bill;
    }

    public int getAmount() {
        return amount;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public Bill getBill() {
        return bill;
    }

    public static class Builder {
        public int id;
        public String createdBy;
        private int amount;
        private PaymentMode paymentMode;
        private String transactionNumber;
        private Bill bill;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder amount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder paymentMode(PaymentMode paymentMode) {
            this.paymentMode = paymentMode;
            return this;
        }

        public Builder transactionNumber(String transactionNumber) {
            this.transactionNumber = transactionNumber;
            return this;
        }

        public Builder bill(Bill bill) {
            this.bill = bill;
            return this;
        }

        public Payment build() throws InvalidBillingAmountException, InvalidTransactionNumber, InvalidBillException {
            verify();
            return new Payment(this);
        }

        private void verify() throws InvalidBillingAmountException, InvalidTransactionNumber, InvalidBillException {
            verifyAmount();
            verifyPaymentMode();
            verifyTransactionNumber();
            verifyBill();
        }

        private void verifyBill() throws InvalidBillException {
            if (bill == null) {
                throw new InvalidBillException("Bill cannot be null");
            }
        }

        private void verifyTransactionNumber() throws InvalidTransactionNumber {
            if (transactionNumber == null) {
                throw new InvalidTransactionNumber("Transaction Number cannot be null");
            }
        }

        private void verifyPaymentMode() {
            if (paymentMode == null) {
                paymentMode = PaymentMode.CASH;
            }
        }

        private void verifyAmount() throws InvalidBillingAmountException {
            if (amount <= 0) {
                throw new InvalidBillingAmountException("Amount cannot be less than or equal to zero");
            }
        }

    }


}
