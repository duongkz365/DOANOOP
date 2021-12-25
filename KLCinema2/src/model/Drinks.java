package model;

import java.time.LocalDate;

public class Drinks extends Foods{
    private String volume;
    LocalDate productionDate;
    LocalDate expirationDate;
    
    public Drinks(String ID, String foodName, double price,String volume,LocalDate productionDate, LocalDate expirationDate) {
        super(ID, foodName, price);
        if(volume.equals("big")){
            this.volume = volume;
        }else if(volume.equals("medium")){
            this.volume = volume;
        }else if(volume.equals("small")) {
            this.volume = volume;
        }else {
            this.volume = "small";
        }
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
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
        System.out.println("                 Thông tin đồ uống!");
        System.out.println("             Mã đồ uống: " + getID());
        System.out.println("            Tên đồ uống: " + getFoodName());
        System.out.println("               Thể tích: " + getVolume() + " ml");
        System.out.println("               Giá tiền: " + getPrice());
        System.out.println("          Ngày sản xuất: "+ getProductionDate());
        System.out.println("            Hạn sử dụng:" + getExpirationDate());
    }
}
