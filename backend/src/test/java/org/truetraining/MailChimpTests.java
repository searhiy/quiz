package org.truetraining;

import com.ecwid.maleorang.MailchimpClient;
import com.ecwid.maleorang.MailchimpException;
import com.ecwid.maleorang.MailchimpObject;
import com.ecwid.maleorang.method.v3_0.lists.members.EditMemberMethod;
import com.ecwid.maleorang.method.v3_0.lists.members.MemberInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class MailChimpTests {

//    @Parameterized.Parameters({"mailchimp.test.apikey", "mailchimp.test.listid"})
//    private ExistingMethodExample(String apiKey, String listId) {
//        this.apiKey = apiKey;
//        this.listId = listId;
//    }

//    @Test
    public void connectionTest() throws IOException, MailchimpException {
        MailchimpClient client = new MailchimpClient("apiKey");
        try {
            EditMemberMethod.CreateOrUpdate method = new EditMemberMethod.CreateOrUpdate("listid", "vasya.pupkin@gmail.com");
            method.status = "subscribed";
            method.merge_fields = new MailchimpObject();
            method.merge_fields.mapping.put("FNAME", "Vasya");
            method.merge_fields.mapping.put("LNAME", "Pupkin");

            MemberInfo member = client.execute(method);
            System.err.println("The user has been successfully subscribed: " + member);
        } finally {
            client.close();
        }
    }

    /*
    *
    * Custom implementation: https://github.com/Ecwid/maleorang/blob/master/src/test/java/com/ecwid/maleorang/examples/CustomMethodExample.java
    *
    */

}
