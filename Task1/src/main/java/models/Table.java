package models;

public class Table extends Furniture{
    private Long id;
    private String size;
    private Boolean boxes;

    public Table() {
        super();
        id = 1L;
        size = "";
        boxes = false;
    }

    public Table(String country, Double cost, int year, Shop shop, Long id1, String size, Boolean boxes) {
        super(country, cost, year, shop);
        this.id = id1;
        this.size = size;
        this.boxes = boxes;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public Boolean getBoxes() { return boxes; }

    public void setBoxes(Boolean boxes) { this.boxes = boxes; }

    @Override
    public String toString() {
        String answer;
        if(boxes){
            answer = "Yes";
        }else{
            answer = "No";
        }
        return "Country of production: " + super.getCountry() +
                "\nCost: " + super.getCost() +
                "\nYear of production: " + super.getYear() +
                "\nSize: " + size + "\nAre there any boxes: " + answer + "\nShop: " + super.getShop_id().toString();
    }
}

