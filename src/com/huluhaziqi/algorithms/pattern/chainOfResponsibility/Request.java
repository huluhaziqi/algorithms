package com.huluhaziqi.algorithms.pattern.chainOfResponsibility;

public class Request {

    private RequestTypeEnum type;

    private String name;


    public Request(RequestTypeEnum type, String name) {
        this.type = type;
        this.name = name;
    }

    public RequestTypeEnum getType() {
        return type;
    }

    public void setType(RequestTypeEnum type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
