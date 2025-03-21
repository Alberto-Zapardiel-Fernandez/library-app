package com.library.library_app.application.mapper;

import com.library.application.controller.dto.LinksDTO;
import org.mapstruct.Named;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;

import java.util.Optional;

/**
 * Links mapper
 *
 * @author Alberto Zapardiel Fernández
 */
public interface LinksMapper {

    @Named("linksToLinksDTO")
    default Optional<LinksDTO> linksModelToLinksDTO(Links links){
        LinksDTO linksDTO = new com.library.application.controller.dto.LinksDTO();

        Optional<Link> lastLink = links.getLink("last");
        lastLink.ifPresent(link -> linksDTO.setLast(Optional.of(link.getHref())));

        Optional<Link> nextLink = links.getLink("next");
        nextLink.ifPresent(link -> linksDTO.setNext(Optional.of(link.getHref())));

        Optional<Link> prevLink = links.getLink("prev");
        prevLink.ifPresent(link -> linksDTO.setPrev(Optional.of(link.getHref())));

        Optional<Link> selfLink = links.getLink("self");
        selfLink.ifPresent(link -> linksDTO.setSelf(Optional.of(link.getHref())));

        return Optional.of(linksDTO);
    }
}
