package com.library.library.service;

import com.library.library.entity.Book;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class BookSpecification {

    private BookSpecification() {
    }

    public static Specification<Book> titleFilter(final String title) {
        return (root, query, criteriaBuilder) ->
                title == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("title")),
                        "%" + title.toLowerCase() + "%");
    }

    public static Specification<Book> authorFilter(final String author) {
        return (root, query, criteriaBuilder) ->
                author == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("author")),
                        "%" + author.toLowerCase() + "%");
    }

    public static Specification<Book> categoryFilter(final String genre) {
        return (root, query, criteriaBuilder) ->
                genre == null ? null : criteriaBuilder.equal(root.get("genre"), genre);
    }

}
