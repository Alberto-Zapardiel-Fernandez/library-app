package com.library.library_app.application.controller;

import com.library.application.controller.api.BookAPI;
import com.library.application.controller.dto.BookDTO;
import com.library.application.controller.dto.PagedBookListDTO;
import com.library.library_app.application.hateoas.UrlBuilderImpl;
import com.library.library_app.application.hateoas.PaginationLinksGenerator;
import com.library.library_app.application.mapper.BookMapper;
import com.library.library_app.application.service.BookService;
import com.library.library_app.domain.model.book.BookModel;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * Book Controller.
 *
 * @author Alberto Zapardiel Fernández
*/
@RestController
@AllArgsConstructor
public class BookController implements BookAPI {

    /**
     * Book Service
     */
    private BookService bookService;

    /**
     * Book Mapper
     */
    private BookMapper bookMapper;

    /**
     * POST /create_book : Create a new book.
     *
     * @param bookDTO (required)
     * @return The created book. (status code 201)
     * or Bad request response. (status code 400)
     * or Forbidden response. (status code 403)
     * or Not found response. (status code 404)
     */
    @Override
    public ResponseEntity<BookDTO> createBook(BookDTO bookDTO) {
        BookModel model = bookMapper.bookDtoToBookModel(bookDTO);
        BookModel response = bookService.createBook(model);
        if (response == null || response.getId() == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(bookDTO, null, HttpStatus.CREATED);
        }
    }

    /**
     * DELETE /delete_book/{id} : Delete a book by id.
     *
     * @param id The id of the book. (required)
     * @return ERROR 500 or OK 200
     */
    @Override
    public ResponseEntity<Void> deleteBook(Integer id) {
        int response = bookService.deleteBook(id);
        if (response == 0){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    /**
     * GET /search_book/{id} : Get a book by id.
     *
     * @param id The id of the book. (required)
     * @return The book data. (status code 200)
     * or Bad request response. (status code 400)
     * or Forbidden response. (status code 403)
     * or Not found response. (status code 404)
     */
    @Override
    public ResponseEntity<BookDTO> getBook(Integer id) {
        BookModel response = bookService.getBookById(id);
        if (response == null) {
            return new ResponseEntity<>(new BookDTO(),null, HttpStatus.NOT_FOUND);
        }else{
        return new ResponseEntity<>(bookMapper.bookModelToBookDto(response), null , HttpStatus.OK);
        }
    }

    /**
     * GET /search_book/{isbn} : Get a book by isbn.
     *
     * @param isbn The id of the book. (required)
     * @return The book data. (status code 200)
     * or Bad request response. (status code 400)
     * or Forbidden response. (status code 403)
     * or Not found response. (status code 404)
     */
    @Override
    public ResponseEntity<BookDTO> getBookByIsbn(String isbn) {
        BookModel response = bookService.getBookByIsbn(isbn);
        if (response == null) {
            return new ResponseEntity<>(new BookDTO(),null, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(bookMapper.bookModelToBookDto(response), null , HttpStatus.OK);
        }
    }

    /**
     * GET /books : Get a list of books.
     *
     * @param offset Number of items to skip. (optional, default to 0)
     * @param limit  Number of items to return. (optional, default to 10)
     * @return List of books with pagination links. (status code 200)
     * or Bad request response. (status code 400)
     * or Forbidden response. (status code 403)
     * or Not found response. (status code 404)
     */
    @Override
    public ResponseEntity<PagedBookListDTO> getBooks(Integer offset, Integer limit, BookDTO body) {
        BookModel filter = bookMapper.bookDtoToBookModel(body);
        PagedModel<BookModel> pagedModel = bookService.getBooks(offset, limit, filter);

        UrlBuilderImpl urlBuilder = new UrlBuilderImpl();
        Links links = PaginationLinksGenerator.generateLinks(offset, limit,
                Objects.requireNonNull(pagedModel.getMetadata()).getTotalElements(), urlBuilder);

        pagedModel.add(links);
        PagedBookListDTO pagedBookListDTO = bookMapper.bookModelToPagedBookListDto(pagedModel);

        return ResponseEntity.ok(pagedBookListDTO);
    }

    /**
     * PUT /update_book/{id} : Update a book by id.
     *
     * @param bookDTO (required)
     * @return The updated book data. (status code 200)
     * or Bad request response. (status code 400)
     * or Forbidden response. (status code 403)
     * or Not found response. (status code 404)
     */
    @Override
    public ResponseEntity<BookDTO> updateBook(BookDTO bookDTO) {
        BookModel model = bookMapper.bookDtoToBookModel(bookDTO);
        BookDTO response = bookMapper.bookModelToBookDto(bookService.updateBook(model));
        if (response != null && response.getId() != null){
            return new ResponseEntity<>(response, null, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
