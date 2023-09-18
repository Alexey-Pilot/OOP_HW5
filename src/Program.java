import models.Reservation;
import models.Table;
import models.TableModel;
import presenters.BookingPresenter;
import vievs.BookingView;

import java.util.Collection;
import java.util.Date;

public class Program {
    public static void main(String[] args) {
        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(model, view);
        bookingPresenter.updateTablesUI();
        view.reservationTable(new Date(), 1, "Сергей");
        view.reservationTable(new Date(), 2, "Иван");
        view.reservationTable(new Date(), 3, "Пётр");
        bookingPresenter.canselReservation(101);
        bookingPresenter.findReservation(102);
        bookingPresenter.changeReservationTable(103, 5);

    }


}
