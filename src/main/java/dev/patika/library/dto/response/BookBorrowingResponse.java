package dev.patika.library.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingResponse {
    private int id;
    private String borrowerName;
    private String borrowerEmail;
    private int borrowingDate;
    private int returnDate;
    private int bookId;
}
