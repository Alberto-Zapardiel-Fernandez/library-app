package com.library.library_app.infrastructure.repository;

import com.library.library_app.domain.model.reservation.ReservationModel;
import com.library.library_app.domain.repository.ReservationRepository;
import com.library.library_app.infrastructure.mybatis.MyBatisReservationMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Reservation repository Implementation
 * @author Alberto Zapardiel Fernández
*/
@AllArgsConstructor
@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    /**
     * Mybatis reservation mapper
     */
    private final MyBatisReservationMapper myBatisReservationMapper;

    /**
     * Create a new reservation
     *
     * @param reservation the reservation DTO
     * @return the created reservation
     */
    @Override
    public ReservationModel createReservation(ReservationModel reservation) {
        int result = myBatisReservationMapper.createReservation(reservation);
        return null;
    }

    /**
     * Update a reservation by id
     *
     * @param reservation the reservation DTO
     * @return the updated reservation
     */
    @Override
    public ReservationModel updateReservation(ReservationModel reservation) {
        int result = myBatisReservationMapper.updateReservation(reservation);
        return null;
    }
}
