package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

public class Table {
    private static int counter;
    private final int no;
    private final Collection<Reservation> reservations = new ArrayList<>();

    public Collection<Reservation> getReservations() {
        return reservations;
    }
    public void addReservation(Reservation reservation){
        reservations.add(reservation);
    }

    public int getNo() {
        return no;
    }

    {
        no = ++counter;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Table #%s", no);
    }
}
