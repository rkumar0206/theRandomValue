package com.rtb.therandomvalue.utils;

import org.springframework.stereotype.Component;

@Component
public class StringUtils {

    public static boolean isValid(String str) {

        return str != null && !str.isEmpty() && !str.equals("null");
    }

}
