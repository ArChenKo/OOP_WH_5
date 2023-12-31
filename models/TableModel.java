package lesson5.models;

import lesson5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    /**
     * Получить список столиков
     */
    public Collection<Table> loadTables(){

        if (tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate дата брони
     * @param tableNo номер столика
     * @param name имя заказчика
     * @return номер резерва
     */
    public int reservationTable(Date reservationDate, int tableNo, String name){
        for (Table t : tables){
            if (t.getNo() == tableNo){
                Reservation reservation = new Reservation(reservationDate, name);
                t.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
    }

    /**
     * Изменение брони - отмена бронирования столика
     * @param oldReservation - номер брони
     * @param reservationDate - дата брони
     * @param tableNo - номер столика
     * @param name - имя заказчика
     * @return - номер удаляемого резерва
     */
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name)
    {
        for (Table table : tables){
            if (table.getNo() == tableNo){
                Collection<Reservation> reservations = table.getReservations();
                for (Reservation reservation : reservations) {
                    if(reservation.getId() == oldReservation){
                        reservations.remove(reservation);
                        return oldReservation;
                    }
                }
            }
        }
        return -1;
    }


}
