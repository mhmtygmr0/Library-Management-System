package dev.patika.library.dto.request.borrowing;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingSaveRequest {
    @NotNull(message = "Please do not leave the borrowerName field empty !!!")
    private String borrowerName;

    @NotNull(message = "Please do not leave the borrowerEmail field empty !!!")
    private String borrowerEmail;

    @NotNull(message = "Please do not leave the borrowingDate field empty !!!")
    private LocalDate borrowingDate;

    @NotNull(message = "Please do not leave the returnDate field empty !!!")
    private LocalDate returnDate;

    @Positive
    @NotNull(message = "Please do not leave the bookId field empty !!!")
    private int bookId;
}
