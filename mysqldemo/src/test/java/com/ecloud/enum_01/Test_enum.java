package com.ecloud.enum_01;

public class Test_enum {

    public static void main(String[] args) {
        OrderStatus ost = OrderStatus.ONE;
        System.out.println(ost.getState());
        System.out.println(ost.getInfo());
    }

}
