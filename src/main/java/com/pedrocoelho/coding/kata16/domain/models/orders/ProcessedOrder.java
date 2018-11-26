package com.pedrocoelho.coding.kata16.domain.models.orders;

import com.pedrocoelho.coding.kata16.domain.models.commissions.Commission;
import com.pedrocoelho.coding.kata16.domain.models.packing.Shipment;
import com.pedrocoelho.coding.kata16.domain.models.payments.Payment;

public class ProcessedOrder {

    private Order order;
    private Payment payment;
    private boolean clientNotified;
    private boolean membershipActive;
    private boolean membershipUpgraded;
    private Shipment shipment;
    private Commission commission;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public boolean isClientNotified() {
        return clientNotified;
    }

    public void setClientNotified(boolean clientNotified) {
        this.clientNotified = clientNotified;
    }

    public boolean isMembershipActive() {
        return membershipActive;
    }

    public void setMembershipActive(boolean membershipActive) {
        this.membershipActive = membershipActive;
    }

    public boolean isMembershipUpgraded() {
        return membershipUpgraded;
    }

    public void setMembershipUpgraded(boolean membershipUpgraded) {
        this.membershipUpgraded = membershipUpgraded;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }
}
