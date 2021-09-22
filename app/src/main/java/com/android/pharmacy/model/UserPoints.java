package com.android.pharmacy.model;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserPoints {



    private String userEmail;


    public UserPoints(String scoreUser) {

        this.userEmail = scoreUser;


    }
    public UserPoints() {
    }

    public static boolean location(String langitute) {


        langitute = langitute.trim();

        Matcher matcher = location.matcher(langitute);
        return matcher.find();

    }
    private static final Pattern location =
            Pattern.compile("[A-Z]{2,6}$");


}