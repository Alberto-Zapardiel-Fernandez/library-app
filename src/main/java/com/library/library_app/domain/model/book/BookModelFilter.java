package com.library.library_app.domain.model.book;

import lombok.Builder;
import lombok.Data;

/**
 * Book Model Filter.
 *
 * @author Alberto Zapardiel Fernández
 */
@Data
@Builder
public class BookModelFilter{
    private Integer limit;
    private Integer offset;
    private BookModel bookModel;
}
