package models;

import presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class TableModel implements Model {
    private Collection<Table> tables;

    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : loadTables()) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
        //throw new RuntimeException("Некорректный номер столика");
    }

    public Reservation findReservation(int reservationId) {
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == reservationId) {
                    return reservation;
                }
            }
        }
        return null;
    }

    public void canselReservation(int oldReservation) {
        for (Table table : tables) {
            table.getReservations().removeIf(reservation -> reservation.getId() == oldReservation);
        }
    }

    public int changeReservationTable(int reservationId, int newTableNo) {
        for (Table table : tables){
            for (Reservation reservation: table.getReservations()){
                if (reservation.getId() == reservationId){
                    for (Table table1 : tables){
                        if (table1.getNo() == newTableNo){
                            table1.addReservation(reservation);
                            return reservation.getId();

                        }
                    }
                    table.getReservations().remove(reservation);

                }
            }
        }
      return -1;
    }

    public Collection<Table> getTables() {
        return tables;
    }
}
