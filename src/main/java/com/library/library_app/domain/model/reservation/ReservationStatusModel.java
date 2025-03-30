package com.library.library_app.domain.model.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Reservation Status Model
 * @author Alberto Zapardiel Fernández
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ReservationStatusModel {

    PENDING("PENDING"),
    ACTIVE("ACTIVE"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED");

    private String status;

    /**
     * Get the status value
     * @return the status value
     */
    public static ReservationStatusModel fromValue(String value) {
        for (ReservationStatusModel status : ReservationStatusModel.values()) {
            if (status.status.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid ReservationStatusModel value: " + value);
    }

}
