package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Films {

    private String ID;
    private String movieName;
    private int movieDuration;
    private String movieGenre;
    private double price;
    private int remaining;
    private String IDroom;
    private int shift;
    private String movieRoom;
    private LocalTime showTimeStart;
    private LocalTime showTimeEnd;
    private LocalDate showDate;

    public Films(){

    }
    public Films(String ID,String movieName,int movieDuration,String movieGenre,double price,int remaining,LocalTime showTimeStart,LocalTime showTimeEnd,LocalDate showDate,String IDroom,String movieRoom,int shift){
        this.ID = ID;
        this.movieName = movieName;
        this.movieDuration = movieDuration;
        this.movieGenre = movieGenre;
        this.price = price;
        this.remaining = remaining;
        this.showTimeStart = showTimeStart;
        this.showTimeEnd = showTimeEnd;
        this.showDate = showDate;
        this.IDroom = IDroom;
        this.movieRoom = movieRoom;
        this.shift = shift;
    }

    public String getMovieRoom() {
        return movieRoom;
    }

    public void setMovieRoom(String movieRoom) {
        this.movieRoom = movieRoom;
    }

    public String getIDroom() {
        return IDroom;
    }

    public void setIDroom(String IDroom) {
        this.IDroom = IDroom;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public void setShowTimeStart(LocalTime showTimeStart) {
        this.showTimeStart = showTimeStart;
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

    public int getMovieDuration() {
        return movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public LocalTime getShowTimeStart() {
        return showTimeStart;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTimeStart = showTime;
    }

    public LocalTime getShowTimeEnd() {
        return showTimeEnd;
    }

    public void setShowTimeEnd(LocalTime showTimeEnd) {
        this.showTimeEnd = showTimeEnd;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public void display(){
        System.out.println("           Th??ng tin phim: ");
        System.out.println("                  M?? phim: " + getID());
        System.out.println("                 T??n Phim: " + getMovieName());
        System.out.println("            Th??? lo???i phim: " + getMovieGenre());
        System.out.println("         Th???i gian chi???u : "+ getMovieDuration());
        System.out.println("           S??? gh??? c??n l???i: " + getRemaining());
        System.out.println("          Th???i gian chi???u: t??? " + getShowTimeStart()+ " ?????n "+ getShowTimeEnd());
        System.out.println("               Ng??y chi???u: " + getShowDate());
    }

}
