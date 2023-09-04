package com.joina.joinaonline.SmartParking.Admin.Models;

public class UsersModel {
    String cardNumber;
    String parkerName;
    String parkerMobile;
    String cardStatus;
    String startDate;
    String endDate;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getParkerName() {
        return parkerName;
    }

    public void setParkerName(String parkerName) {
        this.parkerName = parkerName;
    }

    public String getParkerMobile() {
        return parkerMobile;
    }

    public void setParkerMobile(String parkerMobile) {
        this.parkerMobile = parkerMobile;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public UsersModel(String cardNumber, String parkerName, String parkerMobile, String cardStatus, String startDate, String endDate) {
        this.cardNumber = cardNumber;
        this.parkerName = parkerName;
        this.parkerMobile = parkerMobile;
        this.cardStatus = cardStatus;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
