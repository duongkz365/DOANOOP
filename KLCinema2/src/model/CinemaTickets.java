package model;

import controller.CinemaFile;

import java.time.LocalDate;
import java.time.LocalTime;

public class CinemaTickets implements Ticket{

    private String ID;
    private String movieName;
    private String IDCustomer;
    private String CustomerName;
    private String seatCode;
    private double price;
    private LocalDate dateShow;
    private LocalTime timeShow;
    private LocalTime timebuy;
    private LocalDate purchaseDate;
    private String movieRoom;
    public CinemaTickets(String ID,String movieName,String IDCustomer,String CustomerName,String seatCode,String movieRoom,double price,LocalDate dateShow,LocalTime timeShow){
        this.ID = ID;
        this.movieName = movieName;
        this.IDCustomer = IDCustomer;
        this.CustomerName = CustomerName;
        this.seatCode = seatCode;
        this.movieRoom = movieRoom;
        this.price = price;
        this.dateShow = dateShow;
        this.timeShow = timeShow;
        this.timebuy = java.time.LocalTime.now();
        this.purchaseDate = java.time.LocalDate.now();
    }

    public String getMovieRoom() {
        return movieRoom;
    }

    public void setMovieRoom(String movieRoom) {
        this.movieRoom = movieRoom;
    }

    public LocalTime getTimebuy() {
        return timebuy;
    }

    public void setTimebuy(LocalTime timebuy) {
        this.timebuy = timebuy;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getIDCustomer() {
        return IDCustomer;
    }

    public void setIDCustomer(String IDCustomer) {
        this.IDCustomer = IDCustomer;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDateShow() {
        return dateShow;
    }

    public void setDateShow(LocalDate dateShow) {
        this.dateShow = dateShow;
    }

    public LocalTime getTimeShow() {
        return timeShow;
    }

    public void setTimeShow(LocalTime timeShow) {
        this.timeShow = timeShow;
    }

    @Override
    public LocalDate getDay() {
        return null;
    }

    @Override
    public void display() {
        System.out.println("Th??ng tin v?? xem phim: ");
        System.out.println("          M?? v??: " + getID());
        System.out.println("       T??n Phim: " + getMovieName());
        System.out.println("       Gi?? ti???n: " + getPrice());
        System.out.println("  M?? kh??ch h??ng: " + getIDCustomer());
        System.out.println(" T??n kh??ch h??ng: " + getCustomerName());
        System.out.println("       Ch??? ng???i: " + getSeatCode());
        System.out.println("     Ng??y Chi???u: " + getDateShow());
        System.out.println("      Gi??? Chi???u: " + getTimeShow());
    }

    @Override
    public LocalTime getTime() {
        return null;
    }
}
