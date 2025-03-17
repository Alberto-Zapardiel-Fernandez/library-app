package com.library.library_app.application.hateoas;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Links;

import java.util.ArrayList;
import java.util.List;

public class PaginationLinksGenerator {

    public static Links generateLinks(int offset, int limit, long totalElements, UrlBuilder urlBuilder) {
        Link selfLink = urlBuilder.buildSelfLink(offset, limit);
        Link nextLink = urlBuilder.buildNextLink(offset, limit, totalElements);
        Link prevLink = urlBuilder.buildPrevLink(offset, limit);
        Link lastLink = urlBuilder.buildLastLink(offset, limit, totalElements);

        List<Link> links = new ArrayList<>();
        if (selfLink != null) {
            links.add(selfLink);
        }
        if (nextLink != null) {
            links.add(nextLink);
        }
        if (prevLink != null) {
            links.add(prevLink);
        }
        if (lastLink != null) {
            links.add(lastLink);
        }

        return Links.of(links);
    }
}