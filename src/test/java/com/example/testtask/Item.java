package com.example.testtask;

public class Item {
    private final String itemType;
    private final String priceFrom;
    private final String priceTo;
    private final String item;

    public Item(String itemType, String priceFrom, String priceTo, String item) {
        this.itemType = itemType;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.item = item;
    }

    public String getItemType() {
        return itemType;
    }

    public String getPriceFrom() {
        return priceFrom;
    }

    public String getPriceTo() {
        return priceTo;
    }

    public String getItem() {
        return item;
    }
}
