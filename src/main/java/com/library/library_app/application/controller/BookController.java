package com.library.library_app.application.controller;

import   com.library.application.controller.api.BookApi;
import com.library.application.controller.dto.PagedBookListDTO;
import com.library.library_app.application.mapper.BookMapper;
import com.library.library_app.application.service.BookService;
import com.library.library_app.domain.model.BookModel;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Book Controller.
 *
 * @author Alberto Zapardiel Fernández
*/
@RestController
@AllArgsConstructor
public class BookController implements BookApi {

    private BookService bookService;

    private BookMapper bookMapper;

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

        PagedModel<BookModel> pagedModel = bookService.getBooks(offset.orElse(0), limit.orElse(10));

        PagedBookListDTO pagedBookListDTO = bookMapper.bookModelToPagedBookListDto(pagedModel);

        return ResponseEntity.ok(pagedBookListDTO);
    }

}
