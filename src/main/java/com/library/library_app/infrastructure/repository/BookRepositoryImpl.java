package com.library.library_app.infrastructure.repository;

import com.library.library_app.domain.model.BookModel;
import com.library.library_app.domain.model.BookModelFilter;
import com.library.library_app.domain.repository.BookRepository;
import com.library.library_app.infrastructure.mybatis.MyBatisBookMapper;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Book Repository Implementation.
 *
 * @author Alberto Zapardiel Fernández
 */
@Repository
@AllArgsConstructor
public class BookRepositoryImpl implements BookRepository {

    /**
     * MyBatis Book Mapper.
     */
    private MyBatisBookMapper myBatisBookMapper;

    /**
     * Get a list of books.
     *
     * @param filter Teh filter
     * @return List of books with pagination links.
     */
    @Override
    public PagedModel<BookModel> getBooks(BookModelFilter filter) {
        List<BookModel> books = myBatisBookMapper.findAll(filter);

        return PagedModel.of(books, new PagedModel.PageMetadata(filter.getLimit(), filter.getOffset(), books.size()));
    }

    /**
     * Get a book by id
     *
     * @param id the id
     * @return the book
     */
    @Override
    public BookModel getBookById(Integer id) {
        return myBatisBookMapper.findById(id);
    }

    /**
     * Get a book by isbn
     *
     * @param isbn the isbn
     * @return the book
     */
    @Override
    public BookModel getBookByIsbn(String isbn) {
        return myBatisBookMapper.findByIsbn(isbn);
    }

    /**
     * Create a book
     *
     * @param model the book model
     * @return the book
     */
    @Override
    public BookModel createBook(BookModel model) {
        int response = myBatisBookMapper.createBook(model);
        if (response != 1) {
            return new BookModel();
        } else {
            return myBatisBookMapper.findByIsbn(model.getIsbn());
        }
    }

    /**
     * Update a book
     *
     * @param id the id
     * @return the book
     */
    @Override
    public int deleteBook(Integer id) {
        int response = myBatisBookMapper.deleteBook(id);
        if (response != 1) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Update a book
     *
     * @param model the book model
     * @return the book
     */
    @Override
    public BookModel updateBook(BookModel model) {
        int response = myBatisBookMapper.updateBook(model);
        if (response != 1) {
            return new BookModel();
        } else {
            return myBatisBookMapper.findByIsbn(model.getIsbn());
        }
    }
}