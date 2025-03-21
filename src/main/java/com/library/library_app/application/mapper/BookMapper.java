package com.library.library_app.application.mapper;

import com.library.application.controller.dto.BookDTO;
import com.library.application.controller.dto.PagedBookListDTO;
import com.library.library_app.domain.model.BookModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface BookMapper extends  LinksMapper{

    @Mapping(target = "books", qualifiedByName = "mapBookModelListToBookDtoList", source = "content")
    @Mapping(target = "links", source = "links", qualifiedByName = "linksToLinksDTO")
    PagedBookListDTO bookModelToPagedBookListDto(PagedModel<BookModel> pagedModel);

    @AfterMapping
    default void mapTotalElementsToLinksDTO(PagedModel<BookModel> pagedModel, @MappingTarget PagedBookListDTO target) {
        if (pagedModel != null && target.getLinks().isPresent()) {
            PagedModel.PageMetadata metadata = pagedModel.getMetadata();
            if (metadata != null) {
                target.getLinks().get().setCount(Optional.of((int) metadata.getTotalElements()));
            }
        }
    }

    default BookDTO bookModelToBookDto(BookModel bookModel){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(Optional.ofNullable(bookModel.getId()));
        bookDTO.setTitle(Optional.ofNullable(bookModel.getTitle()));
        bookDTO.setAuthor(Optional.ofNullable(bookModel.getAuthor()));
        bookDTO.setIsbn(Optional.ofNullable(bookModel.getIsbn()));
        bookDTO.setAvailable(Optional.ofNullable(bookModel.getAvailable()));
        return bookDTO;
    }

    @Named("mapBookModelListToBookDtoList")
    default List<BookDTO> mapBookModelListToBookDtoList(Collection<BookModel> bookModelList) {
        return bookModelList.stream()
                .map(this::bookModelToBookDto).toList();
    }
}