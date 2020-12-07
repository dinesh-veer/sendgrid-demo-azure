package com.vwits.ini.demosendgrid.controller;

import com.vwits.ini.demosendgrid.adapter.MailAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private MailAdapter mailAdapter;

    @PostMapping("send/mail")
    public ResponseEntity sendMail(@RequestParam String receiverEmailId) {
        mailAdapter.triggerEmail(receiverEmailId, "Hello, This is our test email", "Test Email");
        return ResponseEntity.ok("Mail Send Successfully");
    }
}
