package com.android.pharmacy;


import com.android.pharmacy.model.UserSave;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class LoginTest {
    @Test
    public void CheckInvlaidEmailCheck() {
        String testinvlaidEmail = "pooja.pooja@gmail.com";
        Assert.assertThat(String.format("Email Validity Test",
                testinvlaidEmail),
                UserSave.checkEmailForValidity(testinvlaidEmail),
                is(true));
    }
}
