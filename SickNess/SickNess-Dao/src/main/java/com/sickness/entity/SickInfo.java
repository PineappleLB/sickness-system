package com.sickness.entity;

public class SickInfo {
    private Integer id;

    private String sickGuid;

    private String name;

    private Integer age;

    private Boolean gender;

    private Integer sickId;

    private String contact;

    private String homeAddress;

    private String workAddress;

    private Integer areaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSickGuid() {
        return sickGuid;
    }

    public void setSickGuid(String sickGuid) {
        this.sickGuid = sickGuid == null ? null : sickGuid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getSickId() {
        return sickId;
    }

    public void setSickId(Integer sickId) {
        this.sickId = sickId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress == null ? null : homeAddress.trim();
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress == null ? null : workAddress.trim();
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}