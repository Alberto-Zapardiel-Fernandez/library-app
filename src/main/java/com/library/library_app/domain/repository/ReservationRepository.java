package com.library.library_app.domain.repository;

import com.library.library_app.domain.model.reservation.ReservationModel;

/**
 * Reservation Repository
 * @author Alberto Zapardiel Fernández
*/
public interface ReservationRepository {

    /**
     * Create a new reservation
     *
     * @param reservation the reservation DTO
     * @return the created reservation
     */
    ReservationModel createReservation(ReservationModel reservation);

    /**
     * Update a reservation by id
     *
     * @param reservation the reservation DTO
     * @return the updated reservation
     */
    ReservationModel updateReservation(ReservationModel reservation);
}
