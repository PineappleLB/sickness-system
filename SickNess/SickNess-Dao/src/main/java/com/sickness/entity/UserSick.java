package com.sickness.entity;

public class UserSick {
    private Integer id;

    private Integer sickId;

    private Integer status;

    private Integer userId;

    private String record;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSickId() {
        return sickId;
    }

    public void setSickId(Integer sickId) {
        this.sickId = sickId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record == null ? null : record.trim();
    }
}