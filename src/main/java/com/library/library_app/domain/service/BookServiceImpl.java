package com.library.library_app.domain.service;

import com.library.library_app.application.service.BookService;
import com.library.library_app.domain.model.BookModel;
import com.library.library_app.domain.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

/**
 * Book Service Implementation
 * @author Alberto Zapardiel Fernández
*/
@Service
@AllArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    /**
     * Book repository.
     */
    private BookRepository bookRepository;

    /**
     * Get a list of books.
     *
     * @param offset Number of items to skip.
     * @param limit  Number of items to return.
     * @return List of books with pagination links.
     */
    @Override
    public PagedModel<BookModel> getBooks(int offset, int limit) {
        return bookRepository.getBooks(offset, limit);
    }

}
