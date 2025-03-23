package com.library.library_app.application.mapper;

import com.library.application.controller.dto.BookDTO;
import com.library.application.controller.dto.PagedBookListDTO;
import com.library.library_app.domain.model.book.BookModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper extends  LinksMapper{

    @Mapping(target = "books", qualifiedByName = "mapBookModelListToBookDtoList", source = "content")
    @Mapping(target = "links", source = "links", qualifiedByName = "linksToLinksDTO")
    PagedBookListDTO bookModelToPagedBookListDto(PagedModel<BookModel> pagedModel);

    @AfterMapping
    default void mapTotalElementsToLinksDTO(PagedModel<BookModel> pagedModel, @MappingTarget PagedBookListDTO target) {
        if (pagedModel != null && target.getLinks() != null) {
            PagedModel.PageMetadata metadata = pagedModel.getMetadata();
            if (metadata != null) {
                target.getLinks().setCount((int) metadata.getTotalElements());
            }
        }
    }

    BookModel bookDtoToBookModel(BookDTO dto);

    BookDTO bookModelToBookDto(BookModel model);

    @Named("mapBookModelListToBookDtoList")
    default List<BookDTO> mapBookModelListToBookDtoList(Collection<BookModel> bookModelList) {
        return bookModelList.stream()
                .map(this::bookModelToBookDto).toList();
    }

}