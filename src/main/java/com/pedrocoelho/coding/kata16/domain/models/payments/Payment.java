package com.pedrocoelho.coding.kata16.domain.models.payments;

public class Payment {

    private boolean paid;

    public Payment(boolean paid) {
        this.paid = paid;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}
