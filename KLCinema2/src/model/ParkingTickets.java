package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class ParkingTickets implements Ticket{
    private String idTicket;
    private String vehicleType;
    private String numberPlate;
    private String customerID;
    private String customerName;
    private LocalDate dateIn;
    private LocalTime timeIn;

    public  ParkingTickets(){

    }
    public ParkingTickets(String id,String vehicleType,String numberPlate,String customerID,String customerName,LocalDate dateIn,LocalTime timeIn){
        this.idTicket = id;
        this.vehicleType = vehicleType;
        this.numberPlate = numberPlate;
        this.customerID = customerID;
        this.customerName = customerName;
        this.dateIn = dateIn;
        this.timeIn = timeIn;
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
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

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public LocalTime getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }

    @Override
    public LocalDate getDay() {
        return null;
    }

    @Override
    public void display() {
        System.out.println("   Th??ng tin v?? gi??? xe");
        System.out.println("        M?? v?? gi??? xe: " + getIdTicket());
        System.out.println("             Lo???i xe: " + getVehicleType());
        System.out.println("          Bi???n S??? xe: " + getNumberPlate());
        System.out.println("        M?? Kh??c H??ng: " + getCustomerID());
        System.out.println("      T??n Kh??ch h??ng: " + getCustomerName());
        System.out.println("   Th???i gian v??o g???i: " + getTimeIn());
        System.out.println("            Ng??y G???i: "+ getDateIn());
    }

    @Override
    public LocalTime getTime() {
        return null;
    }
}
