package com.android.pharmacy;


import com.android.pharmacy.model.UserPoints;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;


public class LocationTest {

    @Test
    public void CheckLocationfail() {
        String langitute = "22.21545";
        Assert.assertThat(String.format(langitute,"22.21545"),
                UserPoints.location(langitute),
                is(true));

    }
}
