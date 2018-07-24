/**
 * Date:     2018/7/2323:18
 * AUTHOR:   Administrator
 */
package com.zhou.organizationservice.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.stereotype.Component;

/**
 * 2018/7/23  23:18
 * created by zhoumb
 */
@Component
public class SimpleSourceBean {
    private static final Logger logger = LoggerFactory.getLogger(SimpleSourceBean.class);

    private Source source;

    @Autowired
    public SimpleSourceBean(Source source) {
        this.source = source;
    }

    public void publishOrgChange(String action,String orgId){
        logger.info("Sending kafka message {} for Organization Id:{}",action,orgId);
    }
}
