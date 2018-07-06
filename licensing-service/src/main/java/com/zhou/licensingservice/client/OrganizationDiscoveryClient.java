/**
 * Date:     2018/7/523:23
 * AUTHOR:   Administrator
 */
package com.zhou.licensingservice.client;

import com.zhou.licensingservice.model.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 2018/7/5  23:23
 * created by zhoumb
 */
@Component
@FeignClient("organazitionservice")
public class OrganizationDiscoveryClient {
    private static final Logger logger = LoggerFactory.getLogger(OrganizationDiscoveryClient.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    public Organization getOrganization(String organizationId) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> organizationservices = discoveryClient.getInstances("organizationservice");
        if (CollectionUtils.isEmpty(organizationservices)) return null;
        String serviceUri = String.format("%s/v1/organization/%s", organizationservices.get(0).getUri().toString(), organizationId);

        ResponseEntity<Organization> exchange = restTemplate.exchange(serviceUri, HttpMethod.GET, null, Organization.class, organizationId);
        return exchange.getBody();

    }
}
