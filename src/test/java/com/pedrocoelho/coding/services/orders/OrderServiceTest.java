package com.pedrocoelho.coding.services.orders;

import com.pedrocoelho.coding.kata16.domain.models.clients.Client;
import com.pedrocoelho.coding.kata16.domain.models.orders.Agent;
import com.pedrocoelho.coding.kata16.domain.models.orders.ProcessedOrder;
import com.pedrocoelho.coding.kata16.domain.models.orders.Product;
import com.pedrocoelho.coding.kata16.domain.models.packing.Shipment;
import com.pedrocoelho.coding.kata16.services.orders.OrderService;
import com.pedrocoelho.coding.kata16.services.orders.impl.OrderServiceImpl;
import com.pedrocoelho.coding.kata16.services.payments.PaymentService;
import com.pedrocoelho.coding.kata16.services.payments.impl.PaymentServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class OrderServiceTest {

    private Client client;
    private Agent agent;

    private PaymentService paymentService = new PaymentServiceImpl();

    private OrderService orderService = new OrderServiceImpl(paymentService);

    @Before
    public void before() {
        this.client = new Client("Pierre", "pedro@hire.me");
        this.agent = new Agent("Peter");
    }

    @Test
    public void testPlaceOderWhenProductTypeIsPhysicalShouldCreatePackingSlip() {
        Product product = new Product("Table", Product.ProductType.PHYSICAL);

        ProcessedOrder order = orderService.placeOder(client, agent, product);
        assertNotNull(order);
        assertFalse(order.isClientNotified());

        Shipment shipment = order.getShipment();

        assertNotNull(shipment);
        assertEquals(1, shipment.getPackingSlip().getProducts().size());
        assertEquals("Table", shipment.getPackingSlip().getProducts().get(0).getName());
    }

    @Test
    public void testPlaceOderWhenProductTypeIsBookShouldCreateTwoPackingSlips() {
        Product product = new Product("Is there life without stack overflow?", Product.ProductType.BOOK);

        ProcessedOrder order = orderService.placeOder(client, agent, product);
        assertNotNull(order);
        assertFalse(order.isClientNotified());

        Shipment shipment = order.getShipment();

        assertNotNull(shipment);
        assertEquals(1, shipment.getPackingSlip().getProducts().size());
        assertEquals(1, shipment.getPackingSlipRoyalDepartment().getProducts().size());
        assertEquals("Is there life without stack overflow?", shipment.getPackingSlip().getProducts().get(0).getName());
    }

    @Test
    public void testPlaceOderWhenProductTypeIsMembershipShouldSendEmailAndActivateMembership() {
        Product product = new Product("Membership", Product.ProductType.MEMBERSHIP);

        ProcessedOrder order = orderService.placeOder(client, agent, product);
        assertNotNull(order);
        assertTrue(order.isClientNotified());
        assertTrue(order.isMembershipActive());
    }

    @Test
    public void testPlaceOderWhenProductTypeIsUpgradeShouldSendEmailAndUpgradeMembership() {
        Product product = new Product("Upgrade", Product.ProductType.MEMBERSHIP_UPGRADE);

        ProcessedOrder order = orderService.placeOder(client, agent, product);
        assertNotNull(order);
        assertTrue(order.isClientNotified());
        assertTrue(order.isMembershipUpgraded());
    }

    @Test
    public void testPlaceOderWhenProductTypeIsVideoLearningSkiShouldAddFirstAidToPackingSplips() {
        Product product = new Product("Learning to ski", Product.ProductType.VIDEO);

        ProcessedOrder order = orderService.placeOder(client, agent, product);
        assertNotNull(order);

        Shipment shipment = order.getShipment();

        assertNotNull(shipment);
        assertEquals(2, shipment.getPackingSlip().getProducts().size());
        assertEquals("Learning to ski", shipment.getPackingSlip().getProducts().get(0).getName());
        assertEquals("First Aid", shipment.getPackingSlip().getProducts().get(1).getName());
    }

    @Test
    public void testPlaceOderWhenProductTypeIsPhysicalOrBookShouldAddCommission() {
        Product product = new Product("Tabernacle", Product.ProductType.PHYSICAL);

        ProcessedOrder order = orderService.placeOder(client, agent, product);
        assertNotNull(order);
        assertNotNull(order.getCommission());
        assertEquals(Double.valueOf(10.0), order.getCommission().getAmount());
        assertEquals("Peter", order.getCommission().getAgent().getName());
    }
}
