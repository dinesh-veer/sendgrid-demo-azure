package com.vwits.ini.demosendgrid;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfigBean {

    @Value("${SENDGRID_API_KEY}")
    private String sendGridAPIKey;

    public SendGrid getSendGridContext() {
        return new SendGrid(sendGridAPIKey);
    }
}
