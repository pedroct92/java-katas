package com.pedrocoelho.coding.kata16.domain.rules.orders.impl;

import com.pedrocoelho.coding.kata16.domain.models.orders.ProcessedOrder;
import com.pedrocoelho.coding.kata16.domain.rules.orders.RuleOrder;

public class RuleOrderActivateMembershipImpl implements RuleOrder {

    @Override
    public void apply(ProcessedOrder processedOrder) {
        if (processedOrder.getOrder().getProduct().isMembership()) {
            processedOrder.setMembershipActive(true);
        }
    }
}
