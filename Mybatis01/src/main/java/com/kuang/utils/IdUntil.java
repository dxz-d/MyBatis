package com.kuang.utils;

import java.util.UUID;

/***
 * @description IDUntil工具类
 * @author diaoxiuze
 * @date 2020/11/19 13:53
 * @param
 * @return
 */
public class IdUntil {

    public static String getId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
