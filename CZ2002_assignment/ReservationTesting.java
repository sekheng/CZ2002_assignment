package CZ2002_assignment;

import java.time.LocalDateTime;

import org.junit.Test;

/**
 * Meant to test reservation manager
 * @author      Lee Sek Heng
 * @version     1.0	
 * @since        2021-11-13
 */
public class ReservationTesting {
    
    /**
     * To test reservation manager with full reservation
     */
    @Test
    public void ReservationMgrTestingFullReservation()
    {
        ReservationManager myRManager = new ReservationManager();
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 1, 1, 1), "CustomerName",  1, true, 1);
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 2, 1, 1), "CustomerName",  1, true, 2);
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 3, 1, 1), "CustomerName", 1, true,3);
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 4, 1, 1), "CustomerName",  1, true,4);
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 5, 1, 1), "CustomerName",  1, true,5);
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 6, 1, 1), "CustomerName",  1, true,6);
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 7, 1, 1), "CustomerName",  1, true,7);
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 8, 1, 1), "CustomerName",  1, true,8);
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 9, 1, 1), "CustomerName",   1,true,9);
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 10, 1, 1), "CustomerName",  1, true,10);
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 11, 1, 1), "CustomerName",  1, true,11);
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 12, 1, 1), "CustomerName",  1, true,12);
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 13, 1, 1), "CustomerName",  1, true,13);
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 14, 1, 1), "CustomerName",  1, true,14);
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 15, 1, 1), "CustomerName",  1, true,15);
        myRManager.AddReservation(7, LocalDateTime.of(2021, 11, 14, 16, 1, 1), "CustomerName",  1, true,16);

    }

    /**
     * To test reservation manager with expired reservation
     */
    @Test
    public void ReservationMgrTableExpired()
    {
        ReservationManager myRManager = new ReservationManager();
        myRManager.AddReservation(1, LocalDateTime.of(2022, 11, 14, 2, 1, 1), "CustomerName", 1,true,17);
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 13, 23, 15, 1), "CustomerName", 1, true,18);
        myRManager.AddReservation(1, LocalDateTime.of(2020, 11, 12, 3, 1, 1), "CustomerName", 1,true,19);
        myRManager.UpdateBookings();
        // then it needs to check whether the reservation expired
        Table Table1 = myRManager.GetTableByID(0);
        System.out.println("Table 1 Status " +Table1.getStatus());
        Table Table2 = myRManager.GetTableByID(1);
        System.out.println("Table 2 Status " + Table2.getStatus());
        Table Table3 = myRManager.GetTableByID(2);
        System.out.println("Table 3 Status " + Table3.getStatus());

    }
}
