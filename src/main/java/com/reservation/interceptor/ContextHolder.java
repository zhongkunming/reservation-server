package com.reservation.interceptor;


import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Objects;

public class ContextHolder {

    private final static ThreadLocal<Map<String, Object>> LOCAL = new ThreadLocal<>();


    public static void putUserInfo(Map<String, Object> userInfo) {
        Map<String, Object> map = LOCAL.get();
        if (Objects.isNull(map)) {
            map = Maps.newHashMap();
        }
        map.put("user-info", userInfo);
        LOCAL.set(map);
    }

    public static Map<String, Object> getUserInfo() {
        Map<String, Object> map = LOCAL.get();
        if (Objects.isNull(map)) {
            map = Maps.newHashMap();
        }
        return (Map<String, Object>) map.getOrDefault("user-info", Maps.newHashMap());
    }

    public static void clear() {
        LOCAL.remove();
    }
}
