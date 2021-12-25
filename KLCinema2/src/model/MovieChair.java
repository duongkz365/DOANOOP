package model;


public class MovieChair {

    private String seatCode;
    private String IDMovie;

    public MovieChair(String IDMovie, String seatCode) {
        this.seatCode = seatCode;
        this.IDMovie = IDMovie;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public String getIDMovie() {
        return IDMovie;
    }

    public void setIDMovie(String IDMovie) {
        this.IDMovie = IDMovie;
    }
}
