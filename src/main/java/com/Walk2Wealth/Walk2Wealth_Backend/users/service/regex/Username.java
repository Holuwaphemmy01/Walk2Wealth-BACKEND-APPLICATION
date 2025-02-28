package com.Walk2Wealth.Walk2Wealth_Backend.users.service.regex;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Username {
    public static boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z][a-zA-Z0-9_.-]{5,14}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

}
