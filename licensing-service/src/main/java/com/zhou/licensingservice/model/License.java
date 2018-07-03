/**
 * Date:     2018/7/323:28
 * AUTHOR:   Administrator
 */
package com.zhou.licensingservice.model;

/**
 * 许可证
 * 2018/7/3  23:28
 * created by zhoumb
 */
public class License {
    private String id;
    private String organizationId;
    private String productName;
    private String licenseType;

    public String getId() {
        return id;
    }

    public License setId(String id) {
        this.id = id;
        return this;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public License setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public License setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public License setLicenseType(String licenseType) {
        this.licenseType = licenseType;
        return this;
    }
}
