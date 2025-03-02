package com.Walk2Wealth.Walk2Wealth_Backend.regex;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Password {
//    public static boolean isValidPassword(String password) {
//        if (password == null || password.isEmpty()) {
//            return false;
//        }
//        String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?.&,])[A-Za-z\\d@$!%*?.&]{8,}$";
//
//        Pattern pattern = Pattern.compile(regexPassword);
//        Matcher matcher = pattern.matcher(password);
//        return matcher.matches();
//    }

    public static boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        String regexPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?.&,])[A-Za-z\\d@$!%*?.&,]{8,}$"; // Added comma

        Pattern pattern = Pattern.compile(regexPassword);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
