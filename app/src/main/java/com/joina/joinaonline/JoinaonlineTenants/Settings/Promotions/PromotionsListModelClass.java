package com.joina.joinaonline.JoinaonlineTenants.Settings.Promotions;

public class PromotionsListModelClass {

    String promotionName;
    String promotionPercentage;
    String promotionStatus;
    String promoStartDate;
    String promoEndDate;

    public PromotionsListModelClass(String promotionName, String promotionPercentage, String promotionStatus, String promosStartDate, String promoEndDate) {
        this.promotionName = promotionName;
        this.promotionPercentage = promotionPercentage;
        this.promotionStatus = promotionStatus;
        this.promoStartDate = promosStartDate;
        this.promoEndDate = promoEndDate;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public String getPromotionPercentage() {
        return promotionPercentage;
    }

    public String getPromotionStatus() {
        return promotionStatus;
    }

    public String getPromoStartDate() {
        return promoStartDate;
    }

    public String getPromoEndDate() {
        return promoEndDate;
    }
}
