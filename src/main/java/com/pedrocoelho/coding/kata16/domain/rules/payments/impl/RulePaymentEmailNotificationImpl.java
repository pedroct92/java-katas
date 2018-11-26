package com.pedrocoelho.coding.kata16.domain.rules.payments.impl;

import com.pedrocoelho.coding.kata16.domain.models.orders.Order;
import com.pedrocoelho.coding.kata16.domain.models.orders.ProcessedOrder;
import com.pedrocoelho.coding.kata16.domain.rules.payments.RulePayment;
import com.pedrocoelho.coding.kata16.services.mail.EmailService;
import com.pedrocoelho.coding.kata16.services.mail.impl.EmailServiceImpl;

public class RulePaymentEmailNotificationImpl implements RulePayment {

    private EmailService emailService;

    public RulePaymentEmailNotificationImpl() {
        this.emailService = new EmailServiceImpl();
    }

    @Override
    public void apply(Order order, ProcessedOrder processedOrder) {
        if (order.getProduct().isMembershipOrUpgrade()) {
            this.emailService.sendEmail(order.getClient().getEmail(), "Checking Membership ...");
            processedOrder.setClientNotified(true);
        }
    }
}
