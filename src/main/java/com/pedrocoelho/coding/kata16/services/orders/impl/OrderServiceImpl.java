package com.pedrocoelho.coding.kata16.services.orders.impl;

import com.pedrocoelho.coding.kata16.domain.models.clients.Client;
import com.pedrocoelho.coding.kata16.domain.models.orders.Agent;
import com.pedrocoelho.coding.kata16.domain.models.orders.Order;
import com.pedrocoelho.coding.kata16.domain.models.orders.ProcessedOrder;
import com.pedrocoelho.coding.kata16.domain.models.orders.Product;
import com.pedrocoelho.coding.kata16.domain.models.payments.Payment;
import com.pedrocoelho.coding.kata16.domain.rules.orders.RuleOrder;
import com.pedrocoelho.coding.kata16.domain.rules.orders.impl.RuleOrderActivateMembershipImpl;
import com.pedrocoelho.coding.kata16.domain.rules.orders.impl.RuleOrderBookProductImpl;
import com.pedrocoelho.coding.kata16.domain.rules.orders.impl.RuleOrderPhysicalProductImpl;
import com.pedrocoelho.coding.kata16.domain.rules.orders.impl.RuleOrderUpgradeMembershipImpl;
import com.pedrocoelho.coding.kata16.domain.rules.orders.impl.RuleOrderVideoLearningSkiImpl;
import com.pedrocoelho.coding.kata16.services.orders.OrderService;
import com.pedrocoelho.coding.kata16.services.payments.PaymentService;

import java.util.Arrays;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private PaymentService paymentService;

    private List<RuleOrder> ruleOrders = Arrays.asList(new RuleOrderPhysicalProductImpl(), new RuleOrderBookProductImpl(), new RuleOrderActivateMembershipImpl(), new RuleOrderUpgradeMembershipImpl(), new RuleOrderVideoLearningSkiImpl());

    public OrderServiceImpl(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public ProcessedOrder placeOder(Client client, Agent agent, Product product) {
        ProcessedOrder processedOrder = new ProcessedOrder();
        Order order = new Order((int)(Math.random() * 10), product, client, agent);

        Payment payment = paymentService.makePayment(order, processedOrder);
        processedOrder.setPayment(payment);
        processedOrder.setOrder(order);

        ruleOrders.forEach(rule -> rule.apply(processedOrder));

        return processedOrder;
    }
}
