package models;

public abstract class Furniture {
    private String country;
    private Double cost;
    private int year;
    private Shop shop_id;

    public Furniture() {
        country = "Italy";
        cost = 2345.99;
        year = 2018;
        shop_id = new Shop();
    }

    public Furniture(String countryOfProduction, Double cost, int yearOfProduction, Shop shop) {
        this.country = countryOfProduction;
        this.cost = cost;
        this.year = yearOfProduction;
        this.shop_id = shop;
    }

    public String getCountry() { return country; }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getCost() { return cost; }

    public void setCost(Double cost) { this.cost = cost; }

    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }

    public Shop getShop_id() { return shop_id; }

    public void setShop_id(Shop shop_id) { this.shop_id = shop_id; }
}
