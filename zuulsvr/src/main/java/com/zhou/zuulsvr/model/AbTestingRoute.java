/**
 * Date:     2018/7/1923:05
 * AUTHOR:   Administrator
 */
package com.zhou.zuulsvr.model;

/**
 * 2018/7/19  23:05
 * created by zhoumb
 */
public class AbTestingRoute {
    private String serviceName;
    private String active;
    private String endpoint;
    private Integer weight;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
