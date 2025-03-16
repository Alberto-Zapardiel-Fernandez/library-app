package com.library.library_app.application.service;

import com.library.library_app.domain.model.BookModel;
import org.springframework.hateoas.PagedModel;

/**
 * Book Service
 * This interface is the entry port for the application.
 *
 * @author Alberto Zapardiel Fernández
*/
public interface BookService {

    /**
     * Get a list of books.
     *
     * @param offset Number of items to skip.
     * @param limit Number of items to return.
     * @return List of books with pagination links.
    */
    PagedModel<BookModel> getBooks(int offset, int limit);
}
