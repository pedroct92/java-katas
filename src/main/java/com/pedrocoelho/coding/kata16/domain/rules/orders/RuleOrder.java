package com.pedrocoelho.coding.kata16.domain.rules.orders;

import com.pedrocoelho.coding.kata16.domain.models.orders.ProcessedOrder;

public interface RuleOrder {

    void apply(ProcessedOrder processedOrder);
}
