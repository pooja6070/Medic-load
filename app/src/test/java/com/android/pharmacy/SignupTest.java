package com.android.pharmacy;


import com.android.pharmacy.model.UserSave;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class SignupTest {


    @Test
    public void EmailValidationCheck() {
       String testEmail = "pooja.pokharel@gmail.com";
        Assert.assertThat(String.format("Email conformation Test",
                testEmail),
                UserSave.checkEmailForValidity(testEmail),//use class for checking correct email format
                is(true));

    }
}
