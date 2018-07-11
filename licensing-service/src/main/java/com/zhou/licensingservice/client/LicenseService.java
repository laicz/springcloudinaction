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

import java.util.ArrayList;
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
     *
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
     *
     * @param organizationId
     * @return
     */
    @HystrixCommand(commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "12000")})
    public List<License> getLicenseByOrg1(String organizationId) {
        randomlyRunLong();
        return mockRepository.findByOrganizationId(organizationId);
    }

    /**
     * 使用hystrix实现后备模式
     *
     * @param organizationId
     * @return
     */
    @HystrixCommand(fallbackMethod = "buildFallbackLicenseList")
    public List<License> getLicenseByOrg2(String organizationId) {
        randomlyRunLong();
        return mockRepository.findByOrganizationId(organizationId);
    }

    /**
     * 注意：参数要和对某个方法进行备份的一致
     *
     * @param organizationId
     * @return
     */
    public List<License> buildFallbackLicenseList(String organizationId) {
        System.out.println("------------执行后备处理-------------");
        return new ArrayList<>();
    }

    /**
     * 使用hystrix实现舱壁模式
     *
     * @param organizationId
     * @return
     */
    @HystrixCommand(fallbackMethod = "buildFallbackLicenseList", threadPoolKey = "licenseByOrgThreadPool", threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "30"),//设置线程池大小
            @HystrixProperty(name = "maxQueueSize", value = "10")
    })
    public List<License> getLicenseByOrg3(String organizationId) {
        randomlyRunLong();
        return mockRepository.findByOrganizationId(organizationId);
    }

    /**
     * 微调hystrix
     *
     * @param organizationId
     * @return
     */
    @HystrixCommand(fallbackMethod = "buildFallbackLicenseList",
            threadPoolKey = "licenseByOrgThreadPool", threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "30"),
            @HystrixProperty(name = "maxQueueSize", value = "10")
    },
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//用于控制在跳闸之前在10s只能必须发生的连续调用次数
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "75"),//必须达到的调用失败百分比
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "7000"),//在断路器跳闸之后，Hystrix允许另一个调用通过的时间数，用于检查是否恢复成功
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "15000"),//监视服务调用问题的时间大小
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "5")//收集统计的次数，

            }
    )
    public List<License> getLicenseByOrg4(String organizationId) {
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
