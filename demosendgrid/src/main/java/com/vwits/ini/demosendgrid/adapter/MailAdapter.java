package com.vwits.ini.demosendgrid.adapter;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.vwits.ini.demosendgrid.MailConfigBean;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MailAdapter {

    private MailConfigBean mailConfigBean;
    private SendGrid sendgrid;

    public MailAdapter(MailConfigBean mailConfigBean) {
        sendgrid = mailConfigBean.getSendGridContext();
    }

    public Response triggerEmail(String toEmail, String contentString, String subject) {
        Email from = new Email("sbk1267@gmail.com");
        Email to = new Email(toEmail);

        Content content = new Content("text/plain", contentString);
        Mail mail = new Mail(from, subject, to, content);

        Response response = null;
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            response = sendgrid.api(request);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }
}
