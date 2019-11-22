package com.huluhaziqi.algorithms.javaBasic.reflect;

public class UserInfo {

    private String userName;
    private Integer age;
    public String school;

    public UserInfo() {
    }

    public UserInfo(String userName, Integer age, String school) {
        this.userName = userName;
        this.age = age;
        this.school = school;
    }

    public void myInfo(String userName, Integer age, String school) {
        System.out.println("myInfo " + userName + " " + age + " " + school);
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                '}';
    }
}
