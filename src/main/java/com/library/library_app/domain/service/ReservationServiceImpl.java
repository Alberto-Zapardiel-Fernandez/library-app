package com.library.library_app.domain.service;

import com.library.library_app.application.service.ReservationService;
import com.library.library_app.domain.model.book.BookModel;
import com.library.library_app.domain.model.reservation.ReservationModel;
import com.library.library_app.domain.model.reservation.ReservationStatusModel;
import com.library.library_app.domain.repository.BookRepository;
import com.library.library_app.domain.repository.ReservationRepository;
import com.library.library_app.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
    private final ReservationRepository reservationRepository;

    /**
     * User repository
     */
    private final UserRepository userRepository;

    /**
     * Book Repository
     */
    private final BookRepository bookRepository;

    /**
     * Create a new reservation
     *
     * @param reservation the reservation DTO
     * @return the created reservation
     */
    @SneakyThrows
    @Override
    public ReservationModel createReservation(ReservationModel reservation) {
        // 1. Validar usuario
        if (userRepository.findByDni(reservation.getUser().getDni()) == null) {
            throw new NotFoundException("User not found with DNI: " + reservation.getUser().getDni());
        }
        // 2. Validar libro
        BookModel book = bookRepository.getBookByIsbn(reservation.getBook().getIsbn());
        if (book == null) {
            throw new NotFoundException("Book not found with ID: " + reservation.getBookId());
        }
        // 3. Validar disponibilidad del libro
        if (reservationRepository.isBookReserved(book.getId())) {
            throw new IllegalStateException("Book with ID: " + reservation.getBookId() + " is already reserved.");
        }
        // 4. (Implementar batch o algo que modifique el estado del libro, si se ha pasado la fecha de devolución)
        reservation.setReservationDate(LocalDate.now());
        reservation.setReturnDate(LocalDate.now().plusDays(15));
        reservation.setStatus(ReservationStatusModel.ACTIVE);

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
