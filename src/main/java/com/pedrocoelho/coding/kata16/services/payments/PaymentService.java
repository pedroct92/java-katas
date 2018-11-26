package com.pedrocoelho.coding.kata16.services.payments;

import com.pedrocoelho.coding.kata16.domain.models.orders.Order;
import com.pedrocoelho.coding.kata16.domain.models.orders.ProcessedOrder;
import com.pedrocoelho.coding.kata16.domain.models.payments.Payment;

public interface PaymentService {

    Payment makePayment(Order order, ProcessedOrder processedOrder);
}
