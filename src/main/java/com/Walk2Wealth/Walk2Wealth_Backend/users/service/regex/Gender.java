package com.Walk2Wealth.Walk2Wealth_Backend.users.service.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Gender {
    public static boolean isValidGender(String genderString) {
        if (genderString == null || genderString.isEmpty()) {
            return false;
        }

        String regex = "^(MALE|FEMALE)$";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(genderString);

        return matcher.matches();
    }
}
