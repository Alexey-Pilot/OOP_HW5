package presenters;

import jdk.jfr.RecordingState;
import models.Reservation;
import models.Table;
import models.TableModel;
import vievs.BookingView;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver{
    private final Model tableModel;
    private final View bookingView;

    public BookingPresenter(Model tableModel, View bookingView) {
        this.tableModel = tableModel;
        this.bookingView = bookingView;
        bookingView.setObserver(this);
    }
    public Collection<Table> loadTables(){
        return tableModel.loadTables();

    }
    public void updateTablesUI(){
        bookingView.showTables(loadTables());
    }
    public void updateReservationResultUI(int reservationID){
        bookingView.printReservationTableResult(reservationID);
    }

    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        int reservationNo = tableModel.reservationTable(orderDate, tableNo, name);
        updateReservationResultUI(reservationNo);
    }
    public void canselReservation(int oldReservation){
        tableModel.canselReservation(oldReservation);
        bookingView.printCancelReservationResult(oldReservation);
    }
    public void findReservation (int reservationId){
        Reservation reservation = tableModel.findReservation(reservationId);
        bookingView.printFoundedReservationResult(reservation);
    }
    public void changeReservationTable(int reservationId, int newTableNo){
        bookingView.printChangingTableResult(tableModel.changeReservationTable(reservationId, newTableNo), newTableNo);
    }

}

