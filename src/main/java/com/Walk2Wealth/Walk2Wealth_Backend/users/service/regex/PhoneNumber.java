package com.Walk2Wealth.Walk2Wealth_Backend.users.service.regex;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PhoneNumber {
    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^(0)(7|8|9)(0|1)?\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
