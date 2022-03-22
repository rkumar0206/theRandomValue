package com.rtb.therandomvalue.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MyStringUtils extends StringUtils {

    public static boolean isValid(String str) {

        return str != null && !str.isEmpty() && !str.equals("null");
    }

}
