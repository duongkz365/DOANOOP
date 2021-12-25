package model;

import java.time.LocalDate;

public class CinemaRoom {
    private String ID;
    private String roomName;
    private String shift1;
    private String shift2;
    private String shift3;
    private String shift4;
    private String shift5;
    private String shift6;
    private LocalDate date;

    public CinemaRoom(String ID,String roomName, String shift1, String shift2, String shift3, String shift4, String shift5, String shift6, LocalDate date) {
        this.ID = ID;
        this.roomName = roomName;
        this.shift1 = shift1;
        this.shift2 = shift2;
        this.shift3 = shift3;
        this.shift4 = shift4;
        this.shift5 = shift5;
        this.shift6 = shift6;
        this.date = date;
    }
    public String getID(){
        return ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getShift1() {
        return shift1;
    }

    public void setShift1(String shift1) {
        this.shift1 = shift1;
    }

    public String getShift2() {
        return shift2;
    }

    public void setShift2(String shift2) {
        this.shift2 = shift2;
    }

    public String getShift3() {
        return shift3;
    }

    public void setShift3(String shift3) {
        this.shift3 = shift3;
    }

    public String getShift4() {
        return shift4;
    }

    public void setShift4(String shift4) {
        this.shift4 = shift4;
    }

    public String getShift5() {
        return shift5;
    }

    public void setShift5(String shift5) {
        this.shift5 = shift5;
    }

    public String getShift6() {
        return shift6;
    }

    public void setShift6(String shift6) {
        this.shift6 = shift6;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
