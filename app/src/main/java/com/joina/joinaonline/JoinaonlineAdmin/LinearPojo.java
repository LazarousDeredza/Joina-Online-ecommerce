package com.joina.joinaonline.JoinaonlineAdmin;

public class LinearPojo {

  private String tvTenantName;
  private String tvTenantShopDescription;
  private String tvTenantFloorNumber;

  public LinearPojo(String tvTenantName,String tvTenantShopDescription,String tvTenantFloorNumber){
    this.tvTenantName = tvTenantName;
    this.tvTenantShopDescription = tvTenantShopDescription;
    this.tvTenantFloorNumber = tvTenantFloorNumber;
  }

  public String getTenantName(){
    return tvTenantName;
  }

  public String getTvTenantShopDescription(){
    return tvTenantShopDescription;
  }

  public String getTvTenantFloorNumber(){
    return tvTenantFloorNumber;
  }

}
