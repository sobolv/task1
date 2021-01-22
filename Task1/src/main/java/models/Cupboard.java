package models;

import java.util.Objects;
public class Cupboard extends Furniture{
    private Long id;
    private String color;
    private int shelves;

    public Cupboard() {
        super();
        id = 1L;
        color = "";
        shelves = 0;
    }

    public Cupboard(String country, Double cost, int year, Shop shop, Long id1, String color, int shelves) {
        super(country, cost, year, shop);
        this.id = id1;
        this.color = color;
        this.shelves = shelves;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getShelves() {
        return shelves;
    }

    public void setShelves(int shelves) {
        this.shelves = shelves;
    }

    @Override
    public String toString() {
        return "Country of production: " + super.getCountry() +
                "\nCost: " + super.getCost() +
                "\nYear of production: " + super.getYear() +
                "\nColor: " + color + "\nNumber of shelves: " + shelves + "\nShop: " + super.getShop_id().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cupboard cupboard = (Cupboard) o;
        return shelves == cupboard.shelves && id.equals(cupboard.id) && color.equals(cupboard.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, shelves);
    }
}