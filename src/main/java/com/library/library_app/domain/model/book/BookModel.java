package com.library.library_app.domain.model.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Book Model.
 *
 * @author Alberto Zapardiel Fernández
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BookModel {
    private Integer id;
    private String title;
    private String author;
    private String isbn;
    private Boolean available;
}
