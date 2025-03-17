package com.library.library_app.application.hateoas;

import org.springframework.hateoas.Link;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class BookUrlBuilder implements UrlBuilder {
    private final String baseUrl;

    public BookUrlBuilder() {
        this.baseUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUriString();
    }

    @Override
    public Link buildSelfLink(int offset, int limit) {
        return Link.of(baseUrl + "?offset=" + offset + "&limit=" + limit).withSelfRel();
    }

    @Override
    public Link buildNextLink(int offset, int limit, long totalElements) {
        return (offset + limit) < totalElements ? Link.of(baseUrl + "?offset=" + (offset + limit) + "&limit=" + limit).withRel("next") : null;
    }

    @Override
    public Link buildPrevLink(int offset, int limit) {
        return offset > 0 ? Link.of(baseUrl + "?offset=" + Math.max(0, offset - limit) + "&limit=" + limit).withRel("prev") : null;
    }

    @Override
    public Link buildLastLink(int offset, int limit, long totalElements) {
        return Link.of(baseUrl + "?offset=" + ((totalElements / limit) * limit) + "&limit=" + limit).withRel("last");
    }
}