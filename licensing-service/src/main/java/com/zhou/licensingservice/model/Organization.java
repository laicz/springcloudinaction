/**
 * Date:     2018/7/323:30
 * AUTHOR:   Administrator
 */
package com.zhou.licensingservice.model;

/**
 * 组织
 * 2018/7/3  23:30
 * created by zhoumb
 */
public class Organization {
    String id;
    String name;
    String contactName;
    String contactEmail;
    String contactPhone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
