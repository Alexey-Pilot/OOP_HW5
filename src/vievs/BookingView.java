package vievs;

import models.Reservation;
import models.Table;
import presenters.View;
import presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {
    private ViewObserver observer;

    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void printReservationTableResult(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Столик успешно забронирован, номер вашей брони #%d\n", reservationNo);
        } else {
            System.out.println("Не удалось забронировать столик. Попробуйте выполнить операцию позже");
        }
    }

    @Override
    public void printCancelReservationResult(int reservationNo) {
        System.out.printf("Бронь #%d отменена\n", reservationNo);
    }

    @Override
    public void printFoundedReservationResult(Object reserv) {
        if (reserv instanceof Reservation reservation) {
            System.out.printf("%s,Ваша бронь #%d на %s\n", reservation.getName(), reservation.getId(), reservation.getDate().toString());
        } else System.out.println("Ваша бронь не найдена");
    }

    @Override
    public void printChangingTableResult(int reservationNo, int tableNo) {
        if (reservationNo != -1){
        System.out.printf("Ваша бронь #%d изменена, новый номер столика: #%d\n",reservationNo, tableNo);}else{
            System.out.println("Невозможно изменить номер столика");
        }
    }

    public void reservationTable(Date orderDate, int tableNo, String name) {
        observer.onReservationTable(orderDate, tableNo, name);
    }



}
