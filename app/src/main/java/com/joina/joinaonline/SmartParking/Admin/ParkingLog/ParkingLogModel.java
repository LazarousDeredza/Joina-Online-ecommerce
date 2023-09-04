package com.joina.joinaonline.SmartParking.Admin.ParkingLog;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.joina.joinaonline.SmartParking.Admin.Models.TagManagementModel;

public class ParkingLogModel {

//    cardNumber getCard().cardNumber
//    parkerName getCard().parkerName
//    parkerMobile getCard().mobile
//    parkerTimeIn check_in_time
//    parkerTimeOut timeout
//    parkerDuration version

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("version")
    @Expose
    private String parkerDuration;

    @SerializedName("updated_at")
    @Expose
    private String updated_at;

    @SerializedName("created_by")
    @Expose
    private String created_by;

    @SerializedName("updated_by")
    @Expose
    private String updated_by;

    @SerializedName("date_check_in")
    @Expose
    private String date_check_in;

    @SerializedName("check_in_time")
    @Expose
    private String parkerTimeIn;

    @SerializedName("card")
    @Expose
    private TagManagementModel card;

    @SerializedName("check_out_date")
    @Expose
    private String check_out_date;

    @SerializedName("time_out")
    @Expose
    private String parkerTimeOut;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    private int originalPosition;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParkerDuration() {
        return parkerDuration;
    }

    public void setParkerDuration(String parkerDuration) {
        this.parkerDuration = parkerDuration;
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

    public String getDate_check_in() {
        return date_check_in;
    }

    public void setDate_check_in(String date_check_in) {
        this.date_check_in = date_check_in;
    }

    public String getParkerTimeIn() {
        return parkerTimeIn;
    }

    public void setParkerTimeIn(String parkerTimeIn) {
        this.parkerTimeIn = parkerTimeIn;
    }

    public TagManagementModel getCard() {
        return card;
    }

    public void setCard(TagManagementModel card) {
        this.card = card;
    }

    public String getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(String check_out_date) {
        this.check_out_date = check_out_date;
    }

    public String getParkerTimeOut() {
        return parkerTimeOut;
    }

    public void setParkerTimeOut(String parkerTimeOut) {
        this.parkerTimeOut = parkerTimeOut;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getOriginalPosition() {
        return originalPosition;
    }

    public void setOriginalPosition(int originalPosition) {
        this.originalPosition = originalPosition;
    }

    public ParkingLogModel(String id, String parkerDuration, String updated_at, String created_by, String updated_by, String date_check_in, String parkerTimeIn, TagManagementModel card, String check_out_date, String parkerTimeOut, String created_at, int originalPosition) {
        this.id = id;
        this.parkerDuration = parkerDuration;
        this.updated_at = updated_at;
        this.created_by = created_by;
        this.updated_by = updated_by;
        this.date_check_in = date_check_in;
        this.parkerTimeIn = parkerTimeIn;
        this.card = card;
        this.check_out_date = check_out_date;
        this.parkerTimeOut = parkerTimeOut;
        this.created_at = created_at;
        this.originalPosition = originalPosition;
    }

    public ParkingLogModel( TagManagementModel card, String parkerTimeIn, String parkerTimeOut, String parkerDuration) {
        this.card = card;
        this.parkerTimeIn = parkerTimeIn;
        this.parkerTimeOut = parkerTimeOut;
        this.parkerDuration = parkerDuration;
    }
}
