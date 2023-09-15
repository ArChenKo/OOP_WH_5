package lesson5;

import lesson5.models.TableModel;
import lesson5.presenters.BookingPresenter;
import lesson5.views.BookingView;

import java.util.Date;

public class Program {

    /**
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);

        presenter.updateTablesUI();

        view.reservationTable(new Date(), 3, "Станислав");

        view.changeReservationTable(12, new Date(), 3, "Станислав"); // для примера

        view.changeReservationTable(11, new Date(), 3, "Станислав");
    }

}
