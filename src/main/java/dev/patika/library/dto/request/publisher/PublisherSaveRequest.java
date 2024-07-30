package dev.patika.library.dto.request.publisher;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherSaveRequest {
    @NotNull(message = "Please do not leave the name field empty !!!")
    private String name;

    @NotNull(message = "Please do not leave the establishmentYear field empty !!!")
    private LocalDate establishmentYear;

    @NotNull(message = "Please do not leave the address field empty !!!")
    private String address;
}
