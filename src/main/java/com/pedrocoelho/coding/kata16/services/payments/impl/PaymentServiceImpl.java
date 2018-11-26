package com.pedrocoelho.coding.kata16.services.payments.impl;

import com.pedrocoelho.coding.kata16.domain.models.orders.Order;
import com.pedrocoelho.coding.kata16.domain.models.orders.ProcessedOrder;
import com.pedrocoelho.coding.kata16.domain.models.payments.Payment;
import com.pedrocoelho.coding.kata16.domain.rules.payments.RulePayment;
import com.pedrocoelho.coding.kata16.domain.rules.payments.impl.RulePaymentCommissionPhysicalAndBooksImpl;
import com.pedrocoelho.coding.kata16.domain.rules.payments.impl.RulePaymentEmailNotificationImpl;
import com.pedrocoelho.coding.kata16.services.payments.PaymentService;

import java.util.Arrays;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    private List<RulePayment> ruleOrders = Arrays.asList(new RulePaymentEmailNotificationImpl(), new RulePaymentCommissionPhysicalAndBooksImpl());

    @Override
    public Payment makePayment(Order order, ProcessedOrder processedOrder) {
        System.out.println("Making payment for the order: " + order.getId());

        ruleOrders.forEach(rule -> rule.apply(order, processedOrder));

        return new Payment(true);
    }
}
