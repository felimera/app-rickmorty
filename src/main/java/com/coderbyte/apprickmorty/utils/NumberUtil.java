package com.coderbyte.apprickmorty.utils;

import java.util.regex.Pattern;

public class NumberUtil {

    private NumberUtil() {
        throw new IllegalStateException(NumberUtil.class.toString());
    }

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }
}
