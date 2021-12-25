package model;

import java.time.LocalDate;
import java.time.LocalTime;

public interface Ticket {
    LocalDate getDay();
    void display();
    LocalTime getTime();
}
