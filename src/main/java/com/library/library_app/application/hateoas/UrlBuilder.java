package com.library.library_app.application.hateoas;

import org.springframework.hateoas.Link;

public interface UrlBuilder {
    Link buildSelfLink(int offset, int limit);
    Link buildNextLink(int offset, int limit, long totalElements);
    Link buildPrevLink(int offset, int limit);
    Link buildLastLink(int offset, int limit, long totalElements);
}