package com.pedrocoelho.coding.kata16.domain.rules.orders.impl;

import com.pedrocoelho.coding.kata16.domain.models.orders.ProcessedOrder;
import com.pedrocoelho.coding.kata16.domain.models.orders.Product;
import com.pedrocoelho.coding.kata16.domain.models.packing.PackingSlip;
import com.pedrocoelho.coding.kata16.domain.models.packing.Shipment;
import com.pedrocoelho.coding.kata16.domain.rules.orders.RuleOrder;

public class RuleOrderVideoLearningSkiImpl implements RuleOrder {

    @Override
    public void apply(ProcessedOrder processedOrder) {
        if (processedOrder.getOrder().getProduct().isVideoLearningToSki()) {
            PackingSlip packingSlip = new PackingSlip();
            packingSlip.addProduct(processedOrder.getOrder().getProduct());
            packingSlip.addProduct(new Product("First Aid", Product.ProductType.VIDEO));

            processedOrder.setShipment(new Shipment(packingSlip));
        }
    }
}
