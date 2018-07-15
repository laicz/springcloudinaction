/**
 * Date:     2018/7/1523:01
 * AUTHOR:   Administrator
 */
package com.zhou.zuulsvr.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * 前置过滤器，用于检查header中是否存在关联id，不存在的话则设置一个关联id
 * 2018/7/15  23:01
 * created by zhoumb
 */
@Component
public class TrackingFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(TrackingFilter.class);
    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;

    @Autowired
    private FilterUtils filterUtils;

    @Override
    public String filterType() {
        return FilterUtils.PRE_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() throws ZuulException {
        if (isCorrelationIdPresent()) {
            logger.info("tmx-correlation-id found in tracking filter:{},", filterUtils.getCorrelationId());
        } else {
            filterUtils.setCorrelationId(geerrateCorrelationId());
            logger.info("tmx-correlation-id generated in tracking filter: {}.", filterUtils.getCorrelationId());

        }
        RequestContext ctx = RequestContext.getCurrentContext();
        logger.info("Processing incoming request for {}.", ctx.getRequest().getRequestURI());
        return null;
    }

    private String geerrateCorrelationId() {
        return UUID.randomUUID().toString();
    }

    private boolean isCorrelationIdPresent() {
        if (!StringUtils.isEmpty(filterUtils.getCorrelationId())) {
            return true;
        }
        return false;
    }
}
