package com.pedrocoelho.coding.kata16.domain.models.packing;

public class Shipment {

    private PackingSlip packingSlip;
    private PackingSlip packingSlipRoyalDepartment;

    public Shipment(PackingSlip packingSlip) {
        this.packingSlip = packingSlip;
    }

    public Shipment(PackingSlip packingSlip, PackingSlip packingSlipRoyalDepartment) {
        this.packingSlip = packingSlip;
        this.packingSlipRoyalDepartment = packingSlipRoyalDepartment;

    }

    public PackingSlip getPackingSlip() {
        return packingSlip;
    }

    public void setPackingSlip(PackingSlip packingSlip) {
        this.packingSlip = packingSlip;
    }

    public PackingSlip getPackingSlipRoyalDepartment() {
        return packingSlipRoyalDepartment;
    }

    public void setPackingSlipRoyalDepartment(PackingSlip packingSlipRoyalDepartment) {
        this.packingSlipRoyalDepartment = packingSlipRoyalDepartment;
    }
}
