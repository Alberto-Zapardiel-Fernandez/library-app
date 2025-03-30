package com.library.library_app.application.controller;

import com.library.application.controller.api.ReservationAPI;
import com.library.application.controller.dto.ReservationDTO;
import com.library.library_app.application.mapper.ReservationMapper;
import com.library.library_app.application.service.ReservationService;
import com.library.library_app.domain.model.reservation.ReservationModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Reservation Controller
 * @author Alberto Zapardiel Fernández
*/
@AllArgsConstructor
@RestController
public class ReservationController implements ReservationAPI {

    /**
     * Reservation mapper
     */
    private ReservationMapper mapper;

    /**
     * Reservation service
     */
    private ReservationService reservationService;

    /**
     * POST /create_reservation : Create a new reservation.
     *
     * @param reservationDTO (required)
     * @return The created reservation. (status code 201)
     * or Bad request response. (status code 400)
     * or Forbidden response. (status code 403)
     * or Not found response. (status code 404)
     */
    @Override
    public ResponseEntity<ReservationDTO> createReservation(ReservationDTO reservationDTO) {
        ReservationModel model = mapper.toModel(reservationDTO);
        ReservationDTO response = mapper.toDTO(reservationService.createReservation(model));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * PUT /update_reservation : Update a reservation by id.
     *
     * @param reservationDTO (required)
     * @return The created reservation. (status code 201)
     * or Bad request response. (status code 400)
     * or Forbidden response. (status code 403)
     * or Not found response. (status code 404)
     */
    @Override
    public ResponseEntity<ReservationDTO> updateReservation(ReservationDTO reservationDTO) {
        ReservationModel model = mapper.toModel(reservationDTO);
        ReservationDTO response = mapper.toDTO(reservationService.updateReservation(model));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
