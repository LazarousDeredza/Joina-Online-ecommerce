package com.joina.joinaonline.JoinaonlineTenants.Settings.Discount;

public class DiscountListModelClass {
    String discName;
    String discPercentage;
    String discType;
    String startDate;
    String endDate;

    public DiscountListModelClass(String discName, String discPercentage, String discType, String startDate, String endDate) {
        this.discName = discName;
        this.discPercentage = discPercentage;
        this.discType = discType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getDiscName() {
        return discName;
    }

    public String getDiscPercentage() {
        return discPercentage;
    }

    public String getDiscType() {
        return discType;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }
}
