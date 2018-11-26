package com.pedrocoelho.coding.kata16.domain.rules.payments;

import com.pedrocoelho.coding.kata16.domain.models.orders.Order;
import com.pedrocoelho.coding.kata16.domain.models.orders.ProcessedOrder;

public interface RulePayment {

    void apply(Order order, ProcessedOrder processedOrder);
}
