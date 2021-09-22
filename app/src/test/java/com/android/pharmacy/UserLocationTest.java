package com.android.pharmacy;



import com.android.pharmacy.model.UserPoints;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class UserLocationTest {
    @Test
    public void CheckLocationfail() {
        String langitute = "47.21545";
        Assert.assertThat(String.format(langitute,"47.21545"),
                UserPoints.location(langitute), is(false));

    }
}
