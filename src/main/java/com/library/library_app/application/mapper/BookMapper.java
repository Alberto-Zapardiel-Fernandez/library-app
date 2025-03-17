package com.library.library_app.application.mapper;

import com.library.application.controller.dto.BookDTO;
import com.library.application.controller.dto.LinksDTO;
import com.library.application.controller.dto.PagedBookListDTO;
import com.library.library_app.domain.model.BookModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.PagedModel;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface BookMapper {

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

    @Named("linksToLinksDTO")
    default LinksDTO linksModelToLinksDTO(Links links){
        LinksDTO linksDTO = new LinksDTO();

        Optional<Link> lastLink = links.getLink("last");
        lastLink.ifPresent(link -> linksDTO.setLast(link.getHref()));

        Optional<Link> nextLink = links.getLink("next");
        nextLink.ifPresent(link -> linksDTO.setNext(link.getHref()));

        Optional<Link> prevLink = links.getLink("prev");
        prevLink.ifPresent(link -> linksDTO.setPrev(link.getHref()));

        Optional<Link> selfLink = links.getLink("self");
        selfLink.ifPresent(link -> linksDTO.setSelf(link.getHref()));

        return linksDTO;
    }

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