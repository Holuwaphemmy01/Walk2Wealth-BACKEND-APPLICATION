package com.Walk2Wealth.Walk2Wealth_Backend.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Date {
    public static boolean isValidDate(String dateString, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateString);
        return matcher.matches();
    }

}
