package presenters;

import models.Reservation;
import models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model  {
    Collection<Table> loadTables();
    int reservationTable(Date reservationDate, int tableNo, String name);
    Reservation findReservation(int reservationId);
    void canselReservation(int oldReservation);
    int changeReservationTable(int reservationId, int newTableNo);

}
