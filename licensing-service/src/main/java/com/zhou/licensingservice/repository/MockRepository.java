/**
 * Date:     2018/7/922:58
 * AUTHOR:   Administrator
 */
package com.zhou.licensingservice.repository;

import com.zhou.licensingservice.model.License;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 2018/7/9  22:58
 * created by zhoumb
 */
@Repository
public class MockRepository {
    public List<License> findByOrganizationId(String organizationId) {
        ArrayList<License> licenses = new ArrayList<>();
        licenses.add(new License("test_id", organizationId, "product_name", "test"));
        return licenses;
    }
}
