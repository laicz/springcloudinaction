/**
 * Date:     2018/7/1722:56
 * AUTHOR:   Administrator
 */
package com.zhou.zuulsvr.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.zhou.zuulsvr.model.AbTestingRoute;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 2018/7/17  22:56
 * created by zhoumb
 */
@Component
public class SpecialRoutesFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(SpecialRoutesFilter.class);
    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;

    @Autowired
    private FilterUtils filterUtils;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String filterType() {
        return FilterUtils.ROUTE_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    private ProxyRequestHelper requestHelper = new ProxyRequestHelper();

    private AbTestingRoute getAbRoutingInfo(String serviceName) {
        ResponseEntity<AbTestingRoute> restExchange = restTemplate.exchange("http://specialroutesservice/v1/route/abtesting/{serviceName}",
                HttpMethod.GET,
                null, AbTestingRoute.class, serviceName
        );
        return restExchange.getBody();
    }

    private String buildRouteString(String oldEndpoint, String newEndpoint, String serviceName) {
        int index = oldEndpoint.indexOf(serviceName);

        String strippedRoute = oldEndpoint.substring(index + serviceName.length());
        logger.info("Target route: " + String.format("%s/%s", newEndpoint, strippedRoute));
        return String.format("%s%s", newEndpoint, strippedRoute);
    }

    private HttpHost getHttpHost(URL host) {
        HttpHost httpHost = new HttpHost(host.getHost(), host.getPort(), host.getProtocol());
        return httpHost;
    }

    private Header[] converHeaders(MultiValueMap<String,String> headers){
        List<Header> list = new ArrayList<>();
        for (String name : headers.keySet()){
            for (String value: headers.get(name)){
                list.add(new BasicHeader(name,value));
            }
        }
        return list.toArray(new BasicHeader[0]);
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
