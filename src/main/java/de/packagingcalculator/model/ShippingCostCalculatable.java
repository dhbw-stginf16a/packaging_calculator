package de.packagingcalculator.model;

import java.util.List;

public interface ShippingCostCalculatable {
    public double calcShippingCosts(List<Packet> packets);
}
