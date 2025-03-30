package com.library.library_app.infrastructure.mybatis;

import com.library.library_app.domain.model.reservation.ReservationModel;
import org.springframework.stereotype.Repository;

/**
 * MyBatis Reservation Mapper
 * @author Alberto Zapardiel Fernández
*/
@Repository
public interface MyBatisReservationMapper {
    /**
     * Create a new reservation
     *
     * @param reservation the reservation DTO
     * @return the created reservation
     */
    int createReservation(ReservationModel reservation);

    /**
     * Update a reservation by id
     *
     * @param reservation the reservation DTO
     * @return the updated reservation
     */
    int updateReservation(ReservationModel reservation);
}
