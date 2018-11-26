package com.pedrocoelho.coding.kata16.services.mail.impl;

import com.pedrocoelho.coding.kata16.services.mail.EmailService;

public class EmailServiceImpl implements EmailService {

    @Override
    public void sendEmail(String email, String body) {
        System.out.println("Sending email " + body + " to " + email);
    }
}
