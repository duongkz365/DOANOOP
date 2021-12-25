package model;

import java.time.LocalDate;

public class FastFoods extends Foods{
    private String size;
    LocalDate productionDate;
    LocalDate expirationDate;

    public FastFoods(String ID, String foodName, double price,String size,LocalDate productionDate,LocalDate expirationDate) {
        super(ID, foodName, price);
        if(size.equals("big")){
            this.size = size;
        }else if(size.equals("medium")){
            this.size = size;
        }else if(size.equals("small")) {
            this.size = size;
        }else {
            this.size = "small";
        }
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public void display() {
        System.out.println("Thông tin thức ăn nhanh!");
        System.out.println("   Mã thức ăn nhanh: " + getID());
        System.out.println("  Tên thức ăn nhanh: " + getFoodName());
        System.out.println("         Kích thước: "  + getSize());
        System.out.println("           Giá tiền: " + getPrice());
        System.out.println("      Ngày sản xuất: " + getProductionDate());
        System.out.println("        Hạn sử dụng: " + getExpirationDate());
    }
}
