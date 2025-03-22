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
}
