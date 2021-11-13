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
     * To test reservation manager thoroughly.
     * 
     */
    @Test
    public void ReservationMgrTestingFullReservation()
    {
        ReservationManager myRManager = new ReservationManager();
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 14, 1, 1, 1), "CustomerName", 1, 1, true);
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 14, 2, 1, 1), "CustomerName", 1, 1, true);
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 14, 3, 1, 1), "CustomerName", 1, 1, true);
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 14, 4, 1, 1), "CustomerName", 1, 1, true);
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 14, 5, 1, 1), "CustomerName", 1, 1, true);
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 14, 6, 1, 1), "CustomerName", 1, 1, true);
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 14, 7, 1, 1), "CustomerName", 1, 1, true);
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 14, 8, 1, 1), "CustomerName", 1, 1, true);
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 14, 9, 1, 1), "CustomerName", 1, 1, true);
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 14, 10, 1, 1), "CustomerName", 1, 1, true);
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 14, 11, 1, 1), "CustomerName", 1, 1, true);
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 14, 12, 1, 1), "CustomerName", 1, 1, true);
        // it appears that it can still book regardless if the pax is less than 10
        // it will also add the same customer again and again even though it is inside the table
    }

    @Test
    public void ReservationMgrTableExpired()
    {
        ReservationManager myRManager = new ReservationManager();
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 14, 2, 1, 1), "CustomerName", 1, 1, true);
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 14, 3, 1, 1), "CustomerName", 1, 1, true);
        myRManager.AddReservation(1, LocalDateTime.of(2021, 11, 12, 3, 1, 1), "CustomerName", 1, 1, true);
        // then it needs to check whether the reservation expired
        
    }
}
