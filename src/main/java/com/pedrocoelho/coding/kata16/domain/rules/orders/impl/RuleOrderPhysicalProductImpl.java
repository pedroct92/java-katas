package com.pedrocoelho.coding.kata16.domain.rules.orders.impl;

import com.pedrocoelho.coding.kata16.domain.models.orders.ProcessedOrder;
import com.pedrocoelho.coding.kata16.domain.models.packing.PackingSlip;
import com.pedrocoelho.coding.kata16.domain.models.packing.Shipment;
import com.pedrocoelho.coding.kata16.domain.rules.orders.RuleOrder;

public class RuleOrderPhysicalProductImpl implements RuleOrder {

    @Override
    public void apply(ProcessedOrder processedOrder) {
        if (processedOrder.getOrder().getProduct().isPhysical()) {
            PackingSlip packingSlip = new PackingSlip();
            packingSlip.addProduct(processedOrder.getOrder().getProduct());

            processedOrder.setShipment(new Shipment(packingSlip));
        }
    }
}
