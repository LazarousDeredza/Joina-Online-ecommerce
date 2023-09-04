package com.joina.joinaonline.SmartParking.Admin.Models;

public class  PaymentModel {
    String cardNumber;
    String amount;
    String paymentMethod;
    String payTime;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public String getPayTime() {
        return payTime;
    }
    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }
    public PaymentModel(String cardNumber, String amount, String paymentMethod, String payTime) {

        this.cardNumber = cardNumber;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.payTime = payTime;

    }
}
