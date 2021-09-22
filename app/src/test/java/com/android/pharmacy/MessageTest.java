package com.android.pharmacy;


import com.android.pharmacy.model.ChatMessage;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class MessageTest {
    @Test
    public void TestChat()
    {
        try {
                String message = "hello  how are you?";
                Assert.assertThat(String.format("hello how are you?",message),
                        ChatMessage.checkmessage(message),
                        is(false));
        }
        catch
        (Exception e)
        {
            e.printStackTrace();
        }
    }
}
