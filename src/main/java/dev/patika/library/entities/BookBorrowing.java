package dev.patika.library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book_borrowing")
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowing_id", unique = true)
    private int id;

    @Column(name = "borrower_name")
    private String borrowerName;

    @Column(name = "borrowing_date")
    private int borrowingDate;

    @Column(name = "return_date")
    private int returnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrowing_book_id", referencedColumnName = "book_id")
    private Book book;
}
