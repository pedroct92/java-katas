package com.pedrocoelho.coding.kata16.domain.models.orders;

public class Product {

    public Product(String name, ProductType type) {
        this.name = name;
        this.type = type;
    }

    private String name;
    private ProductType type;

    public Boolean isPhysical() {
        return ProductType.PHYSICAL == this.type;
    }

    public Boolean isBook() {
        return ProductType.BOOK == this.type;
    }

    public Boolean isPhysicalOrBook() {
        return ProductType.PHYSICAL == this.type ||  ProductType.BOOK == this.type;
    }

    public Boolean isVideoLearningToSki() {
        return ProductType.VIDEO == this.type && "LEARNING TO SKI".equalsIgnoreCase(this.name);
    }

    public Boolean isMembership() {
        return ProductType.MEMBERSHIP == this.type;
    }

    public Boolean isUpgrade() {
        return ProductType.MEMBERSHIP_UPGRADE == this.type;
    }

    public Boolean isMembershipOrUpgrade() {
        return ProductType.MEMBERSHIP == this.type || ProductType.MEMBERSHIP_UPGRADE == this.type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public enum ProductType {
        PHYSICAL,
        BOOK,
        VIDEO,
        MEMBERSHIP,
        MEMBERSHIP_UPGRADE;
    }
}
