package com.library.library_app.domain.repository;

import com.library.library_app.domain.model.BookModel;
import org.springframework.hateoas.PagedModel;

/**
 * Book Repository
 *
 * @author Alberto Zapardiel Fernández
 */
public interface BookRepository {

    /**
     * Get a list of books.
     *
     * @param offset Number of items to skip.
     * @param limit  Number of items to return.
     * @return List of books with pagination links.
     */
    PagedModel<BookModel> getBooks(int offset, int limit);

    /**
     * Get a book by id
     *
     * @param id the id
     * @return the book
     */
    BookModel getBookById(Integer id);

    /**
     * Get a book by isbn
     *
     * @param isbn the isbn
     * @return the book
     */
    BookModel getBookByIsbn(String isbn);

    /**
     * Create a book
     *
     * @param model the book model
     * @return the book
     */
    BookModel createBook(BookModel model);

    /**
     * Update a book
     *
     * @param id the id
     * @return the book
     */
    int deleteBook(Integer id);

    /**
     * Update a book
     *
     * @param model the book model
     * @return the book
     */
    BookModel updateBook(BookModel model);
}