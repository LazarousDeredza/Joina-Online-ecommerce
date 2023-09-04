package com.joina.joinaonline.Tenants.PropertyManager.PropertyManagement;

public class PropertyManagementModelClass {
  String propertyName;
  String propertyAddress;
  String propertyDate;

  public String getPropertyName() {
    return propertyName;
  }

  public String getPropertyAddress() {
    return propertyAddress;
  }

  public String getPropertyDate() {
    return propertyDate;
  }

  public PropertyManagementModelClass(String propertyName, String propertyAddress, String propertyDate) {
    this.propertyName = propertyName;
    this.propertyAddress = propertyAddress;
    this.propertyDate = propertyDate;
  }
}
