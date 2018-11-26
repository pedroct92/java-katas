package com.pedrocoelho.coding.kata16.domain.models.commissions;

import com.pedrocoelho.coding.kata16.domain.models.orders.Agent;

public class Commission {

    private Double amount;
    private Agent agent;

    public Commission(Double amount, Agent agent) {
        this.amount = amount;
        this.agent = agent;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}
