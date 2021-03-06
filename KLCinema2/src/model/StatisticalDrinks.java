package model;

import controller.CinemaFile;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StatisticalDrinks implements Statistical{
   public Scanner scanner = new Scanner(System.in);
   List<StatisticalDrinks> s = new ArrayList<>();
   CinemaFile f = new CinemaFile();

   private String ID;
   private String drinksID;
   private String drinksName;
   private String volume;
   private double price;
   private String customerID;
   private String customerName;
   private LocalDate purchaseDate;
   private LocalTime timeDate;

    public StatisticalDrinks() {
        s = f.readStatisticalDrinks();
    }

    public StatisticalDrinks(String ID,String drinksID, String drinksName, String volume, double price, String customerID, String customerName) {
        this.ID = ID;
        this.drinksID = drinksID;
        this.drinksName = drinksName;
        this.volume = volume;
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

    public String getDrinksID() {
        return drinksID;
    }

    public void setDrinksID(String drinksID) {
        this.drinksID = drinksID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getDrinksName() {
        return drinksName;
    }

    public void setDrinksName(String drinksName) {
        this.drinksName = drinksName;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
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

    public void setCusteomerID(String custeomerID) {
        this.customerID = custeomerID;
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
        System.out.println("Th???ng k?? n?????c u???ng theo ng??y");
        System.out.println("Vui l??ng nh???p ng??y c???n xem: ");
        String date;

        while(true){
            System.out.println("Nh???p ng??y c???n th???ng k?? (?????nh d???ng yyyy-mm-dd)");
            date = scanner.next();
            if(date.length()<10){
                System.out.println("Sai ?????nh D???ng");
            }else {
                String [] b= date.split("");
                if(!b[4].equals("-") && !b[7].equals("-")){
                    System.out.println("Sai ?????nh d???ng s");
                    System.out.println(b[4]);
                }else {
                    break;
                }
            }
        }

        int quantity = 0;
        double turnover = 0;
        System.out.println(date);
        for(int i = 0;i<s.size();i++){
            System.out.println(s.get(i).getTimeDate());
        }
        System.out.println("S??? n?????c b??n ???????c: " + quantity);
        System.out.println("Doanh thu trong ng??y: " + turnover);
    }

    @Override
    public void StatisticalMonth() {

        System.out.println("Th???ng k?? n?????c u???ng theo th??ng");

        String month;
        while(true){
            System.out.println("Nh???p th??ng c???n xem th??ng tin: (mm-yyyy) ");
            month = scanner.next();
            if(month.length()<7){
                System.out.println("Sai ?????nh D???ng");
            }else {
                String [] b= month.split("");
                if(!b[2].equals("-")){
                    System.out.println("Sai ?????nh d???ng");
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
        System.out.println("Doanh thu trong th??ng "+month+" l??: "+turnover+" VND");
        System.out.println("S??? l?????ng n?????c u???ng b??n ra: " + quantity);

    }

    @Override
    public void StatisticalYear() {
        System.out.println("Th???ng k?? n?????c u???ng theo n??m");
        System.out.println("Nh???p n??m c???n xem");
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
        System.out.println("Doanh thu trong n??m " + year+" l??: "+ turnover);
        System.out.println("S??? l?????ng n?????c u???ng b??n ???????c l?? : " + quantity);
    }
}
