package com.library.library_app.application.mapper;

import com.library.application.controller.dto.ReservationDTO;
import com.library.library_app.domain.model.reservation.ReservationModel;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Reservation Mapper
 * @author Alberto Zapardiel Fernández
*/
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ReservationMapper {

    /**
     * Convert ReservationDTO to ReservationModel
     *
     * @param reservationDTO the reservation DTO
     * @return the reservation model
     */
    ReservationModel toModel(ReservationDTO reservationDTO);

    /**
     * Convert ReservationModel to ReservationDTO
     *
     * @param reservation the reservation model
     * @return the reservation DTO
     */
    ReservationDTO toDTO(ReservationModel reservation);
}
