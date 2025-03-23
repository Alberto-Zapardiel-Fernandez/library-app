package com.library.library_app.domain.model.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Paged Book Model.
 *
 * @author Alberto Zapardiel Fernández
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class PagedBookModel {
    private List<BookModel> books;
    private int total;
}
