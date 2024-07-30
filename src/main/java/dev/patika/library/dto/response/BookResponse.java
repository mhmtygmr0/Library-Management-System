package dev.patika.library.dto.response;

import dev.patika.library.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
    private int id;
    private String name;
    private LocalDate publicationYear;
    private int stock;
    private int authorId;
    private int publisherId;
    private List<Category> categories;
}
