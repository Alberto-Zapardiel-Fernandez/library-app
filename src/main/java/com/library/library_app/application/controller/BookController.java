package com.library.library_app.application.controller;

import com.library.application.controller.api.BookAPI;
import com.library.application.controller.dto.BookDTO;
import com.library.application.controller.dto.PagedBookListDTO;
import com.library.library_app.application.hateoas.BookUrlBuilder;
import com.library.library_app.application.hateoas.PaginationLinksGenerator;
import com.library.library_app.application.mapper.BookMapper;
import com.library.library_app.application.service.BookService;
import com.library.library_app.domain.model.BookModel;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

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
        return null;
    }

    /**
     * DELETE /delete_book/{id} : Delete a book by id.
     *
     * @param id The id of the book. (required)
     * @return No content. (status code 204)
     */
    @Override
    public ResponseEntity<Void> deleteBook(Integer id) {
        return null;
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
    public ResponseEntity<PagedBookListDTO> getBooks(Optional<Integer> offset, Optional<Integer> limit) {
        int offsetValue = offset.orElse(0);
        int limitValue = limit.orElse(10);
        PagedModel<BookModel> pagedModel = bookService.getBooks(offset.orElse(0), limit.orElse(10));

        BookUrlBuilder urlBuilder = new BookUrlBuilder();
        Links links = PaginationLinksGenerator.generateLinks(offsetValue, limitValue,
                Objects.requireNonNull(pagedModel.getMetadata()).getTotalElements(), urlBuilder);

        pagedModel.add(links);
        PagedBookListDTO pagedBookListDTO = bookMapper.bookModelToPagedBookListDto(pagedModel);

        return ResponseEntity.ok(pagedBookListDTO);
    }

    /**
     * PUT /update_book/{id} : Update a book by id.
     *
     * @param id      The id of the book. (required)
     * @param bookDTO (required)
     * @return The updated book data. (status code 200)
     * or Bad request response. (status code 400)
     * or Forbidden response. (status code 403)
     * or Not found response. (status code 404)
     */
    @Override
    public ResponseEntity<BookDTO> updateBook(Integer id, BookDTO bookDTO) {
        return null;
    }

}
