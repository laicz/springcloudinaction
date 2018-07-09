/**
 * Date:     2018/7/814:24
 * AUTHOR:   Administrator
 */
package com.zhou.licensingservice.client;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhou.licensingservice.model.License;
import com.zhou.licensingservice.repository.MockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * 2018/7/8  14:24
 * created by zhoumb
 */
@Service
public class LicenseService {

    @Autowired
    private MockRepository mockRepository;

    /**
     * 默认时间1秒
     * @param organizationId
     * @return
     */
    @HystrixCommand
    public List<License> getLicenseByOrg(String organizationId) {
        randomlyRunLong();
        return mockRepository.findByOrganizationId(organizationId);
    }

    /**
     * 定制时间
     * @param organizationId
     * @return
     */
    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "12000")})
    public List<License> getLicenseByOrg1(String organizationId) {
        randomlyRunLong();
        return mockRepository.findByOrganizationId(organizationId);
    }

    private void randomlyRunLong() {
        Random random = new Random();
        int randomNum = random.nextInt((3 - 1) + 1) + 1;
        if (randomNum == 3) sleep();
    }

    private void sleep() {
        try {
            System.out.println("暂停11秒");
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}