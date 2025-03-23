package com.library.library_app.application.service;

import com.library.library_app.domain.model.book.BookModel;
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
     * @param limit  Number of items to return.
     * @param filter The book model entry
     * @return List of books with pagination links.
     */
    PagedModel<BookModel> getBooks(int offset, int limit, BookModel filter);

    /**
     * Get a book by id
     * @param id the id
     * @return the book
     */
    BookModel getBookById(Integer id);

    /**
     * Get a book by isbn
     * @param isbn the isbn
     * @return the book
     */
    BookModel getBookByIsbn(String isbn);

    /**
     * Create a book
     * @param model the book model
     * @return the book
     */
    BookModel createBook(BookModel model);

    /**
     * Delete a book
     * @param id the id
     * @return the book
     */
    int deleteBook(Integer id);

    /**
     * Update a book
     * @param model the book model
     * @return the book
     */
    BookModel updateBook(BookModel model);
}
