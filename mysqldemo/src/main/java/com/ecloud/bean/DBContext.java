package com.ecloud.bean;

import com.ecloud.enums.DBTypeEnum;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 */
public class DBContext {

    private static final ThreadLocal<DBTypeEnum> contextHolder = new ThreadLocal<>();

    //private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DBTypeEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DBTypeEnum get() {
        return contextHolder.get();
    }

    public static void master() {
        set(DBTypeEnum.MASTER);
        System.out.println("切换到master");
    }
    public static void slave() {
        set(DBTypeEnum.SLAVE);
        System.out.println("切换到slave");
    }

}
