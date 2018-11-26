package com.pedrocoelho.coding.kata16.services.orders;

import com.pedrocoelho.coding.kata16.domain.models.clients.Client;
import com.pedrocoelho.coding.kata16.domain.models.orders.Agent;
import com.pedrocoelho.coding.kata16.domain.models.orders.ProcessedOrder;
import com.pedrocoelho.coding.kata16.domain.models.orders.Product;

public interface OrderService {

    ProcessedOrder placeOder(Client client, Agent agent, Product product);
}
