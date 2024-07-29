package dev.patika.library.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_borrowing")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowing_id", unique = true)
    private int id;

    @Column(name = "borrowing_borrower_name")
    private String borrowerName;

    @Email
    @Column(name = "borrowing_email", unique = true)
    private String borrowerEmail;

    @Column(name = "borrowing_date")
    private int borrowingDate;

    @Column(name = "borrowing_return_date")
    private int returnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrowing_book_id", referencedColumnName = "book_id")
    private Book book;
}
