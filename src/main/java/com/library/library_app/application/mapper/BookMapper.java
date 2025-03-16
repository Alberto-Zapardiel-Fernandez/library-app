package com.library.library_app.application.mapper;

import com.library.application.controller.dto.BookDTO;
import com.library.application.controller.dto.PagedBookListDTO;
import com.library.library_app.domain.model.BookModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "books", qualifiedByName = "mapBookModelListToBookDtoList", source = "content")
    PagedBookListDTO bookModelToPagedBookListDto(PagedModel<BookModel> pagedModel);

    default BookDTO bookModelToBookDto(BookModel bookModel){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(bookModel.getId());
        bookDTO.setTitle(bookModel.getTitle());
        bookDTO.setAuthor(bookModel.getAuthor());
        bookDTO.setIsbn(bookModel.getIsbn());
        bookDTO.setAvailable(bookModel.getAvailable());
        return bookDTO;
    }

    @Named("mapBookModelListToBookDtoList")
    default List<BookDTO> mapBookModelListToBookDtoList(Collection<BookModel> bookModelList) {
        return bookModelList.stream()
                .map(this::bookModelToBookDto).toList();
    }
}