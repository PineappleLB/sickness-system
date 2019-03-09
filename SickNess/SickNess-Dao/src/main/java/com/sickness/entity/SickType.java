package com.sickness.entity;

public class SickType {
    private Integer id;

    private String sickName;

    private Boolean sickType;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSickName() {
        return sickName;
    }

    public void setSickName(String sickName) {
        this.sickName = sickName == null ? null : sickName.trim();
    }

    public Boolean getSickType() {
        return sickType;
    }

    public void setSickType(Boolean sickType) {
        this.sickType = sickType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}