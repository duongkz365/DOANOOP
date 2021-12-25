package model;

public abstract class Foods {
    private String ID;
    private String foodName;
    private double price;

    public Foods(String ID,String foodName,double price){
        this.ID = ID;
        this.foodName = foodName;
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract  void display();
}
