package model;

import controller.CinemaFile;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StatisticalFastFood implements Statistical{
    public Scanner scanner = new Scanner(System.in);
    List<StatisticalFastFood> s = new ArrayList<>();
    CinemaFile f = new CinemaFile();
    private String ID;
    private String foodID;
    private String foodname;
    private String size;
    private double price;
    private String customerID;
    private String customerName;
    private LocalDate purchaseDate;
    private LocalTime timeDate;

    public StatisticalFastFood(){
        s = f.readStatisticalFastFood();
    }
    public StatisticalFastFood(String ID,String foodID,String foodname,String size,double price,String customerName,String customerID){
        this.ID = ID;
        this.foodID = foodID;
        this.foodname = foodname;
        this.size = size;
        this.price = price;
        this.customerID = customerID;
        this.customerName = customerName;
        this.purchaseDate = java.time.LocalDate.now();
        this.timeDate = java.time.LocalTime.now();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalTime getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(LocalTime timeDate) {
        this.timeDate = timeDate;
    }

    @Override
    public void StatisticalDay() {
        System.out.println("Thống kê nước uống theo ngày");
        System.out.println("Vui lòng nhập ngày cần xem: ");
        String date;

        while(true){
            System.out.println("Nhập ngày cần thống kê (định dạng yyyy-mm-dd)");
            date = scanner.next();
            if(date.length()<10){
                System.out.println("Sai Định Dạng");
            }else {
                String [] b= date.split("");
                if(!b[4].equals("-") && !b[7].equals("-")){
                    System.out.println("Sai định dạng s");
                    System.out.println(b[4]);
                }else {
                    break;
                }
            }
        }

        int quantity = 0;
        double turnover = 0;

        for(int i = 0;i<s.size();i++){


            if(s.get(i).getPurchaseDate().equals(LocalDate.parse(date))){
                quantity++;
                turnover+=s.get(i).getPrice();

            }
        }

        System.out.println("Số thức ăn nhanh bán được trong ngày: " + quantity);
        System.out.println("Doanh thu trong ngày: " + turnover);
    }

    @Override
    public void StatisticalMonth() {
        System.out.println("Thống kê thức ăn nhanh theo tháng");

        String month;
        while(true){
            System.out.println("Nhập tháng cần xem thông tin: (mm-yyyy) ");
            month = scanner.next();
            if(month.length()<7){
                System.out.println("Sai Định Dạng");
            }else {
                String [] b= month.split("");
                if(!b[2].equals("-")){
                    System.out.println("Sai định dạng");
                }else {
                    break;
                }
            }
        }
        int quantity = 0;
        double turnover = 0;
        for(int i = 0;i<s.size();i++){
            String temp = s.get(i).getPurchaseDate().toString();
            String [] temp2 = temp.split("-");
            temp = temp2[1]+"-"+temp2[0];
            if(month.equals(temp)){
                quantity++;
                turnover += s.get(i).getPrice();
            }
        }
        System.out.println("Doanh thu trong tháng "+month+" là: "+turnover+" VND");
        System.out.println("Số lượng thức ăn nhanh bán ra: " + quantity);

    }


    @Override
    public void StatisticalYear() {
        System.out.println("Thống kê thức uống theo năm");
        System.out.println("Nhập năm cần xem");
        String year = scanner.next();
        int quantity = 0;
        double turnover = 0;
        for(int i = 0;i<s.size();i++){
            String temp = s.get(i).getPurchaseDate().toString();
            String [] temp2 = temp.split("-");
            temp = temp2[0];
            if(year.equals(temp)){
                quantity++;
                turnover = turnover + s.get(i).getPrice();
            }
        }
        System.out.println("Doanh thu trong năm " + year+" là: "+ turnover);
        System.out.println("Số lượng thức ăn nhanh bán được là : " + quantity);
    }

}
