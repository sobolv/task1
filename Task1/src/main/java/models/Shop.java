package models;

public class Shop {
    private Long id;
    private String name;
    private int number;

    public Shop() {
        id = 1L;
        name = null;
        number = 111111111;
    }

    public Shop(Long id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getNumber() { return number; }

    public void setNumber(int number) {
        if(number >= 100000000 && number <= 999999999) {
            this.number = number;
        }else{
            System.out.println("Incorrect number input");
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nNumber: +380" + number;
    }
}
