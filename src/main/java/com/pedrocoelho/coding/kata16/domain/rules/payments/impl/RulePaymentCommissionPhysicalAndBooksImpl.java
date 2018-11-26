package com.pedrocoelho.coding.kata16.domain.rules.payments.impl;

import com.pedrocoelho.coding.kata16.domain.models.commissions.Commission;
import com.pedrocoelho.coding.kata16.domain.models.orders.Order;
import com.pedrocoelho.coding.kata16.domain.models.orders.ProcessedOrder;
import com.pedrocoelho.coding.kata16.domain.rules.payments.RulePayment;

public class RulePaymentCommissionPhysicalAndBooksImpl implements RulePayment {

    @Override
    public void apply(Order order, ProcessedOrder processedOrder) {
        if (order.getProduct().isPhysicalOrBook()) {
            processedOrder.setCommission(new Commission(10.0, order.getAgent()));
        }
    }
}
