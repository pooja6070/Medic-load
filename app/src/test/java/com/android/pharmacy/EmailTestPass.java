package com.android.pharmacy;


import com.android.pharmacy.model.UserSave;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.is;


public class EmailTestPass {
    @Test
    public void emailStringEmptyCheck() {
        String email = "pooja.pokharel@gmail.com";
        Assert.assertThat(UserSave.emailStringChecker(email),
                is("pooja.pokharel@gmail.com"));
    }

}
