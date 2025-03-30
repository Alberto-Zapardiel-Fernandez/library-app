package com.library.library_app.domain.service;

import com.library.library_app.application.service.ReservationService;
import com.library.library_app.domain.model.reservation.ReservationModel;
import com.library.library_app.domain.repository.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Reservation Service Implementation
 * @author Alberto Zapardiel Fernández
*/
@AllArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {

    /**
     * Reservation repository
     */
    private ReservationRepository reservationRepository;

    /**
     * Create a new reservation
     *
     * @param reservation the reservation DTO
     * @return the created reservation
     */
    @Override
    public ReservationModel createReservation(ReservationModel reservation) {
        return reservationRepository.createReservation(reservation);
    }

    /**
     * Update a reservation by id
     *
     * @param reservation the reservation DTO
     * @return the updated reservation
     */
    @Override
    public ReservationModel updateReservation(ReservationModel reservation) {
        return reservationRepository.updateReservation(reservation);
    }
}
