package dev.patika.library.dto.request.book;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequest {
    @NotNull(message = "Please do not leave the name field empty !!!")
    private String name;

    @NotNull(message = "Please do not leave the publicationYear field empty !!!")
    private LocalDate publicationYear;

    @NotNull(message = "Please do not leave the stock field empty !!!")
    private int stock;

    @Positive
    @NotNull(message = "Please do not leave the authorId field empty !!!")
    private int authorId;

    @Positive
    @NotNull(message = "Please do not leave the publisherId field empty !!!")
    private int publisherId;

    @NotNull(message = "Please do not leave the categories field empty !!!")
    private List<Integer> categoryId;

}
