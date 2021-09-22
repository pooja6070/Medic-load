package com.android.pharmacy;



import com.android.pharmacy.model.UserSave;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class EmailTest {


    @Test
    public void emailStringNullCheck() {
        Assert.assertThat(UserSave.emailStringChecker(null),
                is(""));
    }

}
