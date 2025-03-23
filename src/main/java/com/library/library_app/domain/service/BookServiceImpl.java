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

    /**
     * Get a book by id
     *
     * @param id the id
     * @return the book
     */
    @Override
    public BookModel getBookById(Integer id) {
        return bookRepository.getBookById(id);
    }

    /**
     * Get a book by isbn
     *
     * @param isbn the isbn
     * @return the book
     */
    @Override
    public BookModel getBookByIsbn(String isbn) {
        return bookRepository.getBookByIsbn(isbn);
    }

    /**
     * Create a book
     *
     * @param model the book model
     * @return the book
     */
    @Override
    public BookModel createBook(BookModel model) {
        return bookRepository.createBook(model);
    }

    /**
     * Update a book
     *
     * @param id@return the book
     */
    @Override
    public int deleteBook(Integer id) {
        return bookRepository.deleteBook(id);
    }

    /**
     * Update a book
     *
     * @param model the book model
     * @return the book
     */
    @Override
    public BookModel updateBook(BookModel model) {
        return bookRepository.updateBook(model);
    }

}
