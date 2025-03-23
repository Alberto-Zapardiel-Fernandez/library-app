package com.library.library_app.infrastructure.mybatis;

import com.library.library_app.domain.model.BookModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MyBatis Book Mapper.
 *
 * @author Alberto Zapardiel Fernández
*/
@Repository
public interface MyBatisBookMapper {

    /**
     * Find all books.
     * @param offset the offset
     * @param limit the limit
     * @return a list of books
     */
    List<BookModel> findAll(int offset, int limit);

    /**
     * The total of books
     * @return the total of books
     */
    int count();

    /**
     * Fina a book by his id
     * @param id the id
     * @return th ebook
     */
    BookModel findById(Integer id);

    /**
     * Find a book by his isbn
     * @param isbn the isbn
     * @return the book
     */
    BookModel findByIsbn(String isbn);

    /**
     * Create a book
     * @param model the book model
     * @return the row
     */
    int createBook(BookModel model);

    /**
     * Delete a book
     * @param id the id
     * @return the row
     */
    int deleteBook(Integer id);

    /**
     * Update a book
     * @param model the book model
     * @return the row
     */
    int updateBook(BookModel model);
}
