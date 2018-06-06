package com.xxw.pojo;

import java.io.Serializable;

public class User implements Serializable {

    private String id = null;      // 用户ID
    private String name = null;    // 用户名
    private int age = -1;          // 年龄
    private String gender = null;  // 性别
    private String address = null; // 用户地址
    private String phone = null;   // 电话

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
