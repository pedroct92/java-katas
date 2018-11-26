package com.pedrocoelho.coding.kata16.domain.models.orders;

import com.pedrocoelho.coding.kata16.domain.models.clients.Client;

public class Order {

    private Integer id;
    private Product product;
    private Client client;
    private Agent agent;

    public Order(Integer id, Product product, Client client, Agent agent) {
        this.id = id;
        this.product = product;
        this.client = client;
        this.agent = agent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}
