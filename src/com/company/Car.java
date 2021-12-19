package com.company;

public class Car {
    private final String name;
    private final int productionYear;
    private final int powerEngine;
    private final int price;
    private final Color color;

    public Car(String name, int productionYear, int powerEngine, int price, Color color) {
        this.name = name;
        this.productionYear = productionYear;
        this.powerEngine = powerEngine;
        this.price = price;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public int getPowerEngine() {
        return powerEngine;
    }

    public int getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car {" +
                "name: " + name +
                ", productionYear: " + productionYear +
                ", powerEngine: " + powerEngine +
                ", price: " + price +
                ", color: " + color +
                "}";
    }
}
