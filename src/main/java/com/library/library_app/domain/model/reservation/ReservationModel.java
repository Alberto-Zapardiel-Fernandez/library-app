package com.library.library_app.domain.model.reservation;

import com.library.library_app.domain.model.book.BookModel;
import com.library.library_app.domain.model.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Reservation Model
 * @author Alberto Zapardiel Fernández
*/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationModel {

    /**
     * Reservation id
     */
    private Long id;

    /**
     * User id
     */
    private Long userId;

    /**
     * Book id
     */
    private Long bookId;

    /**
     * Reservation date
     */
    private LocalDate reservationDate;

    /**
     * Return date
     */
    private LocalDate returnDate;

    /**
     * Status
     */
    private ReservationStatusModel status;

    /**
     * User
     */
    private UserModel user;

    /**
     * Book
     */
    private BookModel book;
}
