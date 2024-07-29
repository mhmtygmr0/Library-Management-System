package dev.patika.library.business.abstracts;

import dev.patika.library.entities.BookBorrowing;
import org.springframework.data.domain.Page;

public interface BookBorrowingService {
    BookBorrowing get(int id);

    Page<BookBorrowing> cursor(int page, int pageSize);

    BookBorrowing save(BookBorrowing bookBorrowing);

    BookBorrowing update(BookBorrowing bookBorrowing);

    boolean delete(int id);
}
