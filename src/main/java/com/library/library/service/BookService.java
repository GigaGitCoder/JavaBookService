package com.library.library.service;

// Business logic

import com.library.library.DTO.BookResponseDTO;
import com.library.library.entity.Book;
import com.library.library.exception.BookNotFoundException;
import com.library.library.mapper.BookMapper;
import com.library.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    /*
    getAllBooks - returns page of all books from DB
    getBookById - returns book from DB by id
    createBook - create a new book in DB
    updateBook - update an existing book in DB
    deleteBookById - delete an existing book from DB by id
     */

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public Page<BookResponseDTO> getAllBooks(Pageable pageable) {
        return bookRepository.findAll(pageable).map(bookMapper::toDto);
    }

    public Optional<Book> getBookById(Long id) {
        return Optional.ofNullable(bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book was not Found")));
    }

    public Book createBook(
            String fileLink,
            String author,
            LocalDate date,
            String title,
            String description,
            String genre
    ) {
        Book book = Book.builder()
                .fileLink(fileLink)
                .author(author)
                .date(date)
                .title(title)
                .description(description)
                .genre(genre)
                .build();

        return bookRepository.save(book);
    }

    public void updateBook(
            Long id,
            String author,
            LocalDate date,
            String title,
            String description,
            String genre
    ) {

    }

}
