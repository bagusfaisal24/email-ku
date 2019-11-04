package com.example.demo.email.util;

import com.example.demo.email.form.EmailForm;
import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Example {

    @Value("${sendgrid.api.key:''}")
    private String apiKey;

    public void sendEmail(EmailForm form) throws IOException {
        Email from = new Email(form.getEmailFrom());
        String subject = "Sending with Twilio SendGrid is Fun";
        Email to = new Email(form.getTarget());
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(apiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }
}
