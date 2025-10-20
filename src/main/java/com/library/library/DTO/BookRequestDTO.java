package com.library.library.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO implements Serializable {
    @NotBlank(message = "fileLink cannot be empty")
    private String fileLink;

    @NotBlank(message = "author cannot be empty")
    private String author;

    @NotBlank(message = "date cannot be empty")
    private LocalDate date;

    @NotBlank(message = "title cannot be empty")
    private String title;

    @Size(max = 1000, message = "Description should not exceed 1000 characters")
    private String description;

    @NotBlank(message = "genre cannot be empty")
    private String genre;
}
