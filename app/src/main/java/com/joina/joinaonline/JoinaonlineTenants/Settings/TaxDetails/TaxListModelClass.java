package com.joina.joinaonline.JoinaonlineTenants.Settings.TaxDetails;

public class TaxListModelClass {
    String taxName;
    String taxDescription;
    String taxPercentage;

    public String getTaxName() {
        return taxName;
    }

    public String getTaxDescription() {
        return taxDescription;
    }

    public String getTaxPercentage() {
        return taxPercentage;
    }

    public TaxListModelClass(String taxName, String taxDescription, String taxPercentage) {
        this.taxName = taxName;
        this.taxDescription = taxDescription;
        this.taxPercentage = taxPercentage;
    }
}
