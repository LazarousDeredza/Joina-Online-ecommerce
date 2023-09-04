package com.joina.joinaonline.SmartParking.Admin.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TagManagementModel {
//    String cardNumber; card_number
//    String parkerName;  card_type
//    String parkerMobile; mobile
//    String cardStatus; state
//    String startDate; valid_start_date"
//    String endDate; valid_end_date"

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("updated_at")
    @Expose
    private String updated_at;
    @SerializedName("created_by")
    @Expose
    private String created_by;
    @SerializedName("updated_by")
    @Expose
    private String updated_by;

    @SerializedName("card_number")
    @Expose
    private String cardNumber;
    @SerializedName("card_in_use")
    @Expose
    private String card_in_use;
    @SerializedName("auth")
    @Expose
    private String auth;
    @SerializedName("balance")
    @Expose
    private String balance;
    @SerializedName("car_brand")
    @Expose
    private String car_brand;
    @SerializedName("car_color")
    @Expose
    private String car_color;
    @SerializedName("car_type")
    @Expose
    private String car_type;
    @SerializedName("card_no")
    @Expose
    private String card_no;
    @SerializedName("card_type")
    @Expose
    private String parkerName;
    @SerializedName("charge_type")
    @Expose
    private String charge_type;

    @SerializedName("create_date")
    @Expose
    private String create_date;

    @SerializedName("foregift")
    @Expose
    private String foregift;

    @SerializedName("lot_no")
    @Expose
    private String lot_no;

    @SerializedName("mobile")
    @Expose
    private String parkerMobile;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("passage_codes")
    @Expose
    private String passage_codes;

    @SerializedName("plate")
    @Expose
    private String plate;

    @SerializedName("remarks")
    @Expose
    private String remarks;

    @SerializedName("state")
    @Expose
    private String cardStatus;

    @SerializedName("sub_monthly")
    @Expose
    private String sub_monthly;

    @SerializedName("update_date")
    @Expose
    private String update_date;

    @SerializedName("valid_end_date")
    @Expose
    private String endDate;

    @SerializedName("valid_start_date")
    @Expose
    private String startDate;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCard_in_use() {
        return card_in_use;
    }

    public void setCard_in_use(String card_in_use) {
        this.card_in_use = card_in_use;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getParkerName() {
        return parkerName;
    }

    public void setParkerName(String parkerName) {
        this.parkerName = parkerName;
    }

    public String getCharge_type() {
        return charge_type;
    }

    public void setCharge_type(String charge_type) {
        this.charge_type = charge_type;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getForegift() {
        return foregift;
    }

    public void setForegift(String foregift) {
        this.foregift = foregift;
    }

    public String getLot_no() {
        return lot_no;
    }

    public void setLot_no(String lot_no) {
        this.lot_no = lot_no;
    }

    public String getParkerMobile() {
        return parkerMobile;
    }

    public void setParkerMobile(String parkerMobile) {
        this.parkerMobile = parkerMobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassage_codes() {
        return passage_codes;
    }

    public void setPassage_codes(String passage_codes) {
        this.passage_codes = passage_codes;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getSub_monthly() {
        return sub_monthly;
    }

    public void setSub_monthly(String sub_monthly) {
        this.sub_monthly = sub_monthly;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public TagManagementModel(String cardNumber, String parkerName, String parkerMobile, String cardStatus, String startDate, String endDate) {

        this.cardNumber = cardNumber;
        this.parkerName = parkerName;
        this.parkerMobile = parkerMobile;
        this.cardStatus = cardStatus;
        this.endDate = endDate;
        this.startDate = startDate;
    }
}
