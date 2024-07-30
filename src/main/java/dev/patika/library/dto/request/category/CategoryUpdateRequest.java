package dev.patika.library.dto.request.category;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdateRequest {
    @NotNull(message = "Please do not leave the id field empty !!!")
    private int id;

    @NotNull(message = "Please do not leave the name field empty !!!")
    private String name;

    @NotNull(message = "Please do not leave the description field empty !!!")
    private String description;
}
