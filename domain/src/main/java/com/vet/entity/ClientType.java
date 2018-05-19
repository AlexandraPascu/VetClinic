package com.vet.entity;

public enum ClientType {

    STANDARD(0, 0),
    BRONZE(5, 5),
    SILVER(10, 10),
    GOLD(15, 15);

    private int targetNumberAppointments;
    private int discountPercent;

    private ClientType(int targetNumberAppointments, int discountPercent) {
        this.targetNumberAppointments = targetNumberAppointments;
        this.discountPercent = discountPercent;
    }

    public int getTargetNumberAppointments() {
        return targetNumberAppointments;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }
}
