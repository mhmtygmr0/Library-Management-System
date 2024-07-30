package dev.patika.library.dto.request.author;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorUpdateRequest {
    @NotNull(message = "Please do not leave the id field empty !!!")
    private int id;

    @NotNull(message = "Please do not leave the name field empty !!!")
    private String name;

    @NotNull(message = "Please do not leave the birthDate field empty !!!")
    private LocalDate birthDate;

    @NotNull(message = "Please do not leave the country field empty !!!")
    private String country;
}
