/**
 * Date:     2018/7/323:23
 * AUTHOR:   Administrator
 */
package com.zhou.licensingservice.controllers;

import com.zhou.licensingservice.model.License;
import org.springframework.web.bind.annotation.*;

/**
 * 2018/7/3  23:23
 * created by zhoumb
 */
@RestController
@RequestMapping(value = "/v1/organizations/{organizationId}/license")
public class LicenseController {

    /**
     * Rest风格，使用get请求方式请求资源
     *
     * @param organizationId
     * @param licenseId
     * @return
     */
    @GetMapping(value = "/{licenseId}")
    public License getLicenses(@PathVariable("organization") String organizationId,
                               @PathVariable("licenseId") String licenseId) {
        return new License()
                .setId(licenseId)
                .setOrganizationId(organizationId)
                .setProductName("Teleco")
                .setLicenseType("Seat");
    }

    /**
     * post修改资源
     *
     * @param organizationId
     * @param licenseId
     * @return
     */
    @PostMapping(value = "/{licenseId}")
    public String updateLicenses(@PathVariable("organizationId") String organizationId,
                                 @PathVariable("licenseId") String licenseId) {
        return String.format("This is the post");
    }

    /**
     * put提交资源并保存
     *
     * @param organizationId
     * @param licenseId
     * @return
     */
    @PutMapping(value = "/{licenseId}")
    public String saveLicenses(@PathVariable("organizationId") String organizationId,
                               @PathVariable("licenseId") String licenseId) {
        return String.format("This is the put");
    }

    /**
     * delete 删除资源
     * @param organizationId
     * @param licenseId
     * @return
     */
    public String deleteLicense(@PathVariable("organizationId") String organizationId,
                                @PathVariable("licenseId") String licenseId) {
        return String.format("This is the delete");
    }
}
