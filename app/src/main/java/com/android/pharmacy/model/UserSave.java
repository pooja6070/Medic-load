/**
 * Created by Shiva_Subedi
 * computing project android Devlopment
 */
package com.android.pharmacy.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserSave {
    String name;
    String email;
    String phone;
    String address;
    public static boolean checkEmailForValidity(String email) {


        email = email.trim();

        Matcher matcher = Email_format.matcher(email);
        return matcher.find();

    }
    public static String emailStringChecker(String email) {

        return email;
    }
    public  static  String addressCheck (String address){
        return address;
    }

    private static final Pattern Email_format =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public UserSave(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
