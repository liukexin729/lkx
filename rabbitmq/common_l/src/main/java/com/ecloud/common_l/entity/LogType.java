package com.ecloud.common_l.entity;

/**
 * @author Administrator
 */

public enum LogType {

    //枚举类型变量，名称
    INSERT("1"),DELETE("2"),UPDATE("3"),LOGIN("4"),QUERY("5"),REGISTER("6");

    private String type;

    LogType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
