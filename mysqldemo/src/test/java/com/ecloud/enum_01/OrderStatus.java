package com.ecloud.enum_01;

public enum OrderStatus {

    //定义枚举的值
    ZERO(0,"已取消"),ONE(1,"待付款"),TWO(2,"已付款"),TREE(3, "取消");

    private int state;
    private String info;

    //构造方法（枚举的构造方法只允许private类型）
    private OrderStatus(int state, String info){
        this.state = state;
        this.info = info;
    }

    public int getState(){
        return state;
    }

    public String getInfo(){
        return info;
    }

}
