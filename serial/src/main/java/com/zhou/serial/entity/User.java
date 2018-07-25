/**
 * Date:     2018/7/2521:23
 * AUTHOR:   Administrator
 */
package com.zhou.serial.entity;

import java.io.Serializable;

/**
 * 2018/7/25  21:23
 * created by zhoumb
 */
public class User implements Serializable{
    private String userId;
    private String userName;
    private Integer age;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
