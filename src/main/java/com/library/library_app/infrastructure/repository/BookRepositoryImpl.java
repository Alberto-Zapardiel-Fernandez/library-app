package com.library.library_app.infrastructure.repository;

import com.library.library_app.domain.model.BookModel;
import com.library.library_app.domain.repository.BookRepository;
import com.library.library_app.infrastructure.mybatis.MyBatisBookMapper;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Book Repository Implementation.
 * This class implements the BookRepository interface.
 * It uses MyBatis to access the database.
 * It is annotated with @Repository to indicate that it is a repository.
 * It uses Lombok's @AllArgsConstructor to generate a constructor with all the arguments.
 * It has a single method getBooks that returns a PagedModel of BookModel.
 * This method retrieves a list of books from the database and maps them to BookModel objects.
 * The method returns a PagedModel with the list of BookModel objects and the pagination metadata.
 * The mapBookToBookModel method is used to map a Book entity to a BookModel object.
 * The BookModel object is then added to the list of BookModel objects.
 * The PagedModel is created using the PagedModel. Of method, passing the list of BookModel objects and the pagination metadata.
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
     * @param offset Number of items to skip.
     * @param limit  Number of items to return.
     * @return List of books with pagination links.
     */
    @Override
    public PagedModel<BookModel> getBooks(int offset, int limit) {
        List<BookModel> books = myBatisBookMapper.findAll(offset, limit);
        int total = myBatisBookMapper.count();

        return PagedModel.of(books, new PagedModel.PageMetadata(limit, offset, total));
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
}