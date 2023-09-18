package presenters;

import models.Reservation;
import models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {
    void showTables(Collection<Table> tables);
    void setObserver(ViewObserver observer);
    void printReservationTableResult(int reservationNo);
    void printCancelReservationResult(int reservationNo);
    void printFoundedReservationResult(Object reservation);
    void printChangingTableResult(int reservationNo, int tableNo);
}
